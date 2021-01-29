package pl.rownicki.observable;

import pl.rownicki.model.Operacja;
import pl.rownicki.observer.Observer;

import java.util.ArrayList;

public class DzialanieObs implements Subject {
    ArrayList<Observer> obsArray = new ArrayList<>();
    String command = null;


    @Override
    public void registerObserver(Observer obs) {
        obsArray.add(obs);
    }

    @Override
    public void removeObserver(Observer obs) {
        obsArray.remove(obs);
    }

    @Override
    public void notifyObservers() {
        for(Observer obs: obsArray) {
            obs.update(command);
        }

    }

    public void setCommand(String command) {
        this.command = command;
        notifyObservers();
    }
}
