package pl.rownicki.model;

import pl.rownicki.view.Kalkulator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WykonajOperacje implements ActionListener {
    private Operacja obecnaOperacja;
    private double x = 0;
    private Kalkulator kalkulator;

    public void setX(double x) {
        this.x = x;
    }

    public void setObecnaOperacja(Operacja obecnaOperacja) {
        this.obecnaOperacja = obecnaOperacja;
    }

    public void setKalkulator(Kalkulator kalkulator) {
        this.kalkulator = kalkulator;
    }

    public void obliczIZaaktualizuj() {
        double wynik;
        double y = kalkulator.pobierzWynik();
        if(obecnaOperacja != null) {
            wynik = this.obecnaOperacja.oblicz(x, y);
        }
        else {
            wynik = y;
        }
        kalkulator.ustawWynik(wynik);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String buttonText = e.getActionCommand().replace("\u03C0", "p");
        wykonajDzialanie(buttonText);

    }
    public void wykonajDzialanie(String command) {
        if(!command.equals("=")) {
            x = kalkulator.pobierzWynik();
        }
        kalkulator.setSaved(true);
        switch (command){
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
                break;
            }
            case "p": {
                kalkulator.ustawWynik(Math.PI);
                break;
            }
            default:
                System.out.println("Błąd");
                break;
        }
    }

}
