
// Imports annotations of defined class with fragment numbers from defined input directory (run for project)
def inputDir = "/Users/jmwulcan/Library/CloudStorage/Box-Box/judits_work_keller_lab/fe_si_models/mucosa/output/mucosa/"

def className = "mucosa" // Update this with your class name

def entry = getProjectEntry()

def imageName = entry.getImageName()

def shortName = imageName.contains('.') 
    ? imageName.substring(0, imageName.indexOf('.')) 
    : imageName


// Glob pattern to match all files with fragment numbers
new File(inputDir).eachFileMatch(~/${shortName}_\d{2}_\d{2}_${className}\.geojson/) { file ->
    println("Importing annotations from: ${file.absolutePath}")
    importObjectsFromFile(file.absolutePath)
}

println("Done!")

println("Done!")

