def response = get('/rest/api/2/search?jql=filter=10047')
        .header('Content-Type', 'application/json')
        .asObject(Map)

response.body.issues.each { it ->
    
    getIssueDetails(it)
    
}

def getIssueDetails(issue) {
    
    logger.info("Issue Key: " + issue.key +", "+ issue.fields.priority.name + ", " + issue.fields.status.name)
    
    //Delete the issues with a specific status
    if (issue.fields.status.name == "To Do" ) {
       deleteIssue(issue.key)
    }
}


def deleteIssue(issueKey) {
    
    logger.info("Issue to be deleted: " + issueKey)
    
    def responseDelete = delete('/rest/api/3/issue/'+issueKey+'?deleteSubtasks=true')
        .header('Content-Type', 'application/json')
        .asObject(Map)
        
        if(responseDelete.status==403) {
            
            logger.info("Error: " + responseDelete.body.errorMessages)
            
        }
        
        
}
