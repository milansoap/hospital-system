package si.um.feri.observers;

import jakarta.mail.MessagingException;
import si.um.feri.vao.Pacient;

import javax.naming.NamingException;

public interface IObserver {
    void update() throws MessagingException, NamingException;
}
