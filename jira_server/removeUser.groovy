
import com.atlassian.jira.bc.user.UserService
import com.atlassian.jira.component.ComponentAccessor

def userService = ComponentAccessor.getComponent(UserService)
def currentUser = ComponentAccessor.jiraAuthenticationContext.loggedInUser

UserService.DeleteUserValidationResult result = userService.validateDeleteUser(currentUser, "michelle.williams")

//return result.isValid()

//return result.errorCollection

//userService.removeUser(currentUser, result)


