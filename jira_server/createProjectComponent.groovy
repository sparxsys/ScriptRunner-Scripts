import com.atlassian.jira.component.ComponentAccessor

def component = ComponentAccessor.projectComponentManager.create("Component 2",
                                                                "Component 2 description",
                                                                "admin",
                                                                1,
                                                                10000)

return component.name
