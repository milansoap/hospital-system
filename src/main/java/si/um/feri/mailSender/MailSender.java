package si.um.feri.mailSender;

import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import si.um.feri.vao.Doctor;
import si.um.feri.vao.Pacient;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.io.Serializable;

public class MailSender implements Serializable {

    public void sendEmail(Pacient p, String contentEmailMessage) throws NamingException, MessagingException {

        InitialContext ctx = new InitialContext();
        Session session = (Session) ctx.lookup("java:jboss/mail/UMMail");
        Message message = new MimeMessage(session);
        InternetAddress toAdress = new InternetAddress(p.getEmail());
        message.addRecipient(Message.RecipientType.TO, toAdress);
        message.setSubject("Doctor Pick Info");
        message.setContent(contentEmailMessage, "text/plain");
        Transport.send(message);

    }

}
