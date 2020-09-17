import com.atlassian.jira.component.ComponentAccessor
import com.atlassian.jira.issue.IssueManager
import org.apache.log4j.Level
import org.apache.log4j.Logger


def log = Logger.getLogger("pro.ravi.sr4j")
log.setLevel(Level.DEBUG)

IssueManager im = ComponentAccessor.getIssueManager()
def issue = im.getIssueObject("SCRUM-14")

log.debug(issue.getTimeSpent())

log.debug(issue.getOriginalEstimate())
