import com.atlassian.jira.component.ComponentAccessor
import com.atlassian.jira.event.type.EventDispatchOption
import com.atlassian.jira.issue.IssueManager
import com.atlassian.jira.issue.MutableIssue
import com.atlassian.jira.user.ApplicationUser
import org.apache.log4j.Level
import org.apache.log4j.Logger


def log = Logger.getLogger("in.ravisagar.sr4j")
log.setLevel(Level.DEBUG)

IssueManager im = ComponentAccessor.getIssueManager()
def issue = im.getIssueObject("SCRUM-25") as MutableIssue

ApplicationUser user = ComponentAccessor.getUserManager().getUserByName("admin")

im.deleteIssue(user, issue, EventDispatchOption.ISSUE_DELETED, false)
