import com.atlassian.jira.issue.Issue;
import com.atlassian.jira.issue.IssueManager;
import com.atlassian.jira.issue.MutableIssue;
import com.atlassian.jira.component.ComponentAccessor;
 
IssueManager im = ComponentAccessor.getIssueManager();
MutableIssue issue = im.getIssueObject("IOS-10");
//return issue.getSummary();
//return issue.getStatus().name;
return issue.getPriority().name;