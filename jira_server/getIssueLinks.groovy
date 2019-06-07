import com.atlassian.jira.issue.IssueManager;
import com.atlassian.jira.issue.MutableIssue;
import com.atlassian.jira.component.ComponentAccessor;
import com.atlassian.jira.issue.link.IssueLink;


IssueManager im = ComponentAccessor.getIssueManager();
MutableIssue issue = im.getIssueObject("ANDROID-124");


//def links = ComponentAccessor.getIssueLinkManager().getInwardLinks(issue.getId())
def links = ComponentAccessor.getIssueLinkManager().getOutwardLinks(issue.getId())

//return links[0].getSourceObject()

def output = ""
for( l in links) {
    
    //use this for Outward links
  output = output + l.issueLinkType.name + ": " +  l.getDestinationObject() + "<br/>"
   
    //use this for Inward links
 //  output = output + l.issueLinkType.name + ": " +  l.getSourceObject() + "<br/>"

}

return output


