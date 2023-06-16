package si.um.feri.strategy.concrete;

import jakarta.ejb.EJB;
import si.um.feri.functionalityBeansEJB.EmailSenderBean;
import si.um.feri.interfaces.EmailSender;
import si.um.feri.strategy.IVisitNotificationStrategy;

public class MedicationNotificationStrategy implements IVisitNotificationStrategy {

    private final String content;
    private final String email;

    private EmailSender emailSender;

    public MedicationNotificationStrategy(String content, String email, EmailSender emailSender) {
        this.content = content;
        this.email = email;
        this.emailSender = emailSender;
    }

    public MedicationNotificationStrategy(String content, String email) {
        this.content = content;
        this.email = email;
    }

    @Override
    public void handleNotification() throws Exception {
        System.out.print("Sending via EMAIL");
        EmailSenderBean.getInstance().sendNotificationEmail(content, email);

    }
}
