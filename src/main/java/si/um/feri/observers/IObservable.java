package si.um.feri.observers;

import si.um.feri.vao.Pacient;

public interface IObservable {
    void add(IObserver observer);
    void remove(IObserver observer);
    void notifyObservers();
    void notifyObservers(Pacient pacient, String eventType);

}
