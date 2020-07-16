
import com.atlassian.jira.issue.comments.CommentManager
import com.atlassian.jira.issue.IssueManager
import com.atlassian.jira.issue.MutableIssue
import com.atlassian.jira.component.ComponentAccessor


CommentManager commentMgr = ComponentAccessor.getCommentManager()
//IssueManager im = ComponentAccessor.getIssueManager()
//MutableIssue issue = im.getIssueObject("SCRUM-318")


issue ? commentMgr.getComments(issue).last().getBody(): log.debug("Issue doesn't exist")
