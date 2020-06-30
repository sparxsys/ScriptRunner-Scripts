import com.atlassian.jira.component.ComponentAccessor
import com.atlassian.jira.project.UpdateProjectParameters
import org.apache.log4j.Level
import org.apache.log4j.Logger


def log = Logger.getLogger("in.ravisagar.sr4j")
log.setLevel(Level.DEBUG)

def projectManager = ComponentAccessor.getProjectManager()
def project = projectManager.getProjectObjByName("Renamed Project")

if(project) {
    def updateProjectParameters = UpdateProjectParameters.forProject(project.id).name("Trying again")
    projectManager.updateProject(updateProjectParameters)
    log.debug("Project renamed")
}
else {
    log.debug("Project doesn't exist")
}




