package pl.rownicki.observer;

import pl.rownicki.controller.Controller;
import pl.rownicki.model.RemoveText;
import pl.rownicki.view.Kalkulator;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyList implements KeyListener {

    @Override
    public void keyTyped(KeyEvent e) {
        String nums = "0123456789.,";
        String tasks = "-+/*%p";

        String command = String.valueOf(e.getKeyChar()).replace(".",",");
        Controller.wykonajAkcje(command);


    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == 8) {
            RemoveText.removeLast();
        }
        else if(e.getKeyCode() == 10) {
            Controller.wykonajAkcje("=");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
