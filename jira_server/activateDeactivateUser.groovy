import com.atlassian.jira.component.ComponentAccessor
import com.atlassian.jira.bc.user.UserService
import org.apache.log4j.Level
import org.apache.log4j.Logger

//Log
def log = Logger.getLogger("in.ravisagar.sr4j") //Not needed when binding variable is available
log.setLevel(Level.DEBUG)

//String builder for log
def sb = new StringBuilder()

activateDeactivateUser("kapil.m",false, log)

static def activateDeactivateUser(String userName, Boolean activate, log) {
    def userToUpdate = ComponentAccessor.getUserManager().getUserByName(userName)
    if (userToUpdate) {
        def userService = ComponentAccessor.getComponent(UserService)
        def updateUser = userService.newUserBuilder(userToUpdate).active(activate).build()
        def updateUserValidationResult = userService.validateUpdateUser(updateUser)
        if (!updateUserValidationResult.valid) {
            log.error "Update of ${userToUpdate.name} failed. ${updateUserValidationResult.errorCollection}"
            return
        }

        switch (activate){
            case true:
                userToUpdate.isActive() ? log.info("User already active"): log.info("Attempting to activate")
                userService.updateUser(updateUserValidationResult)
                log.info "${updateUser.name} Activated"
                break
            case false:
                !userToUpdate.isActive() ? log.info("User already inactive"): log.info("Attempting to inactivate")
                userService.updateUser(updateUserValidationResult)
                log.info "${updateUser.name} deactivated"
                break
            default: break
        }

    } else {
        log.info "User not found"
    }

}
