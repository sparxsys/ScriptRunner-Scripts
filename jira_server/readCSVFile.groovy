/*
CSV Format
userName,userEmail,userName
user1,user1@example.com,"User 1 Name"
user2,user2@example.com, "User 2 Name"
user3,user3@example.com, "User 3 Name"

CSV parsing code copied from: https://stackoverflow.com/questions/49675423/read-csv-file-and-put-result-in-a-map-using-groovy-without-using-any-external-l
*/


File file = new File("/opt/jira/home/scripts/file.csv") 

def csvMapList = []

file.eachLine { line ->
    def columns = line.split(",")
    def tmpMap = [:]

    tmpMap.putAt("userName", columns[0])
    tmpMap.putAt("userEmail", columns[1])
    tmpMap.putAt("userFullName", columns[2])

    csvMapList.add(tmpMap)
}

// csvMapList.getAt("userName") //return all usernames
// return csvMapList.getAt("userEmail") //return all emails
//csvMapList.getAt("userFullName") //return all usernames

return csvMapList

