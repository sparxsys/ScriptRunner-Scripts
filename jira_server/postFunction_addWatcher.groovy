import com.atlassian.jira.component.ComponentAccessor
import com.atlassian.jira.issue.IssueManager
import com.atlassian.jira.issue.watchers.WatcherManager


IssueManager im = ComponentAccessor.getIssueManager()
WatcherManager watcherManager = ComponentAccessor.getWatcherManager()

def issue = im.getIssueObject("SSP-23")
def watcherUser = ComponentAccessor.userManager.getUserByName("admin")

watcherManager.startWatching(watcherUser, issue)
watcherManager.stopWatching(watcherUser,issue)


