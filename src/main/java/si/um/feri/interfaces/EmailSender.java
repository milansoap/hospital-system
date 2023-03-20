package si.um.feri.interfaces;

import jakarta.ejb.Local;
import jakarta.ejb.Remote;
import jakarta.mail.MessagingException;
import si.um.feri.vao.Doctor;
import si.um.feri.vao.Pacient;

import javax.naming.NamingException;

@Remote
public interface EmailSender {


    void sendEmail(Doctor d, Pacient p) throws NamingException, MessagingException;
    void consoleApp();


}
