
// Imports annotations of defined class with fragment numbers from defined input directory (run for project)
def inputDir = "/Users/jmwulcan/Library/CloudStorage/Box-Box/Projects/fe_si_models/layers/output/aiforia_annotations/"
def className = "fe_si_layers_pv6_annotations" // Update this with your class name

def entry = getProjectEntry()
def imageName = entry.getImageName()

def shortName = imageName.contains('.vsi') 
    ? imageName.substring(0, imageName.indexOf('.vsi'))
    : imageName

def dir = new File(inputDir)

if (!dir.exists()) {
    println("Input directory does not exist: ${inputDir}")
} else {
    println("Listing all .geojson files in: ${inputDir}")
    dir.eachFileMatch(~/.*\.geojson/) { file ->
        println("- Found: ${file.name}")
    }

    println("\nLooking for files matching pattern: ${shortName}_${className}.geojson")

    def matched = false
    dir.eachFileMatch(~/${shortName}_${className}\.geojson/) { file ->
        matched = true
        println("✅ Importing annotations from: ${file.absolutePath}")
        importObjectsFromFile(file.absolutePath)
    }

    if (!matched) {
        println("⚠️  No files matched the pattern for: ${shortName}_\\d{2}_${className}.geojson")
    }
}

println("Done!")
