import com.atlassian.jira.component.ComponentAccessor
import com.atlassian.jira.issue.fields.config.manager.IssueTypeSchemeManager
import com.atlassian.jira.project.Project

IssueTypeSchemeManager issueTypeSchemeManager = ComponentAccessor.getIssueTypeSchemeManager()
issueTypeSchemeManager.getAllSchemes()*.name

Project project = ComponentAccessor.getProjectManager().getProjectByCurrentKey("SCRUM")
//Get issue types of a project
//issueTypeSchemeManager.getIssueTypesForProject(project)*.name
