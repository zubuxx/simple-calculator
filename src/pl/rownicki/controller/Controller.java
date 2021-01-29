package pl.rownicki.controller;

import pl.rownicki.config.Config;
import pl.rownicki.observable.DzialanieObs;
import pl.rownicki.observable.Subject;
import pl.rownicki.observer.Observer;
import pl.rownicki.view.Kalkulator;

public class Controller {
    private static DzialanieObs dzialania;
    private static boolean lastOperation = false;

    public static void setDzialania(DzialanieObs dzialania) {
        Controller.dzialania = dzialania;
    }

    public static void ustawWynik(double liczba) {
        if(Math.floor(liczba) == liczba)
            setTextField(String.valueOf(Math.round(liczba)));
        else
            setTextField(String.valueOf(liczba));
    }

    public static boolean isLastOperation() {
        return lastOperation;
    }

    public static void setLastOperation(boolean lastOperation) {
        Controller.lastOperation = lastOperation;
    }

    public static void wykonajAkcje(String command) {
        dzialania.setCommand(command);
    }

    public static double pobierzWynik() {
        return Double.parseDouble(Kalkulator.getTextField().replace(",", "."));
    }

    public static void setTextField(String text) {
        if(text.length() < Config.getNUMS_LIMIT()) {
            Kalkulator.setTextField(text);
        }
        else {
            Kalkulator.setTextField(text.substring(0, Config.getNUMS_LIMIT()));
        }
    }

    public static String getTextField() {
        return Kalkulator.getTextField();
    }



}
