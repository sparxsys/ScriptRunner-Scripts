//ScriptRunner for Jira on Cloud - Create an Issue
def resp = post("/rest/api/3/issue")
        .header("Content-Type", "application/json")
        .body(
        fields: [
                    summary: "New issue from SR4J on cloud :)",
                    issuetype: [
                            id: 10001
                    ],
                    project: [
                        id: 10024
                        ]
        ])
        .asObject(Map)


// If the task created successfully return a success message along with its key
if (resp.status == 201) {
    return 'Success - Created with the key of ' + resp.body.key.toString()
} else {
    return "${resp.status}: ${resp.body}"
}