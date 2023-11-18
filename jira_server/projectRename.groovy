import com.atlassian.jira.component.ComponentAccessor
import com.atlassian.jira.project.UpdateProjectParameters
import org.apache.log4j.Level
import org.apache.log4j.Logger


def log = Logger.getLogger("in.ravisagar.sr4j")
log.setLevel(Level.DEBUG)

def projectManager = ComponentAccessor.getProjectManager()
def project = projectManager.getProjectObjByName("Old project")

if(project) {
    def updateProjectParameters = UpdateProjectParameters.forProject(project.id).name("New project")
    projectManager.updateProject(updateProjectParameters)
    log.debug("Project renamed")
}
else {
    log.debug("Project doesn't exist")
}




