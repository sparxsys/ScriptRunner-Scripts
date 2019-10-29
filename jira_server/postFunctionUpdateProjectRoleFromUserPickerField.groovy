/**
* Post function to update project role from user picker field
* Video link: https://youtu.be/0--2IoU6KCA
**/
//import com.atlassian.jira.issue.IssueManager
//import com.atlassian.jira.issue.MutableIssue
import com.atlassian.jira.component.ComponentAccessor
import com.atlassian.jira.issue.util.DefaultIssueChangeHolder
import com.atlassian.jira.bc.user.UserService
import com.atlassian.jira.bc.projectroles.ProjectRoleService
import com.atlassian.jira.component.ComponentAccessor
import com.atlassian.jira.security.roles.ProjectRoleActor
import com.atlassian.jira.security.roles.ProjectRoleManager
import com.atlassian.jira.util.SimpleErrorCollection
import com.atlassian.jira.user.ApplicationUser


//IssueManager im = ComponentAccessor.getIssueManager()
//MutableIssue issue = im.getIssueObject("ANDROID-34")
 
//get the value of Project Manager
def customFieldManager = ComponentAccessor.getCustomFieldManager()
def projectManagerField = customFieldManager.getCustomFieldObjectsByName("Project Manager")
def projectManagerValue = issue.getCustomFieldValue(projectManagerField[0]) as ApplicationUser

//get the value of Project Manager
def projectSponsorField = customFieldManager.getCustomFieldObjectsByName("Project Sponsor")
def projectSponsorValue = issue.getCustomFieldValue(projectSponsorField[0]) as ApplicationUser

def pmActors = []
def psActors = []
pmActors.add(projectManagerValue.getUsername().toString())
psActors.add(projectSponsorValue.getUsername().toString())
    
def projectManager = ComponentAccessor.getProjectManager()
def projectRoleService = ComponentAccessor.getComponent(ProjectRoleService)
def projectRoleManager = ComponentAccessor.getComponent(ProjectRoleManager)
def errorCollection = new SimpleErrorCollection()  
//def project = projectManager.getProjectObjByKey("ANDROID")
def project =  issue.getProjectObject()

def projectManagerRole = projectRoleManager.getProjectRole("Project Managers")
def projectSponsorsRole = projectRoleManager.getProjectRole("Project Sponsors")

//Add to Project Managers role  
projectRoleService.addActorsToProjectRole(pmActors,
                                          projectManagerRole,
                                          project,
                                          ProjectRoleActor.USER_ROLE_ACTOR_TYPE,
                                          errorCollection)
//Add to Project Sponsors role  
projectRoleService.addActorsToProjectRole(psActors,
                                          projectSponsorsRole,
                                          project,
                                          ProjectRoleActor.USER_ROLE_ACTOR_TYPE,
                                          errorCollection)
