import qupath.lib.scripting.QP
import java.nio.file.Paths



def inputDir = new File("/Users/jmwulcan/Library/CloudStorage/Box-Box/judits_work_keller_lab/fe_si_models/merge_model_output/map_to_fragment/output/map_to_fragment/")

// ------------------------------------------------------------------
// 3. Get image-specific information from the current project entry
// ------------------------------------------------------------------
def className = 'lymphocytes'                   // update if you change class names
def entry     = getProjectEntry()
def imageName = entry.getImageName()

// Strip the file extension (if any) to get a “short” slide name
def shortName = imageName.contains('.')
        ? imageName.substring(0, imageName.indexOf('.'))
        : imageName

// ------------------------------------------------------------------
// 4. Import every GeoJSON whose name matches
//       <shortName>_NN_NN_<className>.geojson
//    where NN = two-digit fragment numbers
// ------------------------------------------------------------------
def pattern = ~/${shortName}_\d{2}_fe_si_combos_pv2_mv2_${className}\.geojson/

inputDir.eachFileMatch(pattern) { file ->
    println "Importing annotations from: ${file.absolutePath}"
    importObjectsFromFile(file.absolutePath)
}

println 'Done!'
