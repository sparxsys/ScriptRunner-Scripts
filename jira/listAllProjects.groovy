package com.example
import com.atlassian.jira.component.ComponentAccessor

def projectManager = ComponentAccessor.getProjectManager()
def i
def output=""



for (i=0; i<projectManager.getProjects().size();i++) {

    output = output + projectManager.getProjects()[i].name + "," + projectManager.getProjects()[i].getProjectCategory() +"<br/>"

}

File file = new File("/Users/spareuser/IdeaProjects/scriptrunner-samples/jira/target/jira/home/export/file.csv")

file.write(output)

return output
