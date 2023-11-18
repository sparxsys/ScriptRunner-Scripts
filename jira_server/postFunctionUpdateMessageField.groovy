/**
* Post function to update the message field (Text field read only) with a custom message
* This field can only be updated while importing or using code
* Refer to this link: https://community.atlassian.com/t5/Jira-Core-questions/Text-Field-read-only/qaq-p/182646
* Video link: https://youtu.be/gJfoB2q4LIk

**/

import com.atlassian.jira.component.ComponentAccessor
import com.atlassian.jira.issue.util.DefaultIssueChangeHolder
import com.atlassian.jira.issue.ModifiedValue

   
//get the value of Message Field
def customFieldManager = ComponentAccessor.getCustomFieldManager()
def cField = customFieldManager.getCustomFieldObjectsByName("Message Field")
def cFieldValue = issue.getCustomFieldValue(cField[0])

//Prepare the message with system field or custom message
def message = "*Issue status*: " + 
    			issue.getStatus().name + "\n" +
    		"*This is a message that can be displayed*"

//update the value
def changeHolder = new DefaultIssueChangeHolder()
cField[0].updateValue(null, issue, new ModifiedValue(cFieldValue, message),changeHolder)
