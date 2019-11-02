/** 
* Script to delete a project
* Video link: 
**/
package com.example
import com.atlassian.jira.component.ComponentAccessor

def projectManager = ComponentAccessor.getProjectManager()

//These 2 lines can delete a project
def delete_project = projectManager.getProjects()[1]
projectManager.removeProject(delete_project)

/*
Better example can be found here: https://community.atlassian.com/t5/Jira-questions/Delete-Projects-using-Groovy-from-console/qaq-p/225337
Basically you need to validate first

 */

