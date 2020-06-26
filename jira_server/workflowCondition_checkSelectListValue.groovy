import com.atlassian.jira.component.ComponentAccessor
import com.atlassian.jira.issue.IssueManager
import com.atlassian.jira.issue.MutableIssue
import org.apache.log4j.Level
import org.apache.log4j.Logger

def log = Logger.getLogger("in.ravisagar.sr4j")
//log.setLevel(Level.DEBUG)

//IssueManager im = ComponentAccessor.getIssueManager()
//MutableIssue issue = im.getIssueObject("SCRUM-31")

def country = ComponentAccessor.customFieldManager.getCustomFieldObjectsByName("Country")
def countryValue = country?issue.getCustomFieldValue(country[0]): "Not found"
log.debug("Country selected: " + countryValue)


passesCondition = false

if (countryValue.toString() == "India") {

    passesCondition = true
}
