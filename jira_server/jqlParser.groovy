import com.atlassian.jira.bc.issue.search.SearchService
import com.atlassian.jira.component.ComponentAccessor
import com.atlassian.jira.web.bean.PagerFilter

def searchService = ComponentAccessor.getComponentOfType(SearchService)
def user = ComponentAccessor.jiraAuthenticationContext.loggedInUser

def filter = "issuetype = Story"
SearchService.ParseResult parseResult = searchService.parseQuery(user, filter)
def results = searchService.search(user, parseResult.query, PagerFilter.unlimitedFilter)

//def issues = results.issues //Jira 7
def issues = results.results //Jira 8
log.debug("Total issues: " + issues.size())
issues.each { it ->

    log.debug(it.key + ", " + it.issueType.name)

}



