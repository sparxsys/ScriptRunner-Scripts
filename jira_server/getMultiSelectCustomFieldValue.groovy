/**
 * Fetch the value of a custom field by its name
 *
 **/

import com.atlassian.jira.issue.IssueManager
import com.atlassian.jira.issue.MutableIssue
import com.atlassian.jira.component.ComponentAccessor

IssueManager im = ComponentAccessor.getIssueManager()
MutableIssue issue = im.getIssueObject("SCRUM-38")

if(issue){

    //get the value
    def customFieldManager = ComponentAccessor.getCustomFieldManager()

    def cField = customFieldManager.getCustomFieldObjectsByName("Countries")

    def cFieldValue = cField ? issue.getCustomFieldValue(cField[0]) : "Field doesn't exist"

    log.debug "Custom field value type or class" + cFieldValue.getClass()

    cFieldValue.eachWithIndex { it, i ->
    log.debug "Country name $i: $it"
    }

return cFieldValue


}else {

    return "Issue doesn't exist"
}
