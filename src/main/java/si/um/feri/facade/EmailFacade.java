package si.um.feri.facade;

import jakarta.ejb.EJB;
import jakarta.ejb.Remote;
import jakarta.ejb.Stateless;
import jakarta.mail.MessagingException;
import si.um.feri.interfaces.EmailSender;
import si.um.feri.mailSender.MailSender;
import si.um.feri.vao.Doctor;
import si.um.feri.vao.Pacient;

import javax.naming.NamingException;
import java.io.Serializable;

public class EmailFacade implements Serializable {

    private MailSender emailSender = new MailSender();

    public void sendEmail(Pacient p, String message) {
        try {
            emailSender.sendEmail(p,message);
        } catch (NamingException | MessagingException e) {
            // Handle exception
        }
    }

}

