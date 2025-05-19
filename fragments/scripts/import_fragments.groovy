
//Imports annotation of defined class from defined input dir (run for project)
def inputDir = "/Users/jmwulcan/Library/CloudStorage/Box-Box/Projects/fe_si_models/fragments/output/fragments/"

def className = "fragments" 

def entry = getProjectEntry()

def imageName = entry.getImageName()

def shortName = imageName.contains('.') 
    ? imageName.substring(0, imageName.indexOf('.')) 
    : imageName

def fileName = "${shortName}_${className}.geojson"

def inputPath = new File(inputDir, fileName)

def pathInput = buildFilePath(inputDir, fileName)
println(pathInput)

importObjectsFromFile(pathInput)

println("Done!")

