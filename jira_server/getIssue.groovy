import com.atlassian.jira.component.ComponentAccessor
import com.atlassian.jira.issue.IssueManager

IssueManager im = ComponentAccessor.getIssueManager()
def issue = im.getIssueObject("DEMO-1")

return "Summary: ${issue.summary}, Assignee: ${issue.assignee?.displayName}, Status: $issue.status.name"
