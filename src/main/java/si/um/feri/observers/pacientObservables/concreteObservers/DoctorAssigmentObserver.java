package si.um.feri.observers.pacientObservables.concreteObservers;

import jakarta.mail.MessagingException;
import si.um.feri.mailSender.MailSender;
import si.um.feri.observers.IObserver;
import si.um.feri.vao.Doctor;
import si.um.feri.vao.Pacient;

import javax.naming.NamingException;
import java.io.Serializable;


public class DoctorAssigmentObserver implements IObserver, Serializable {

    Pacient pacient;
    private MailSender emailSender = new MailSender();

    public DoctorAssigmentObserver(Pacient pacient) {
        this.pacient = pacient;
//        this.pacient.add(this);
    }

    @Override
    public void update() throws MessagingException, NamingException {

        String message = "Hello " + pacient.getName() + ",\n\n"
                    + "Your chosen doctor" + pacient.getDoctorEmail()
                    + "Best regards,\n"
                    + "The Medical Team";

        emailSender.sendEmail(pacient, message);

    }

}
