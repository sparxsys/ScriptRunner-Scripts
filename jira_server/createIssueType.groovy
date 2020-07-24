import com.atlassian.jira.component.ComponentAccessor
import com.atlassian.jira.config.IssueTypeManager

IssueTypeManager issueTypeManager = ComponentAccessor.getComponent(IssueTypeManager)

// Get all the existing avatar id
// issueTypeManager.getIssueTypes()*.avatar*.id

issueTypeManager.createIssueType("Test Campaign", "This is a bundle of test cases", 10316)
issueTypeManager.getIssueTypes()*.name
