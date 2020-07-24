import com.atlassian.jira.component.ComponentAccessor
import com.atlassian.jira.config.IssueTypeManager
import org.apache.log4j.Level
import org.apache.log4j.Logger

def log = Logger.getLogger("in.ravisagar.sr4j")
log.setLevel(Level.DEBUG)

IssueTypeManager issueTypeManager = ComponentAccessor.getComponent(IssueTypeManager)
issueTypeManager.getIssueTypes().each {

    log.debug(it.name + ": " + issueTypeManager.hasAssociatedIssues(it) )

}

