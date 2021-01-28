package pl.rownicki.observable;

import pl.rownicki.observer.Observer;

public interface Subject {
    void registerObserver(Observer obs);
    void removeObserver(Observer obs);
    void notifyObservers();
}
