//ScriptRunner for Jira on Cloud - Get the last comment
//def issueKey = "IOSTWO-32"
def issueKey = issue.key

def resp = get("/rest/api/3/issue/${issueKey}/comment")
        .header("Content-Type", "application/json")
        .asObject(Map)
        
return resp.body.comments ? resp.body.comments.last().body.content.content.text[0][0] : "No comments"
