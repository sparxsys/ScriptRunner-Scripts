/**
* How to fetch the base url of a Jira issue
* Video link: https://youtu.be/Oym0h65qiLk
*/

import com.atlassian.jira.issue.IssueManager
import com.atlassian.jira.issue.MutableIssue
import com.atlassian.jira.component.ComponentAccessor
import com.atlassian.jira.issue.util.DefaultIssueChangeHolder
import com.atlassian.jira.issue.ModifiedValue

IssueManager im = ComponentAccessor.getIssueManager()
MutableIssue issue = im.getIssueObject("ANDROID-126")

def baseurl = com.atlassian.jira.component.ComponentAccessor.getApplicationProperties().getString("jira.baseurl")


if(issue){
    
	
   return  baseurl +"/browse/"+ issue.key
    
   
    
    
}else {
    
    return "Issue doesn't exist"
}
