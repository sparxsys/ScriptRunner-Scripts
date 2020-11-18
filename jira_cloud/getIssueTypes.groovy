def responseIssueTypes = get("/rest/api/3/issuetype").asObject(List)

def issueTypes = responseIssueTypes.body as List<Map>

//Get only standard issue type with name "Task"

return issueTypes.findAll{it.name=="Task" && !it.subtask}
