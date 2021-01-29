package pl.rownicki.observer;


import pl.rownicki.controller.Controller;
import pl.rownicki.model.*;
import pl.rownicki.observable.Subject;

public class Observer1 implements Observer {

    private Subject sub;
    private Operacja dzialanie = null;
    private double x = 0;


    public Observer1(Subject sub) {
        this.sub = sub;
        sub.registerObserver(this);
    }


    public void obliczIZaaktualizuj() {
        double wynik;
        double y = Controller.pobierzWynik();
        if(dzialanie != null) {
            wynik = this.dzialanie.oblicz(x, y);
        }
        else {
            wynik = y;
        }
        Controller.ustawWynik(wynik);
    }

    @Override
    public void update(String s) {
        if ("-+/*%=\u03C0".contains(s)) {
            if (!s.equals("=")) {
                x = Controller.pobierzWynik();
            }
            Controller.setLastOperation(true);
            switch (s) {
                case "+": {
                    setObecnaOperacja(new Dodawanie());
                    break;
                }
                case "-": {
                    setObecnaOperacja(new Odejmowanie());
                    break;
                }
                case "*": {
                    setObecnaOperacja(new Mnozenie());
                    break;
                }
                case "/": {
                    setObecnaOperacja(new Dzielenie());
                    break;
                }
                case "%": {
                    setObecnaOperacja(new Procent());
                    break;
                }
                case "=": {
                    obliczIZaaktualizuj();
                    setObecnaOperacja(null);
                    break;
                }
                case "\u03C0": {
                    Controller.ustawWynik(Math.PI);
                    break;
                }
                default:
                    System.out.println("Błąd");
                    break;
            }
        }
    }

    public void setObecnaOperacja(Operacja o) {
        dzialanie = o;
    }
}