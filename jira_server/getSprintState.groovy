import com.atlassian.jira.component.ComponentAccessor
import com.atlassian.jira.issue.IssueManager
import com.atlassian.jira.issue.CustomFieldManager

IssueManager im = ComponentAccessor.getIssueManager()

def issue = im.getIssueObject("KEY-1234")

CustomFieldManager customFieldManager = ComponentAccessor.getCustomFieldManager()
def customField = customFieldManager.getCustomFieldObjectsByName("Sprint").first()

def sprint = issue.getCustomFieldValue(customField)

sprint.findAll{it.active == true || it.future == true}.last().id
//sprint.findAll{it.closed == true}.last()

//Active Sprint
sprint.findAll { it.active == true }*.name

//Closed Sprint
sprint.findAll { it.closed == true }*.name

//Future Sprint
sprint.findAll { it.future == true }*.name