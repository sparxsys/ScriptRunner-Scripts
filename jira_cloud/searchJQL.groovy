//ScriptRunner for Jira on Cloud - fetch issue keys based on a jql
def resp = get("/rest/api/3/search?jql=project=CT")
        .header("Content-Type", "application/json")
        .asObject(Map)


'${resp.status}: ' + resp.body.issues*.key
