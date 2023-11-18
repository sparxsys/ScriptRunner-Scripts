import com.atlassian.jira.user.ApplicationUser
import com.onresolve.scriptrunner.parameters.annotation.UserPicker

@UserPicker(label = "Select user", description = "Add user to group")
ApplicationUser user
