/* Set original estimates based on priority */

import com.atlassian.jira.issue.IssueConstantImpl

def priority = getFieldById(getFieldChanged())
def selectedPriority = ((IssueConstantImpl) priority.getValue()).getName()

def OE = getFieldById("timetracking_originalestimate")


log.debug("Logging Priority: " + selectedPriority)


if ( selectedPriority ==("Highest") )
{ OE.setFormValue("24h")
}
else if ( selectedPriority==("High") )
{ OE.setFormValue("3d")
}
else if ( selectedPriority==("Medium") )
{ OE.setFormValue("24d")
}
else if ( selectedPriority==("Lowest") )
{ OE.setFormValue("48d")
}
else
{
OE.setFormValue("0h")
}
