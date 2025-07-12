import qupath.lib.scripting.QP
import java.nio.file.Paths

// ------------------------------------------------------------------
// 1. Build the Path that points to the annotation folder
// ------------------------------------------------------------------
def homeDir  = System.getProperty('user.home')
def inputPath = Paths.get(
        homeDir,
        'Box', 'judits_work_keller_lab',
        'fe_si_models', 'merge_model_output', 'map_to_mucosa', 'output', 'map_to_mucosa'
)

// ------------------------------------------------------------------
// 2. Convert Path  ➜  File  (File(String) would also work)
// ------------------------------------------------------------------
def inputDir = inputPath.toFile()          // <— key change

// ------------------------------------------------------------------
// 3. Get image-specific information from the current project entry
// ------------------------------------------------------------------
def className = 'mapped_to_mucosa_lymphocytes'                   // update if you change class names
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
def pattern = ~/${shortName}_\d{2}_\d{2}_fe_si_combos_pv2_mv2_${className}\.geojson/

inputDir.eachFileMatch(pattern) { file ->
    println "Importing annotations from: ${file.absolutePath}"
    importObjectsFromFile(file.absolutePath)
}

println 'Done!'
