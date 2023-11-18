import com.atlassian.jira.component.ComponentAccessor
import org.apache.log4j.Level
import org.apache.log4j.Logger


def log = Logger.getLogger("in.ravisagar.sr4j")
log.setLevel(Level.DEBUG)

def projectManager = ComponentAccessor.getProjectManager()

projectManager.getArchivedProjects().each { it ->

    log.debug(it.key)
    log.debug(it.getIssueTypes()*.name)
    log.debug(it.getComponents()*.name)
    log.debug(it.getProjectLead()*.username)
    log.debug(it.getVersions()*.name)
    log.debug(it.getProjectCategoryObject()?.name)
    log.debug(it.archived)

}


