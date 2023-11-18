import com.atlassian.jira.component.ComponentAccessor
import com.atlassian.jira.workflow.WorkflowManager
import org.apache.log4j.Level
import org.apache.log4j.Logger


def log = Logger.getLogger("in.ravisagar.sr4j")
log.setLevel(Level.DEBUG)
WorkflowManager workflowManager = ComponentAccessor.getWorkflowManager()

workflowManager.getWorkflows().each { it ->

    log.debug("Workflow: " + it.name)
    log.debug(it.getLinkedStatusObjects()*.name)

    it.getLinkedStatusObjects().each { status ->
        log.debug(it.getLinkedStep(status).name)
        log.debug(it.getLinkedStep(status).getActions().id)

    }


}
