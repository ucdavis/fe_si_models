
// Imports annotations of defined class with fragment numbers from defined input directory (run for project)
def inputDir = "/Users/jmwulcan/Library/CloudStorage/Box-Box/Projects/fe_si_models/si_mucosa/output/si_mucosa/"

def className = "si_mucosa" // Update this with your class name

def entry = getProjectEntry()

def imageName = entry.getImageName()

def shortName = imageName.contains('.vsi') 
    ? imageName.substring(0, imageName.indexOf('.vsi'))
    : imageName

// Glob pattern to match all files with fragment numbers
new File(inputDir).eachFileMatch(~/${shortName}_\d{2}_${className}\.geojson/) { file ->
    println("Importing annotations from: ${file.absolutePath}")
    importObjectsFromFile(file.absolutePath)
}

println("Done!")

println("Done!")

