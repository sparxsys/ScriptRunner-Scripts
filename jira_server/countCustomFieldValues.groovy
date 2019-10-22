/**
   
 */



import com.atlassian.jira.component.ComponentAccessor
import com.atlassian.jira.bc.issue.search.SearchService
import com.atlassian.jira.jql.parser.JqlQueryParser
import com.atlassian.jira.web.bean.PagerFilter
import com.atlassian.jira.issue.IssueManager
import com.atlassian.jira.component.ComponentAccessor
import com.atlassian.jira.issue.MutableIssue
import org.apache.log4j.Logger
import org.apache.log4j.Level
  
def log = Logger.getLogger("com.test.count")
log.setLevel(Level.DEBUG)

def jqlQueryParser = ComponentAccessor.getComponent(JqlQueryParser)
def searchService = ComponentAccessor.getComponent(SearchService)
def issueManager = ComponentAccessor.getIssueManager()
def user = ComponentAccessor.jiraAuthenticationContext.loggedInUser


def query = jqlQueryParser.parseQuery("project = DEMO and assignee = currentUser()")

def search = searchService.search(user, query, PagerFilter.getUnlimitedFilter())

log.debug("Total issues: ${search.total}")

def countOptions = []

search.results.each { documentIssue ->
    log.debug(documentIssue.key)

    IssueManager im = ComponentAccessor.getIssueManager()
    MutableIssue issue = im.getIssueObject(documentIssue.id)
    // do something to the issue...
    log.debug(issue.summary)
    
    def customFieldManager = ComponentAccessor.getCustomFieldManager()
    def cField = customFieldManager.getCustomFieldObjectsByName("Select List")
         
    def cFieldValue = issue.getCustomFieldValue(cField[0])
    
    if(cFieldValue) {
        countOptions.add(cFieldValue.toString())
    }
    
   // log.debug(cFieldValue)
    //IssueManager im = ComponentAccessor.getIssueManager()
	//MutableIssue issue = im.getIssueObject(issue.key)
}

log.debug(countOptions)
log.debug(countOptions.count("Select 1"))
log.debug(countOptions.count("Select 2"))
log.debug(countOptions.count("Select 3"))
