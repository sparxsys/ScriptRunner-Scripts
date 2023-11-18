/**
Hide a field based on the values selected in either parent or child of a cascading select list.

Cascading field: Country and city
Parent options: India, UK
Child options: [Delhi, Mumbai], [Londo, Reading, Slough]

**/
import com.atlassian.jira.component.ComponentAccessor
import com.atlassian.jira.issue.customfields.manager.OptionsManager
import com.atlassian.jira.issue.fields.config.FieldConfig
import com.atlassian.jira.issue.customfields.option.Options

log.debug("******Logging starts********")

def parentField = getFieldById("customfield_10401")
def parentFieldValue = parentField.getValue()
def childField = getFieldById("customfield_10401:1")
def childFieldValue = childField.getValue()
def fieldToHide = getFieldByName("Review Date")

log.debug("Parent Field: " + parentFieldValue)
log.debug("Child Field: " + childFieldValue)

/**Hide based on parent field **/
if( parentFieldValue.containsAll("UK")) {

    fieldToHide.setHidden(true)
    
} else {

        fieldToHide.setHidden(false)
}

/**Hide based on child field **/

/*
if( childFieldValue == "Delhi") {

    fieldToHide.setHidden(true)
    
} else {

        fieldToHide.setHidden(false)
}
*/
