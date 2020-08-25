import com.atlassian.jira.component.ComponentAccessor

def version = ComponentAccessor.versionManager.createVersion("Version 3",
    null,
    null,
    "Version 3 description",
    10000,
    null,false)

return version.name
