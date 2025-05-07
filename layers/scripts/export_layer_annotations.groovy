//Export annotations of defined class to defined location as geojson
// Update output directory & class name
import qupath.lib.scripting.QP
import qupath.lib.io.GsonTools
import qupath.lib.objects.PathAnnotationObject
import qupath.lib.projects.Project
import java.nio.file.Files
import java.nio.file.Paths

// Define the output directory (change this to your desired location)
def outputDir = Paths.get("/Users/jmwulcan/Library/CloudStorage/Box-Box/Projects/fe_si_models/layers/output/qupath_export_layer_annotations/") // Update this path
if (!Files.exists(outputDir)) {
    Files.createDirectories(outputDir)
}

// Define the class of annotations to export (change this to your desired class)
//def targetClasses = QP.getPathClass("content") // Update this class name

def targetClasses = [
	QP.getPathClass("roi"),
	QP.getPathClass("villi"),
	QP.getPathClass("crypts")
]

// Get the current project
def project = QP.getProject()

// Loop through all images in the project
project.getImageList().each { imageEntry ->
    // Load the image data for the current entry
    def imageData = imageEntry.readImageData()
    
    // Get the hierarchy and annotations
    def hierarchy = imageData.getHierarchy()
    def annotations = hierarchy.getAnnotationObjects()
    
    // Filter annotations by the target class
    def filteredAnnotations = annotations.findAll { it.getPathClass() in targetClasses }
    

    // Export each annotation as a GeoJSON file
    filteredAnnotations.eachWithIndex { annotation, index ->
    	// Get the annotation class name (if it exists)
    	def className = annotation.getPathClass()?.toString() ?: "Unclassified"
    	
    	
    	// Get the full image name
		def imageName = imageEntry.getImageName()
		
		// Extract only the part before ".vsi" if it exists, otherwise use the entire name
		def shortName = imageName.contains('.vsi') 
    	? imageName.substring(0, imageName.indexOf('.vsi')) 
    	: imageName
    	
    	// Create a unique filename for the GeoJSON file
		def fileName = "${shortName}_${className}_${index + 1}.geojson"
    	def outputPath = outputDir.resolve(fileName)
    
    	// Convert the annotation to GeoJSON
    	def gson = GsonTools.getInstance(true)
    	def geoJson = gson.toJson(annotation)
    
    	// Write the GeoJSON to the output file
    	Files.write(outputPath, geoJson.getBytes())
    
    	println("Exported annotation to: ${outputPath}")
	}
}

println("Export complete!")