//delete all annotations (or annotations of specified class) in project 
import qupath.lib.scripting.QP
import qupath.lib.projects.Project

// Get the current project
def project = QP.getProject()

def classesToDelete = ["included_fragment", "duplicate", "villi_only", "crypts_only", "no_si"]

// Loop through all images in the project
project.getImageList().each { imageEntry ->
    // Load the image data for the current entry
    def imageData = imageEntry.readImageData()
    
    // Get the hierarchy and annotations
    def hierarchy = imageData.getHierarchy()
    def annotations = hierarchy.getAnnotationObjects()
    
    // Filter annotations with classification "content"
    def annotationsToDelete = annotations.findAll { annotation ->
        def pathClass = annotation.getPathClass()
        pathClass != null && classesToDelete.any { it.equalsIgnoreCase(pathClass.getName()) }
    }
    
    // Remove filtered annotations if any exist
    if (!annotationsToDelete.isEmpty()) {
        hierarchy.removeObjects(annotationsToDelete, true) // true = remove from hierarchy
        println "Removed ${annotationsToDelete.size()}  annotations from ${imageEntry.getImageName()}"
    } else {
        println "No  annotations found in ${imageEntry.getImageName()}"
    }
    
    // Remove all annotations
    //if (!annotations.isEmpty()) {
//        hierarchy.removeObjects(annotations, true) // true = remove from hierarchy
//        println "Removed ${annotations.size()} annotations from ${imageEntry.getImageName()}"
//    } else {
//        println "No annotations found in ${imageEntry.getImageName()}"
//    }
    
    // Save the changes to the image data
    imageEntry.saveImageData(imageData)
}

// Sync the project to save all changes
project.syncChanges()

println "All annotations deleted in the project!"