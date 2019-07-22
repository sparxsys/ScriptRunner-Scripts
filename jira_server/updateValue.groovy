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
    def cField = customFieldManager.getCustomFieldObject("customfield_10500")
    def cFieldValue = issue.getCustomFieldValue(cField)
    
    //return cFieldValue
    
    //update the value
	def changeHolder = new DefaultIssueChangeHolder()
 	cField.updateValue(null, issue, new ModifiedValue(cFieldValue, "Life is great"),changeHolder)
    
    
    
}else {
    
    return "Issue doesn't exist"
}

