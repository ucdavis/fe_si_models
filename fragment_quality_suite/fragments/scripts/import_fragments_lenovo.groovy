import qupath.lib.scripting.QP
import java.nio.file.Paths

def homeDir  = System.getProperty('user.home')
def inputDir = Paths.get(homeDir, 'Box', 'judits_work_keller_lab',
                         'fe_si_models', 'fragments', 'output', 'fragments')

def className  = 'fragments'
def entry      = getProjectEntry()
def imageName  = entry.getImageName()
def shortName  = imageName.contains('.') ? imageName.substring(0, imageName.indexOf('.')) : imageName
def fileName   = "${shortName}_${className}.geojson"

def pathInput  = inputDir.resolve(fileName)   // Path
println pathInput

importObjectsFromFile(pathInput.toString())   // Pass String to QuPath
println 'Done!'
