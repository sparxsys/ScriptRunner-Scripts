import com.atlassian.jira.bc.project.ProjectCreationData
import com.atlassian.jira.bc.project.ProjectService
import com.atlassian.jira.component.ComponentAccessor
import com.atlassian.jira.project.AssigneeTypes
import com.atlassian.jira.project.type.ProjectTypeKey

def projectKey = "HR"
def projectName = "Business Core HR"
def projectDescription = "Business Core Project"
def projectUrl = "https://www.ravisagar.in"

def projectService = ComponentAccessor.getComponent(ProjectService)
def loggedInUser = ComponentAccessor.jiraAuthenticationContext.loggedInUser
def projectTypeKey = new ProjectTypeKey("business")

def projectCreationData = new ProjectCreationData.Builder().with {
    withName(projectName)
    withKey(projectKey)
    withDescription(projectDescription)
    withLead(loggedInUser)
    withUrl(projectUrl)
    withAssigneeType(AssigneeTypes.PROJECT_LEAD)
    withType(projectTypeKey)
}.build()

ProjectService.CreateProjectValidationResult createProjectValidationResult =
        projectService.validateCreateProject(
                loggedInUser,
                projectCreationData)

if(!createProjectValidationResult.getErrorCollection().errors)
{
    projectService.createProject(createProjectValidationResult)

} else {
    return ("Project cannot be created ${createProjectValidationResult.getErrorCollection().errors}" )
}


