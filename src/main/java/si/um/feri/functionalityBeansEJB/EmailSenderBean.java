package si.um.feri.functionalityBeansEJB;

import jakarta.ejb.Remote;
import jakarta.ejb.Stateless;
import jakarta.mail.*;
import si.um.feri.interfaces.EmailSender;
import si.um.feri.vao.Doctor;

import java.io.Serializable;

import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import si.um.feri.vao.Pacient;
import javax.naming.InitialContext;
import javax.naming.NamingException;


@Stateless
@Remote
public class EmailSenderBean implements Serializable, EmailSender {


    @Override
    public void sendEmail(Doctor d, Pacient p) throws NamingException, MessagingException {

        InitialContext ctx = new InitialContext();
        Session session = (Session) ctx.lookup("java:jboss/mail/UMMail");
        Message message = new MimeMessage(session);
        InternetAddress toAdress = new InternetAddress(p.getEmail());
        message.addRecipient(Message.RecipientType.TO, toAdress);
        message.setSubject("Doctor Pick Info");

        if (d.getNumberOfPatients() >= d.getMaxNumberOfPatients()) {
            message.setContent("Dear " + p.getName() + " " + "\n We are sorry to inform you that you were unable to pick Doctor "
                    + d.getName() + d.getSurname()
                    + "because he already has an maximum number of patientes. \n Best Regards from Sveti Vracevi", "text/plain");
            Transport.send(message);
        } else if (d.getNumberOfPatients() < d.getMaxNumberOfPatients()) {
            System.out.print(" ovde sam " + d.getNumberOfPatients() + "<=" + d.getMaxNumberOfPatients());
            message.setContent("Dear " + p.getName() + "\n We are glad to inform you that you sucessfully picked Doctor "
                    + d.getName() + d.getSurname()
                    + "For more info please contact us. \n \n Best Regards from Sveti Vracevi", "text/plain");
            Transport.send(message);
        }


    }


//    @Override
//    public void sendEmail(Doctor d, Pacient p, String contentEmailMessage) throws NamingException, MessagingException {
//
//        InitialContext ctx = new InitialContext();
//        Session session = (Session) ctx.lookup("java:jboss/mail/UMMail");
//        Message message = new MimeMessage(session);
//        InternetAddress toAdress = new InternetAddress(p.getEmail());
//        message.addRecipient(Message.RecipientType.TO, toAdress);
//        message.setSubject("Doctor Pick Info");
//        message.setContent(contentEmailMessage, "text/plain");
//        Transport.send(message);
//
//
//
//    }





}



