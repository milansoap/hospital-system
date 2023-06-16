package si.um.feri.strategy.concrete;

import si.um.feri.strategy.IVisitNotificationStrategy;

public class DefaultNotificationStrategy implements IVisitNotificationStrategy {
    @Override
    public void handleNotification() throws Exception {
        System.out.println(" I am doing nothing AT ALLLLLLLLLLLLLLLLLLLL ");
    }
}
