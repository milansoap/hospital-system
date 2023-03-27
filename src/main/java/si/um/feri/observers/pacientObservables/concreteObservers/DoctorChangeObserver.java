package si.um.feri.observers.pacientObservables.concreteObservers;

import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import jakarta.mail.MessagingException;
import si.um.feri.interfaces.EmailSender;
import si.um.feri.mailSender.MailSender;
import si.um.feri.observers.IObserver;
import si.um.feri.vao.Doctor;
import si.um.feri.vao.Pacient;

import javax.naming.NamingException;
import java.io.Serializable;


public class EmailRemovalObserver implements IObserver, Serializable {

    private Pacient pacient;
    private Doctor oldDoctor = null;
    private MailSender emailSender = new MailSender();

    public EmailRemovalObserver(Pacient p) {
        this.pacient = p;
        this.pacient.add(this);
    }


    @Override
    public void update() {

    }

    @Override
    public void update(Pacient pacient, String eventType)  {

        System.out.println("U REMOVALU SAM VAN IFa");

        if (eventType.equals("removal")) {
            System.out.println("U REMOVALU SAM UNUTAR OBSERVERA");
            Doctor removedDoctor = pacient.getDoctor();
            String message = "Hello " + pacient.getName() + ",\n\n"
                    + "Your doctor has been removed. Your previous doctor was " + removedDoctor.getName() + " " + removedDoctor.getSurname() + ".\n\n"
                    + "Best regards,\n"
                    + "The Medical Team";
            try {
                emailSender.sendEmail(removedDoctor,pacient,message);
            } catch (NamingException | MessagingException e) {
            }
//                emailSender.test();

        }





    }


}
