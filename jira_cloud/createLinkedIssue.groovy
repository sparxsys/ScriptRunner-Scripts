//ScriptRunner for Jira on Cloud - Create an Issue
def resp = post("/rest/api/3/issue")
        .header("Content-Type", "application/json")
        .body(
        fields: [
                    summary: "Issue created from On Hold transition post function",
                    issuetype: [
                            id: 10009
                    ],
                    project: [
                        id: 10037
                        ]
        ])
        .asObject(Map)


// If the task created successfully return a success message along with its key
if (resp.status == 201) {
    logger.info( "Success - Created with the key of " + resp.body.key.toString() )
    
    createIssueLink(issue.key, resp.body.key.toString())
    
} else {
    logger.info( "${resp.status}: ${resp.body}" )
}


def createIssueLink(outwardIssueKey, inwardIssueKey) {
    
 post('/rest/api/3/issueLink')
        .header('Content-Type', 'application/json')
        .body(
       
                    [
          outwardIssue: [
            key: outwardIssueKey
          ],
          
          inwardIssue: [
            key: inwardIssueKey
          ],
          type: [
            name: "Blocks"
          ]
        ]
        
       
        )
        .asString().body   
    
}

