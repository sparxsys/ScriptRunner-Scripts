//Script to perform search to get list of issues and then iterate over them

def response = get('/rest/api/2/search?jql=filter=10047')
        .header('Content-Type', 'application/json')
        .asObject(Map)

response.body.issues.each { it ->
    
    getIssueDetails(it)
    
}

def getIssueDetails(issue) {
    
    logger.info("Issue Key: " + issue.key +", "+ issue.fields.priority.name)
}
