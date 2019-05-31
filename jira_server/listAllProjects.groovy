package com.example
import com.atlassian.jira.component.ComponentAccessor

def projectManager = ComponentAccessor.getProjectManager()
def i
def output=""


for (i=0; i<projectManager.getProjects().size();i++) {

    //building a string that can be displayed on the console later
    output = output + projectManager.getProjects()[i].name + "," + projectManager.getProjects()[i].getProjectCategory() +"<br/>"

}

//Write to a file
File file = new File("/Users/spareuser/IdeaProjects/scriptrunner-samples/jira/target/jira/home/export/file.csv")
file.write(output)

//Display on the console
return output
