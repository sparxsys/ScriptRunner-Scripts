import com.atlassian.jira.issue.IssueManager
import com.atlassian.jira.issue.MutableIssue
import com.atlassian.jira.component.ComponentAccessor
import com.atlassian.jira.issue.comments.CommentManager

CommentManager commentMgr = ComponentAccessor.getCommentManager()

IssueManager im = ComponentAccessor.getIssueManager()
MutableIssue issue = im.getIssueObject("ISD-6")


//def links = ComponentAccessor.getIssueLinkManager().getInwardLinks(issue.getId())
def links = ComponentAccessor.getIssueLinkManager().getOutwardLinks(issue.getId())

for( l in links) {


    commentMgr.getComments(issue).each { it ->

        commentMgr.create(l.getDestinationObject(), it.authorApplicationUser, it.updateAuthorApplicationUser, it.body, it.groupLevel, it.roleLevelId, it.created, it.updated, false)
    }

}


