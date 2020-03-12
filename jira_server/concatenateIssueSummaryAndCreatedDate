import com.atlassian.jira.issue.IssueManager
import com.atlassian.jira.issue.MutableIssue
import com.atlassian.jira.component.ComponentAccessor
import com.atlassian.jira.issue.util.DefaultIssueChangeHolder
import com.atlassian.jira.issue.ModifiedValue

IssueManager im = ComponentAccessor.getIssueManager()
MutableIssue issue = im.getIssueObject("SD-18") //Change Issue Key

return issue.summary + " - " + issue.created
