import qupath.lib.scripting.QP
import qupath.lib.io.GsonTools
import java.nio.file.Files
import java.nio.file.Paths      // <- we keep Paths, drop Path

// 1. Build / create output directory ------------------------------
def homeDir   = System.getProperty('user.home')
def outputDir = Paths.get(
        homeDir,
        'Box', 'judits_work_keller_lab', 'fe_si_models', 'tissues',
        'output', 'export_tissue'
)

if (Files.notExists(outputDir))
    Files.createDirectories(outputDir)   // outputDir is already a Path

// 2. Choose classes to export --------------------------------------
def targetClasses = [ QP.getPathClass('tissue') ]   // wrap in list for `in`

// 3. Iterate through project images --------------------------------
def project = QP.getProject()
project.getImageList().each { imageEntry ->

    def imageData   = imageEntry.readImageData()
    def hierarchy   = imageData.getHierarchy()
    def annotations = hierarchy.getAnnotationObjects()
            .findAll { it.getPathClass() in targetClasses }

    println "Image ‘${imageEntry.getImageName()}’ – ${annotations.size()} tissue annotations"

    annotations.eachWithIndex { annotation, idx ->

        def className = annotation.getPathClass()?.toString() ?: 'Unclassified'
        def baseName  = imageEntry.getImageName().split('\\.')[0]
        def fileName  = "${baseName}_${className}_${idx+1}.geojson"
        def outPath   = outputDir.resolve(fileName)

        try {
            def geoJson = GsonTools.getInstance(true).toJson(annotation)
            Files.write(outPath, geoJson.getBytes())
            println "  ↳ wrote ${outPath.fileName}"
        } catch (Exception e) {
            println "  ↳ FAILED to write ${fileName}: ${e.message}"
        }
    }
}

println 'Export complete!'