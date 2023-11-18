import com.atlassian.jira.component.ComponentAccessor
import com.atlassian.jira.config.PriorityManager
import com.atlassian.jira.issue.fields.config.manager.PrioritySchemeManager
import org.apache.log4j.Level
import org.apache.log4j.Logger


def log = Logger.getLogger("in.ravisagar.sr4j")
log.setLevel(Level.DEBUG)

ComponentAccessor.getComponent(PrioritySchemeManager).getAllSchemes()

ComponentAccessor.getComponent(PriorityManager).getPriorities()*.name
