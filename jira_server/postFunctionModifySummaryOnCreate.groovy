/**
* Post function to Append value from a user picker field to summary on issue creation.
* Video link: 
*/
import com.atlassian.jira.component.ComponentAccessor
import com.atlassian.jira.user.ApplicationUser

def customFieldManager = ComponentAccessor.getCustomFieldManager()
def cField = customFieldManager.getCustomFieldObjectsByName("User Picker Field")
def cFieldValue = issue.getCustomFieldValue(cField[0]) as ApplicationUser

if (cFieldValue) {
   issue.summary = issue.summary + ": " + cFieldValue.displayName }
