package si.um.feri.observers.pacientObservables;

import si.um.feri.observers.IObservable;
import si.um.feri.observers.IObserver;
import si.um.feri.observers.pacientObservables.concreteObservers.EmailAssigmentObserver;
import si.um.feri.observers.pacientObservables.concreteObservers.EmailRemovalObserver;
import si.um.feri.vao.Pacient;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PacientObservable implements IObservable, Serializable {
    private List<IObserver> observers = new ArrayList<>();

    public PacientObservable() {
        initializeObservers();
    }

    private void initializeObservers() {
        EmailAssigmentObserver emailAssigmentObserver = new EmailAssigmentObserver(this);
        EmailRemovalObserver emailRemovalObserver = new EmailRemovalObserver(this);
    }


    @Override
    public void add(IObserver observer) {
        observers.add(observer);
    }

    @Override
    public void remove(IObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for(IObserver observer : this.observers) {
            observer.update();
        }
    }

    public void notifyObservers(Pacient pacient, String eventType) {

        System.out.println(eventType);
//        System.out.println(this.observers);
        for(IObserver observer : this.observers) {
//            System.out.println("counter");
            observer.update(pacient,eventType);
        }
    }

    public List<IObserver> getObservers() {
        return observers;
    }

}
