/**
 * Code to fetch issue details
 * Video: https://youtu.be/3570FeZ7pqQ
 * Tested on version: Jira: 8.22.2, ScriptRunner for Jira: 6.50.0
 */
import com.atlassian.jira.component.ComponentAccessor
import com.atlassian.jira.issue.IssueManager

IssueManager im = ComponentAccessor.getIssueManager()
def issue = im.getIssueObject("DEMO-1")

return "Summary: ${issue.summary}, Assignee: ${issue.assignee?.displayName}, Status: $issue.status.name"
