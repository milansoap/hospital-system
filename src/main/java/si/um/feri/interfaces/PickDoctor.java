package si.um.feri.interfaces;

import jakarta.ejb.Local;
import jakarta.mail.MessagingException;
import si.um.feri.vao.Doctor;
import si.um.feri.vao.Pacient;

import javax.naming.NamingException;

@Local
public interface PickDoctor {


    void sendEmail(Doctor d, Pacient p) throws NamingException, MessagingException;
    void consoleApp();


}
