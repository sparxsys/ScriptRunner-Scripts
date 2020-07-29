import com.atlassian.jira.component.ComponentAccessor
import com.atlassian.jira.issue.fields.config.manager.IssueTypeSchemeManager
import org.apache.log4j.Level
import org.apache.log4j.Logger


def log = Logger.getLogger("in.ravisagar.sr4j")
log.setLevel(Level.DEBUG)

IssueTypeSchemeManager issueTypeSchemeManager = ComponentAccessor.getIssueTypeSchemeManager()
def issueTypeToSearch = "Bug"
def projectList = []
issueTypeSchemeManager.getAllSchemes()*.getAssociatedProjectObjects().each { projects ->

  projects.each { project ->

      if (project.getIssueTypes()*.name.contains(issueTypeToSearch)) {
          projectList.add(project.name)

      }
  }
}

log.debug(projectList)
