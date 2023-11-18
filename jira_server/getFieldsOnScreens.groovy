import com.atlassian.jira.component.ComponentAccessor
import org.apache.log4j.Level
import org.apache.log4j.Logger

def log = Logger.getLogger("in.ravisagar.sr4j")
log.setLevel(Level.DEBUG)

ComponentAccessor.getFieldScreenManager().getFieldScreens().each { it ->

    log.debug("Screen: " + it.name)
    log.debug("Tabs: " + it.getTabs()*.name)

    it.getTab(0).getFieldScreenLayoutItems().each { fsli ->

        log.debug(fsli.fieldId)


    }


}
