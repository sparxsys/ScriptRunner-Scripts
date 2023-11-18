
import com.atlassian.jira.component.ComponentAccessor
import com.atlassian.jira.issue.CustomFieldManager
import com.atlassian.jira.issue.IssueManager
import com.atlassian.jira.issue.MutableIssue
import com.atlassian.jira.user.ApplicationUser
import org.apache.log4j.Level
import org.apache.log4j.Logger

IssueManager im = ComponentAccessor.getIssueManager()
MutableIssue issue = im.getIssueObject("SCRUM-25")

def log = Logger.getLogger("com.debug.url")
log.setLevel(Level.DEBUG)

CustomFieldManager customFieldManager = ComponentAccessor.getCustomFieldManager()
def customField = customFieldManager.getCustomFieldObjectsByName("User Picker (multiple users)")

log.debug(customField[0].getCustomFieldType())

if(customField) {

    def customFieldValue = issue.getCustomFieldValue(customField[0]) as ArrayList<ApplicationUser>
    return customFieldValue*.getKey()
}


