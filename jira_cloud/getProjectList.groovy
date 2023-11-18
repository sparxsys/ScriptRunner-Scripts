def response = get('/rest/api/3/project/search?expand=lead')
        .header('Content-Type', 'application/json')
        .asObject(Map)srip

return response.body.values.each{ it ->

    logger.info(it.key+","+it.name+","+it.lead.displayName)
    
}
