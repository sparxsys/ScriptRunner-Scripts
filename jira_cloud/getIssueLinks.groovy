def response = get('/rest/api/3/issue/AN-4')
        .header('Content-Type', 'application/json')
        .asObject(Map)
        
logger.info("Issue id: " + response.body.id)
logger.info("Priority name: "+ response.body.fields.priority.name)
logger.info("Inward issue links: "+ response.body.fields.issuelinks*.inwardIssue.key)
logger.info("Outward issue links: "+ response.body.fields.issuelinks*.outwardIssue.key)

return response.body
