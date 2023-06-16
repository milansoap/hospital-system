package si.um.feri.strategy.concrete;

import si.um.feri.functionalityBeansEJB.EmailSenderBean;
import si.um.feri.interfaces.EmailSender;
import si.um.feri.strategy.IVisitNotificationStrategy;

public class NotesNotificationStrategy implements IVisitNotificationStrategy {

    private final String notes;
    private final String email;

    public NotesNotificationStrategy(String notes, String email) {
        this.notes = notes;
        this.email = email;
    }

    @Override
    public void handleNotification() throws Exception {
        EmailSenderBean.getInstance().sendNoteEmail(notes,email);
    }
}
