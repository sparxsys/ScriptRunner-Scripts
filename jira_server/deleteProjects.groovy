package com.example
import com.atlassian.jira.component.ComponentAccessor

def projectManager = ComponentAccessor.getProjectManager()

//return projectManager.getProjects()[1]

def delete_project = projectManager.getProjects()[1]
return projectManager.removeProject(delete_project)