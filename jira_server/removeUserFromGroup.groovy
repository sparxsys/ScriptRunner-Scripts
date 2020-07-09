import com.atlassian.jira.component.ComponentAccessor

def userName = "user2"
def groupNametoRemove = "jira-software-userss"
def userToRemove = ComponentAccessor.getUserManager().getUserByName(userName)
def groupName = ComponentAccessor.getGroupManager().getGroup(groupNametoRemove)

if (!userToRemove) {
    log.error("User doesn't exist")
    return
}

if (!ComponentAccessor.getGroupManager().getGroupsForUser(userName).contains(groupName)) {
    log.error("User: $userToRemove.username not in the group:" + groupName?.name)
    return
}

if(!groupName) {
    log.error("Group doesn't exist")
} else {

    ComponentAccessor.userUtil.removeUserFromGroup(groupName, userToRemove)
    log.error("User: $userToRemove.username removed from the group: $groupName.name")
}

