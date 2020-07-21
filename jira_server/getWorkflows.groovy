import com.atlassian.jira.component.ComponentAccessor
import com.atlassian.jira.issue.IssueManager
import com.atlassian.jira.issue.MutableIssue
import com.atlassian.jira.workflow.WorkflowManager

WorkflowManager workflowManager = ComponentAccessor.getWorkflowManager()

//Get all workflows
// workflowManager.getWorkflows()

IssueManager im = ComponentAccessor.getIssueManager()
MutableIssue issue = im.getIssueObject("PM-1")
workflowManager.getWorkflow(issue).name
