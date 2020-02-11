import com.atlassian.jira.issue.IssueManager
import com.atlassian.jira.issue.MutableIssue
import com.atlassian.jira.component.ComponentAccessor
import com.atlassian.jira.issue.util.DefaultIssueChangeHolder
import com.atlassian.jira.issue.ModifiedValue

IssueManager im = ComponentAccessor.getIssueManager()
MutableIssue issue = im.getIssueObject("ANDROID-48")

if(issue){

//get the value
def customFieldManager = ComponentAccessor.getCustomFieldManager()

//CoD
def codField = customFieldManager.getCustomFieldObjectsByName("Cost of Delay")
def codFieldValue = issue.getCustomFieldValue(codField[0]) as Double

//Job Size
def jsField = customFieldManager.getCustomFieldObjectsByName("Job Size")
def jsFieldValue = issue.getCustomFieldValue(jsField[0]) as Double

if (codFieldValue == null || jsFieldValue == null) {

return "Invalid/Cannot be null"
}
return codFieldValue / jsFieldValue





}else {

return "Issue doesn't exist"
}
