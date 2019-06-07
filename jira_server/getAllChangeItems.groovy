import com.atlassian.jira.issue.IssueManager;
import com.atlassian.jira.issue.MutableIssue;
import com.atlassian.jira.issue.link.IssueLink

import com.atlassian.jira.component.ComponentAccessor;

IssueManager im = ComponentAccessor.getIssueManager();
MutableIssue issue = im.getIssueObject("ANDROID-38");


def changeHistoryManager = ComponentAccessor.getChangeHistoryManager()
def created
def fromvalue
def tovalue
def changefield
def output = ""

for (change in changeHistoryManager.getAllChangeItems(issue) ) {
    
    
	 created = change.created.toString()
	 fromvalue = change.getFrom().toString()
	 tovalue = change.getTo().toString()
     changefield = change.field
    
    output = output + created + ': ' + changefield + ': ' + fromvalue + ' -> ' + tovalue + '<br/>'
    
}



return output
