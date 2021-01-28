package pl.rownicki.observable;

import pl.rownicki.observer.Observer;

import java.util.ArrayList;

public class DaneKalkulatora implements Subject {
    ArrayList<Observer> arrayList = new ArrayList<>();
    @Override
    public void registerObserver(Observer obs) {
        arrayList.add(obs);

    }

    @Override
    public void removeObserver(Observer obs) {
        arrayList.remove(obs);
    }

    @Override
    public void notifyObservers() {

    }
}
