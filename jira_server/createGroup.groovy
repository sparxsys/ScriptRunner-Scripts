import com.atlassian.crowd.exception.embedded.InvalidGroupException
import com.atlassian.jira.component.ComponentAccessor

def groupName = "Group123"
//Call to add the group
addGroup(groupName)

def addGroup(String groupName) {

        try {
            ComponentAccessor.groupManager.createGroup(groupName)
            log.error("Group added")
        }
        catch (InvalidGroupException invalidGroupException) {

            log.error("Error creating group: " + invalidGroupException.message)
        }

}
