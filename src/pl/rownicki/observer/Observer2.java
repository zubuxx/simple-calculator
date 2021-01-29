package pl.rownicki.observer;

import pl.rownicki.config.Config;
import pl.rownicki.controller.Controller;
import pl.rownicki.observable.Subject;
import pl.rownicki.view.Kalkulator;

public class Observer2 implements Observer {
    private Subject sub = null;

    public Observer2(Subject sub) {
        this.sub = sub;
        sub.registerObserver(this);
    }

    @Override
    public void update(String s) {
        if("123456789,.".contains(s))
            dodajZnak(s);
    }

    public static void dodajZnak(String command) {
        String currentTxt = Kalkulator.getTextField();
        int limit = Config.getNUMS_LIMIT();
        if(Controller.isLastOperation()) {
            Kalkulator.setTextField("0");
            Controller.setLastOperation(false);
            currentTxt = Kalkulator.getTextField();
        }
        if ((command.equals(",") & currentTxt.contains(command)) || (command.equals("0") || command.equals("00"))
                & currentTxt.equals("0")) {
        }
        else if(currentTxt.equals("0") & !command.equals(",")) {
            Kalkulator.setTextField(command);
        }
        else if(currentTxt.length() < limit) {
            Kalkulator.setTextField(currentTxt + command);
        }
    }
}
