package pl.rownicki.model;

import pl.rownicki.controller.Controller;
import pl.rownicki.observer.Observer;
import pl.rownicki.view.Kalkulator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WykonajOperacje implements ActionListener {
    private Operacja obecnaOperacja;
    private double x = 0;
    private Kalkulator kalkulator;
    private Observer obs;

    public void setObs(Observer obs) {
        this.obs = obs;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setObecnaOperacja(Operacja obecnaOperacja) {
        this.obecnaOperacja = obecnaOperacja;
    }

    public void setKalkulator(Kalkulator kalkulator) {
        this.kalkulator = kalkulator;
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        String buttonText = e.getActionCommand().replace("\u03C0", "p");

    }

}
