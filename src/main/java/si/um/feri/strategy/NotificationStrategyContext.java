package si.um.feri.strategy;

import si.um.feri.strategy.concrete.DefaultNotificationStrategy;
import si.um.feri.strategy.concrete.MedicationNotificationStrategy;
import si.um.feri.strategy.concrete.NotesNotificationStrategy;
import si.um.feri.vao.Visit;

public class NotificationStrategyContext {
    private final Visit visit;
    private IVisitNotificationStrategy strategy;

    public NotificationStrategyContext(Visit visit) throws Exception {
        this.visit = visit;
        this.handleNotificationContext();
    }
    public void setStrategy(IVisitNotificationStrategy strategy) {
        this.strategy =strategy;
    }

    public void handleNotification() throws Exception {
        strategy.handleNotification();
    }

    private void handleNotificationContext() throws Exception {
            if ((visit.getNotes().isEmpty() || visit.getNotes().isBlank() || visit.getNotes() == null) && (visit.getMedications().isBlank() || visit.getMedications().isEmpty() || visit.getMedications() == null)) {
                setStrategy(new DefaultNotificationStrategy());
            } else if (!visit.getNotes().isEmpty() && !visit.getNotes().isBlank() && visit.getNotes() != null) {
                setStrategy(new NotesNotificationStrategy(visit.getNotes(), visit.getPacientEmail()));
            } else if (!visit.getMedications().isBlank() && !visit.getMedications().isEmpty() && visit.getMedications() != null) {
                setStrategy(new MedicationNotificationStrategy(visit.getMedications(), visit.getPacientEmail()));
            }
            handleNotification();
    }

}
