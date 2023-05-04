package si.um.feri.observers.pacientObservables.concreteObservers;

import jakarta.mail.MessagingException;
import si.um.feri.facade.EmailFacade;
import si.um.feri.mailSender.MailSender;
import si.um.feri.observers.IObserver;
import si.um.feri.vao.Doctor;
import si.um.feri.vao.Pacient;

import javax.naming.NamingException;
import java.io.Serializable;


public class DoctorChangeObserver implements IObserver, Serializable {

    private Pacient pacient;
    private Doctor oldDoctor = null;
    private EmailFacade emailSender = new EmailFacade();

//    public DoctorChangeObserver(Pacient pacient) {
//        this.pacient = pacient;
//
//        try {
//            oldDoctor = pacient.getDoctor();
//        }
//        catch (Exception e) {
//
//        }
//        pacient.add(this);
//    }
    @Override
    public void update() {
        System.out.println("brate");
        if (oldDoctor != null) {
            String message = "Hello " + pacient.getName() + ",\n\n"
                    + "Your doctor has been removed. Your previous doctor was " + oldDoctor.getName() + " " + oldDoctor.getSurname() + ".\n\n"
                    + "Best regards,\n"
                    + "The Medical Team";

            emailSender.sendEmail(pacient, message);
        }
    }



}
