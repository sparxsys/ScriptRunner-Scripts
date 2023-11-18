import com.atlassian.jira.component.ComponentAccessor
import com.atlassian.jira.issue.Issue
import com.atlassian.jira.issue.IssueManager
import com.atlassian.jira.issue.MutableIssue
import org.apache.log4j.Level
import org.apache.log4j.Logger


//def log = Logger.getLogger("in.ravisagar.sr4j")
log.setLevel(Level.DEBUG)

IssueManager im = ComponentAccessor.getIssueManager()
def issue = im.getIssueObject("SCRUM-14")

Locale english = new Locale("en")

def watcherCount = ComponentAccessor.watcherManager.getWatcherCount(issue)
log.debug("Watcher Count: " + watcherCount)

def watchers = ComponentAccessor.watcherManager.getWatchers(issue, english)

log.debug("Watchers: " + watchers*.name)
