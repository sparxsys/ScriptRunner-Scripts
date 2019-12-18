/*
**In response to the question here
https://community.atlassian.com/t5/Marketplace-Apps-Integrations/How-do-I-gray-out-the-second-level-of-cascading-select-field/qaq-p/1185971#U1187530
*/
import com.atlassian.jira.component.ComponentAccessor
import com.atlassian.jira.issue.customfields.manager.OptionsManager
import com.atlassian.jira.issue.fields.config.FieldConfig
import com.atlassian.jira.issue.customfields.option.Options

log.debug("******Logging starts********")

def parentField = getFieldById("customfield_10802")
def parentFieldValue = parentField.getValue()
def childField = getFieldById("customfield_10802:1")
def childFieldValue = childField.getValue()

def customField = getCustomFieldManager().getCustomFieldObjectsByName("Country State City")

FieldConfig config = customField[0].getRelevantConfig(getIssueContext())

def rootOptions_ = ComponentAccessor.getOptionsManager().getOptions(config)
def childOptions_ = [:]

rootOptions_.rootOptions.each { it ->
 
    childOptions_[it] = it.childOptions

}
def master = ["India","France","USA"]
def slave = ["India"]

log.debug ("True or false: " + master.containsAll(slave))

log.debug("Master: "+ master)
log.debug("Slave: "+ slave)

def nullcheck = []
nullcheck = childOptions_.findAll { it.value.size() == 0 }.keySet()

log.debug("Outside NULL Check: " + nullcheck)
log.debug("Outside Selected Parent outside if: " + parentFieldValue[0].toString())
log.debug(parentFieldValue.isEmpty())
log.debug("Contains true or false: " + nullcheck.findAll { it ==~ parentFieldValue[0].toString() }.size()   )

def readOnlyYes = nullcheck.findAll { it ==~ parentFieldValue[0].toString() }.size()

if( !parentFieldValue.isEmpty() && readOnlyYes >= 1) {

log.debug("Inside NULL Check: " + nullcheck)
log.debug("Inside Selected Parent outside if: " + parentFieldValue)

      childField.setReadOnly(true)
    
} else {
  childField.setReadOnly(false)
    
}

/*
childOptions_.findAll { it.value.size() == 0 }.keySet().each { item ->
    
    
 log.debug("Iterating outside if, item is: "+item)
    log.debug("Selected Parent outside if: " + parentFieldValue[0])
  
  
    if (parentFieldValue[0] != null && parentFieldValue[0].toString() == item.toString()) {
        
  log.debug("Iterating inside if, item is: "+item)
        log.debug("Selected Parent inside if: " + parentFieldValue[0])
 
        childField.setReadOnly(true)
    }
    
    else {
        
        childField.setReadOnly(false)
    }
    
}
*/
   

/*
log.debug("Selected Parent: " + parentFieldValue[0])
log.debug("Selected Child: " + childFieldValue)
log.debug("Root Options: " + rootOptions_.rootOptions )
log.debug("Child all options: " + childOptions_)
log.debug("Child all options: " + childOptions_.values()*.size())
log.debug("Null parents: " + childOptions_.findAll { it.value.size() == 0 }.keySet() )
log.debug("Index of null child: " + childOptions_.findIndexOf { it.value.size() == 0 })
//log.debug("Child Field: ")

*/

/*
def salescolValue = getFieldById(getFieldChanged()).getValue()
def salescolOwnValue = getFieldByName("Sales Collateral Owner").getValue()
def salescolCom = getFieldByName("Sales Collateral Completed")

if ( !salescolValue.toString().contains("null") && salescolOwnValue) {
 
    salescolCom.setReadOnly(false)
  
}
else {
    
    salescolCom.setReadOnly(true)

}

*/