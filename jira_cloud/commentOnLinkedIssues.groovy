def issueKey = issue.key

def response = get('/rest/api/3/issue/'+issueKey)
        .header('Content-Type', 'application/json')
        .asObject(Map)
        
logger.info("Issue id: " + response.body.id)
logger.info("Priority name: "+ response.body.fields.priority.name)
logger.info("Inward issue links: "+ response.body.fields.issuelinks*.inwardIssue.key)
logger.info("Outward issue links: "+ response.body.fields.issuelinks*.outwardIssue.key)

response.body.fields.issuelinks.each { it->
    
    if(it.inwardIssue) {
        logger.info("Inward issue: "+ it.inwardIssue.key)
        //add a comment
        addComment(issueKey, it.inwardIssue.key)
    } else if (it.outwardIssue) {
        logger.info("Outward issue: "+ it.outwardIssue.key)
        //add a comment
    }
    
}

def addComment(orginalIssue, linkedIssue) {
    

    def comment = orginalIssue + ' issue moved to on Hold'
    
    def result = post("/rest/api/2/issue/${linkedIssue}/comment")
            .header('Content-Type', 'application/json')
            .body([
                body: comment
            ])
            .asString()
    
}

