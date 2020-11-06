//Bt-5 blocks Bt-2 >> Outward link
//Bt-2 blocked by Bt-5 >> Inward link

post('/rest/api/3/issueLink')
        .header('Content-Type', 'application/json')
        .body(
       
                    [
          outwardIssue: [
            key: "bt-2"
          ],
          
          inwardIssue: [
            key: "bt-5"
          ],
          type: [
            name: "Blocks"
          ]
        ]
        
       
        )
        .asString().body
        
    
