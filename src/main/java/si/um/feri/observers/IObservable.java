package si.um.feri.observers;

import jakarta.mail.MessagingException;
import si.um.feri.vao.Pacient;

import javax.naming.NamingException;

public interface IObservable {
    void add(IObserver observer);
    void remove(IObserver observer);
    void notifyObservers() throws MessagingException, NamingException;

}
