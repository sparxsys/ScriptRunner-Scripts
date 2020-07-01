import com.atlassian.jira.component.ComponentAccessor
import com.atlassian.jira.issue.MutableIssue


def project = ComponentAccessor.projectManager.getProjectObjByKey("SCRUM")
def user = ComponentAccessor.jiraAuthenticationContext.loggedInUser


MutableIssue issue = ComponentAccessor.issueFactory.issue
issue.projectObject = project
issue.summary = "Demo issue created from the script"
issue.issueTypeId = 10102
issue.assignee = user
ComponentAccessor.issueManager.createIssueObject(user, issue)

