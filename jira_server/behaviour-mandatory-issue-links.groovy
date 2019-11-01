/**
 * Make the links field required when there are no existing link and
 * the link type is "is part of"
 * Video link: https://youtu.be/q4KfHSTdVeA
 */

import com.atlassian.jira.component.ComponentAccessor
import com.atlassian.jira.issue.link.IssueLink

def links = getFieldById("issuelinks")
def linksValue = links.getValue()
def linkType = getFieldById("issuelinks-linktype")
def linkTypeValue = linkType.getValue()
def linkField = getFieldById("issuelinks-issues")
def linkFieldValue = linkField.getValue()

log.debug("Links Value: "+ linksValue)
log.debug("Link Type Value: "+ linkTypeValue)
log.debug("Links Value: "+ linkFieldValue)

def existingLinks = ComponentAccessor.getIssueLinkManager().getInwardLinks(underlyingIssue?.getId())

if (existingLinks?.size() == 0 && linkTypeValue == "is part of") {
    
    links.setRequired(true)
    
} else {
    
    links.setRequired(false)
    
}



