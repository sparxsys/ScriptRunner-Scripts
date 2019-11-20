/**
* Code to retrieve the first assignee of the issue from the
* Change History and assignee the issue back to that user
**/
import com.atlassian.jira.issue.IssueManager
import com.atlassian.jira.issue.MutableIssue
import com.atlassian.jira.issue.link.IssueLink
import com.atlassian.jira.component.ComponentAccessor
import com.atlassian.jira.user.ApplicationUser


IssueManager im = ComponentAccessor.getIssueManager();
MutableIssue issue = im.getIssueObject("ANDROID-41");


def changeHistoryManager = ComponentAccessor.getChangeHistoryManager()
def firstAssignee=changeHistoryManager.getChangeItemsForField(issue, "assignee")
def firstNotNullAssignee = firstAssignee[0]?.from ?: firstAssignee[0]?.to

//return firstNotNullAssignee

ApplicationUser user = ComponentAccessor.getUserManager().getUserByName(firstNotNullAssignee.toString())

def issueService = ComponentAccessor.getIssueService()

def validateAssignResult = issueService.validateAssign(user, issue.id, issue.reporterId)
issueService.assign(user, validateAssignResult)