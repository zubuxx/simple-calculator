package pl.rownicki.model;

import pl.rownicki.controller.Controller;

public class RemoveText {
    public static void removeLast() {
        String currentText = Controller.getTextField();
        if(!currentText.equals("0"))
            Controller.setTextField(currentText.substring(0, Controller.getTextField().length()-1));
        if(currentText.equals(""))
            Controller.setTextField("0");
    }

    public static void removeAll() {
        if(!Controller.getTextField().equals("0"))
            Controller.setTextField("0");
        Controller.wykonajAkcje("C");
    }
}
