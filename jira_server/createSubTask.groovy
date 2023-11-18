import com.atlassian.jira.component.ComponentAccessor
import com.atlassian.jira.issue.MutableIssue


def project = ComponentAccessor.projectManager.getProjectObjByKey("SCRUM")
def user = ComponentAccessor.jiraAuthenticationContext.loggedInUser

def parentIssue = ComponentAccessor.issueManager.getIssueByCurrentKey("SCRUM-38")


//return project.issueTypes*.id
MutableIssue issue = ComponentAccessor.issueFactory.issue
issue.projectObject = project
issue.summary = "This is a sub task"
issue.issueTypeId = 10201
issue.assignee = user
ComponentAccessor.issueManager.createIssueObject(user, issue)

ComponentAccessor.subTaskManager.createSubTaskIssueLink(parentIssue, issue, user)
