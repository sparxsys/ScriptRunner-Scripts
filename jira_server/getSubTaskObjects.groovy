import com.atlassian.jira.issue.IssueManager;
import com.atlassian.jira.issue.MutableIssue;
import com.atlassian.jira.component.ComponentAccessor;

IssueManager im = ComponentAccessor.getIssueManager();
MutableIssue issue = im.getIssueObject("ANDROID-38");

def output = ""
for (e in issue.getSubTaskObjects()) {
    
	output = output + e.getSummary()  +"," + e.issueType.name + "<br/>"
    
}

return output

//MutableIssue sub_issue = im.getIssueObject(issue.getSubTaskObjects()[1].toString());

//return sub_issue