import com.atlassian.mail.Email
import com.atlassian.mail.server.SMTPMailServer
import com.atlassian.jira.component.ComponentAccessor

def emailSubject = "Test Email Subject"
def emailBody = "Test Email Body"
def emailAddress = "ravisagar@gmail.com"


SMTPMailServer mailServer = ComponentAccessor.getMailServerManager().getDefaultSMTPMailServer()


if (mailServer) {
    Email email = new Email(emailAddress)
    email.setSubject(emailSubject)
    email.setBody(emailBody)
    mailServer.send(email)
} else {}
