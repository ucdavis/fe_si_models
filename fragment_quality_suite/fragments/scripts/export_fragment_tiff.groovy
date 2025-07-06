import qupath.lib.regions.RegionRequest
import qupath.lib.images.servers.ImageServer
import qupath.lib.images.writers.ImageWriterTools

def imageData = getCurrentImageData()
def server = imageData.getServer()
def imageName = server.getMetadata().getName().split("\\.")[0] 
def annotations = getAnnotationObjects().findAll { it.getPathClass()?.toString() == "included" }

def homeDir = System.getProperty('user.home')
def outputDir = buildFilePath(homeDir,
    'Box', 'Projects', 'fe_si_samples',
    'labl_2025_clonality', 'output', 'qupath_fragments')
    

annotations.each { annotation ->
    def roi = annotation.getROI()
    def annotationName = annotation.getName() ?: "unnamed"
    def x0 = (int) roi.getBoundsX()
    def y0 = (int) roi.getBoundsY()
    def requestROI = RegionRequest.createInstance(server.getPath(), 1, roi)
    def outputPath = buildFilePath(outputDir, "${imageName}_${annotationName}_x${x0}_y${y0}.tiff")
    
    try {
        ImageWriterTools.writeImageRegion(server, requestROI, outputPath)
        println("Exported fragment to: ${outputPath}")
    } catch (Exception e) {
        println("Error exporting fragment ${annotationName}: ${e.getMessage()}")
    }
}

 
     