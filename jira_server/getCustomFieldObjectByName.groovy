/**
* Fetch the value of a custom field by its name
*
**/

import com.atlassian.jira.issue.IssueManager
import com.atlassian.jira.issue.MutableIssue
import com.atlassian.jira.component.ComponentAccessor
import com.atlassian.jira.issue.util.DefaultIssueChangeHolder
import com.atlassian.jira.issue.ModifiedValue

IssueManager im = ComponentAccessor.getIssueManager()
MutableIssue issue = im.getIssueObject("ANDROID-126")

if(issue){
    
	//get the value
    def customFieldManager = ComponentAccessor.getCustomFieldManager()
    //def cField = customFieldManager.getCustomFieldObject("customfield_10500")
    
    def cField = customFieldManager.getCustomFieldObjectByName("Text Field")
    def cFieldValue = issue.getCustomFieldValue(cField)
    
   
    
    
}else {
    
    return "Issue doesn't exist"
}