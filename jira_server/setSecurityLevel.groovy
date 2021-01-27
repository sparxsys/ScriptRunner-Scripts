import com.atlassian.jira.component.ComponentAccessor
import com.atlassian.jira.event.type.EventDispatchOption

def issue = ComponentAccessor.getIssueManager().getIssueObject("ISD-2")
issue.setSecurityLevelId(10000)

def user = ComponentAccessor.getJiraAuthenticationContext().getLoggedInUser()
def issueManager = ComponentAccessor.getIssueManager()

issueManager.updateIssue(user,issue,EventDispatchOption.DO_NOT_DISPATCH,true)
