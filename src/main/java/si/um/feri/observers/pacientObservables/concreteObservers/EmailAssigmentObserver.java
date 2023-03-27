package si.um.feri.observers.pacientObservables.concreteObservers;

import jakarta.ejb.EJB;
import jakarta.ejb.Singleton;
import jakarta.ejb.Stateful;
import jakarta.ejb.Stateless;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.mail.MessagingException;
import si.um.feri.app;
import si.um.feri.facade.EmailFacade;
import si.um.feri.interfaces.EmailSender;
import si.um.feri.observers.IObserver;
import si.um.feri.observers.pacientObservables.PacientObservable;
import si.um.feri.vao.Doctor;
import si.um.feri.vao.Pacient;

import javax.naming.NamingException;
import java.io.Serializable;


public class EmailAssigmentObserver implements IObserver, Serializable {

    PacientObservable pacientObservable;
    @EJB
    EmailSender emailSender;

    public EmailAssigmentObserver(PacientObservable pacientObservable) {
        this.pacientObservable = pacientObservable;
        pacientObservable.add(this);
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
