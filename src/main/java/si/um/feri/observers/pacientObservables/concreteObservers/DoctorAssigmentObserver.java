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


public class EmailAssigmentObserver implements IObserver, Serializable {

    Pacient pacient;
    private MailSender emailSender = new MailSender();

    public EmailAssigmentObserver(Pacient p) {
        this.pacient = p;
        this.pacient.add(this);
    }


    @Override
    public void update() {
    }
    @Override
    public void update(Pacient pacient, String eventType)  {
        System.out.println("U ASSIGMENTU SAM VAN IFA");
        if (eventType.equals("assignment")) {
            System.out.println("U ASSIGMENTU SAM UNUTAR OBSERVERA");
            Doctor addedDoctor = pacient.getDoctor();
            String message = "Hello " + pacient.getName() + ",\n\n"
                    + "Your chosen doctor" + addedDoctor.getName() + " " + addedDoctor.getSurname() + ".\n\n"
                    + "Best regards,\n"
                    + "The Medical Team";
            if (emailSender == null) {
                System.out.println("NULL JE");
            }
            else {
                System.out.println("NIJE NULL JE");
            }

//            emailSender.test();

            try {
                emailSender.sendEmail(addedDoctor,pacient,message);
            } catch (NamingException  | MessagingException | NullPointerException e) {
                System.out.println("NULL JE");
            }

        }





    }

}
