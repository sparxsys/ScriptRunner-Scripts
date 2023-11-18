import com.onresolve.jira.groovy.user.FieldBehaviours
import groovy.transform.BaseScript
import org.apache.log4j.Level
import org.apache.log4j.Logger

@BaseScript FieldBehaviours fieldBehaviours

def log = Logger.getLogger("sr4j.behaviour.com")
log.setLevel(Level.DEBUG)

def commentField = getFieldById("comment")
def changedFormField = getFieldById(fieldChanged)


if (changedFormField.formValue.toString().contains("10001")) {
    log.debug("Required True")
    commentField.setRequired(true)
} else
{
    log.debug("Required False")
    commentField.setRequired(false)
}


