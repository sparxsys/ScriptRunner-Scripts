def response = get('/rest/api/3/issue/cts-12')
        .header('Content-Type', 'application/json')
        .asObject(Map)
        
logger.info("Issue id: " + response.body.id)
logger.info("Priority name: "+ response.body.fields.priority.name)

return response.body
