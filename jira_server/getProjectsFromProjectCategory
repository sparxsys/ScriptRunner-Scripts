import com.atlassian.jira.component.ComponentAccessor
import org.apache.log4j.Level
import org.apache.log4j.Logger


def log = Logger.getLogger("in.ravisagar.sr4j")
log.setLevel(Level.DEBUG)

def projectManager = ComponentAccessor.getProjectManager()

projectCategory = projectManager.getProjectCategoryObjectByName("Internal")

log.debug("Project Category: " + projectCategory.name)

def projects = projectManager.getProjectsFromProjectCategory(projectCategory)


projects.each { it ->

    log.debug(it.getComponents()*.name)
    log.debug(it.getProjectLead()*.username)
    log.debug(it.getVersions()*.name)
    log.debug(it.getProjectCategoryObject()?.name)

}

