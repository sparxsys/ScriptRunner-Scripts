import com.atlassian.jira.issue.IssueManager
import com.atlassian.jira.issue.MutableIssue
import com.atlassian.jira.issue.link.IssueLink
import com.atlassian.jira.component.ComponentAccessor
import com.atlassian.jira.user.ApplicationUser
import org.apache.log4j.Logger
import org.apache.log4j.Level
  
def log = Logger.getLogger("com.sagar.ravi")
log.setLevel(Level.DEBUG)
  
log.debug("Script started")

IssueManager im = ComponentAccessor.getIssueManager();
MutableIssue issue = im.getIssueObject("ANDROID-38");

def changeHistoryManager = ComponentAccessor.getChangeHistoryManager()
changeHistoryManager.getAllChangeItems(issue).each { it ->
    
    
    log.debug(it.created.toString() + ": " + it.field + " - " + it.from + "->" + it.to)
        
}

log.debug("ONLY PRIORITY")

changeHistoryManager.getChangeItemsForField(issue, "priority").each { it ->
    
    log.debug(it.created.toString() + ": " + it.field + " - " + it.fromString + "->" + it.toString)
        
}


