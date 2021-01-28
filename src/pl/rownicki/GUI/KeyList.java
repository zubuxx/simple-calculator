package pl.rownicki.GUI;

import pl.rownicki.view.Kalkulator;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyList implements KeyListener {
    private Kalkulator kalkulator;

    public void setKalkulator(Kalkulator kalkulator) {
        this.kalkulator = kalkulator;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        String nums = "0123456789.,";
        String tasks = "-+/*%p";

        String command = String.valueOf(e.getKeyChar()).replace(".",",");
        if(nums.contains(command))
            kalkulator.dodajZnak(command);
        if(tasks.contains(command))
            kalkulator.getOp().wykonajDzialanie(command);

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == 8) {
            kalkulator.removeLast();
        }
        else if(e.getKeyCode() == 10) {
            kalkulator.getOp().wykonajDzialanie("=");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
