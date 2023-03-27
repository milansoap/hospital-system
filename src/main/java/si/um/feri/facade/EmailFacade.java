package si.um.feri.facade;

import jakarta.ejb.EJB;
import jakarta.ejb.Remote;
import jakarta.ejb.Stateless;
import jakarta.mail.MessagingException;
import si.um.feri.interfaces.EmailSender;
import si.um.feri.vao.Doctor;
import si.um.feri.vao.Pacient;

import javax.naming.NamingException;
import java.io.Serializable;


@Stateless
public class EmailFacade implements Serializable {

    @EJB
    EmailSender emailSender;

    public void sendDoctorPickInfo(Doctor d, Pacient p) {
        try {
            emailSender.sendEmail(d, p);
        } catch (NamingException | MessagingException e) {
            // Handle exception
        }
    }

    public void sendEmail(Doctor d, Pacient p, String message) {
        try {
            emailSender.sendEmail(d, p,message);
        } catch (NamingException | MessagingException e) {
            // Handle exception
        }
    }

    public void test() {
        System.out.println("BITENG");
    }

}

