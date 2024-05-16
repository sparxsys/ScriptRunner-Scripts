/**
 Video: https://youtu.be/lkc7mpF0vZY
 ScriptRunner Consulting: www.sparxsys.com
**/

import com.atlassian.jira.component.ComponentAccessor
import com.atlassian.jira.issue.Issue
import com.atlassian.jira.issue.MutableIssue
import com.atlassian.jira.issue.ModifiedValue
import com.atlassian.jira.issue.index.IssueIndexingService
import com.atlassian.jira.issue.util.DefaultIssueChangeHolder
import com.atlassian.jira.issue.IssueManager
import com.atlassian.jira.issue.CustomFieldManager
import com.atlassian.jira.user.ApplicationUser
import com.atlassian.jira.util.ImportUtils
import com.atlassian.jira.event.type.EventDispatchOption


IssueManager im = ComponentAccessor.getIssueManager()

def issue = im.getIssueObject("DEMO-24")

updateSingleSelectList(issue, "Impact", "High")

def updateSingleSelectList(MutableIssue issue, String fieldName, String optionToUpdate) {

    IssueManager im = ComponentAccessor.getIssueManager()
    //def issueToUpdate = im.getIssueObject(issueKey)
    CustomFieldManager customFieldManager = ComponentAccessor.getCustomFieldManager()
    def customField = customFieldManager.getCustomFieldObjectsByName(fieldName).first()
    def customFieldFieldConfig = customField.getRelevantConfig(issue)
    def newOptionToUpdate =
            ComponentAccessor.optionsManager.getOptions(customFieldFieldConfig)?.find {
                it.value == optionToUpdate
            }
    //Do not update history
    customField.updateValue(null, issue, new ModifiedValue(issue.getCustomFieldValue(customField), newOptionToUpdate), new DefaultIssueChangeHolder())

    //Update history
    //ApplicationUser user = ComponentAccessor.getJiraAuthenticationContext().getLoggedInUser()
    //issue.setCustomFieldValue(customField, newOptionToUpdate)
    //ComponentAccessor.getIssueManager().updateIssue(user, issue, EventDispatchOption.ISSUE_UPDATED, false)

}
