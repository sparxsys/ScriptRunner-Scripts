import com.atlassian.jira.component.ComponentAccessor
import org.apache.log4j.Level
import org.apache.log4j.Logger

def log = Logger.getLogger("in.ravisagar.sr4j")
log.setLevel(Level.DEBUG)

def permissionManager = ComponentAccessor.permissionManager

permissionManager.getAllProjectPermissions().each {

    log.debug(it.getNameI18nKey()+","+it.getKey())

}
