import com.atlassian.jira.component.ComponentAccessor
import groovy.sql.Sql
import org.ofbiz.core.entity.ConnectionFactory
import org.ofbiz.core.entity.DelegatorInterface
import org.apache.log4j.Logger
import org.apache.log4j.Level
  
def log = Logger.getLogger("com.sagar.ravi")
log.setLevel(Level.DEBUG)

import java.sql.Connection

def delegator = (DelegatorInterface) ComponentAccessor.getComponent(DelegatorInterface)
String helperName = delegator.getGroupHelperName("default")

//Enclose the SQL statement in triple quotes so it can span multiple lines for better visibility
def sqlStmt = """
    SELECT     pname, pkey, lead, projecttype
    FROM       project
"""

Connection conn = ConnectionFactory.getConnection(helperName)
Sql sql = new Sql(conn)

//Use try and finally blocks for database connections because if something is wrong with the database connection
//the connection can atleast be closed. finally block always gets executed.

try {
    StringBuffer sb = new StringBuffer()
    sql.eachRow(sqlStmt) { it ->
        
        sb.append( it.getAt("pname") )
        sb.append(",")
        sb.append( it.getAt("pkey") )
        sb.append(",")
        sb.append( it.getAt("lead") )
        sb.append(",")
        sb.append( it.getAt("projecttype") )
        sb.append("\n")
        
        
        
      
    }
    log.debug sb.toString()
}
finally {
    sql.close()
}



