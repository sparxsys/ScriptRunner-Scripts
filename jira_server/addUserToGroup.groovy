import com.atlassian.jira.component.ComponentAccessor

def userName = "user2"
def groupNametoAdd = "jira-servicedesk-users"
def userToAdd = ComponentAccessor.getUserManager().getUserByName(userName)
def groupName = ComponentAccessor.getGroupManager().getGroup(groupNametoAdd)


if (!userToAdd) {
    log.error("User doesn't exist")
    return
}

if (ComponentAccessor.getGroupManager().getGroupsForUser(userName).contains(groupName)) {
    log.error("User: $userToAdd.username already in the group: $groupName.name")
    return
}



if(!groupName) {
    log.error("Group doesn't exist")
} else {
    ComponentAccessor.groupManager.addUserToGroup(userToAdd, groupName)
    log.error("User: $userToAdd.username added to the group: $groupName.name")
}
