import com.atlassian.jira.issue.IssueManager;
import com.atlassian.jira.issue.MutableIssue;
import com.atlassian.jira.component.ComponentAccessor;
import com.atlassian.jira.user.ApplicationUser;

//Workflow imports
import com.atlassian.jira.issue.IssueInputParametersImpl
import com.atlassian.jira.bc.issue.IssueService
import com.atlassian.jira.workflow.JiraWorkflow
import com.atlassian.jira.workflow.WorkflowManager


ApplicationUser currentUser = ComponentAccessor.getJiraAuthenticationContext().loggedInUser


IssueManager im = ComponentAccessor.getIssueManager();
MutableIssue issue = im.getIssueObject("HT-36");


//Workflow
WorkflowManager workflowManager = ComponentAccessor.getWorkflowManager()
JiraWorkflow workflow = workflowManager.getWorkflow(issue)

//return workflow.getLinkedStep(issue.getStatus()).getActions().id

//[921, 851, 761, 891, 901, 871]  [781, 761, 901, 911]



def actionId = 911
IssueService issueService = ComponentAccessor.getIssueService()

def transitionValidationResult = issueService.validateTransition(currentUser, issue.id, actionId, new IssueInputParametersImpl())

//return transitionValidationResult.isValid()

def transitionResult = issueService.transition(currentUser, transitionValidationResult)
return transitionResult



