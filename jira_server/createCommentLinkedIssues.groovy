/**
* Create a comment on a linked issue
* Video link: 
**/
import com.atlassian.jira.issue.IssueManager;
import com.atlassian.jira.issue.MutableIssue;
import com.atlassian.jira.component.ComponentAccessor;
import com.atlassian.jira.issue.link.IssueLink;

import com.atlassian.jira.issue.comments.CommentManager;
import com.atlassian.jira.user.ApplicationUser;

CommentManager commentMgr = ComponentAccessor.getCommentManager()
ApplicationUser currentUser = ComponentAccessor.getJiraAuthenticationContext().loggedInUser


IssueManager im = ComponentAccessor.getIssueManager();
MutableIssue issue = im.getIssueObject("ANDROID-124");


def lastComment = commentMgr.getComments(issue).last().body

//def links = ComponentAccessor.getIssueLinkManager().getInwardLinks(issue.getId())
def links = ComponentAccessor.getIssueLinkManager().getOutwardLinks(issue.getId())

//return links[0].getSourceObject()

def output = ""
for( l in links) {
    
    //use this for Outward links
  output = output + l.issueLinkType.name + ": " +  l.getDestinationObject() + "<br/>"
   
    //use this for Inward links
 //  output = output + l.issueLinkType.name + ": " +  l.getSourceObject() + "<br/>"
    
    commentMgr.create(l.getDestinationObject(), currentUser, lastComment, false)
    
}

return output


