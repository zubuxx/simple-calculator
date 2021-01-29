package pl.rownicki.Main;

import pl.rownicki.controller.Controller;
import pl.rownicki.observable.DzialanieObs;
import pl.rownicki.observer.Observer1;
import pl.rownicki.observer.Observer2;
import pl.rownicki.view.Kalkulator;

public class Start {
    public static void main(String[] args) {
        Kalkulator kalkulator = new Kalkulator();
        DzialanieObs dzialanieObs = new DzialanieObs();
        Observer1 obs1 = new Observer1(dzialanieObs);
        Observer2 obs2 = new Observer2(dzialanieObs);
        Controller.setDzialania(dzialanieObs);

    }
}
