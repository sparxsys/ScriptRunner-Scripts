import com.atlassian.jira.bc.JiraServiceContext
import com.atlassian.jira.bc.JiraServiceContextImpl
import com.atlassian.jira.bc.user.search.UserSearchService
import com.atlassian.jira.component.ComponentAccessor

def user = ComponentAccessor.jiraAuthenticationContext.loggedInUser
def query = ComponentAccessor.getUserSearchService() as UserSearchService

JiraServiceContext jiraServiceContext = new JiraServiceContextImpl(user)

return query.findUsersAllowEmptyQuery(jiraServiceContext, "")*.name