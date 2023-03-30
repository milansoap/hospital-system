package si.um.feri.interfaces;

import jakarta.ejb.Remote;
import jakarta.mail.MessagingException;

import javax.naming.NamingException;

@Remote
public interface SetDoctor {

    void addDoctorToPatient(String emailP, String emailD) throws MessagingException, NamingException;

}
