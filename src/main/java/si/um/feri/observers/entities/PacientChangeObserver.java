package si.um.feri.observers.entities;

import jakarta.mail.MessagingException;
import si.um.feri.observers.IObservable;
import si.um.feri.observers.IObserver;

import javax.naming.NamingException;
import java.util.List;

public class PacientChangeObserver implements IObserver {

    private List<IObserver> observers;

    @Override
    public void update() throws MessagingException, NamingException {

    }
}
