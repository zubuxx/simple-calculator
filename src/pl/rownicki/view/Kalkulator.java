package pl.rownicki.view;

import pl.rownicki.config.Config;
import pl.rownicki.observer.KeyList;
import pl.rownicki.controller.Controller;
import pl.rownicki.model.RemoveText;
import pl.rownicki.model.WykonajOperacje;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Kalkulator extends JFrame  {

     private static JTextField textField;
     private GridBagConstraints c;

     private final KeyList keyList;

    public Kalkulator() {
        super("Kalkulator");
        keyList = new KeyList();
        this.stworzGUI();
    }

    public void stworzGUI() {

        JPanel pane = new JPanel(new GridBagLayout());
        setContentPane(pane);

        c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;

        textField = new JTextField(25);
        Font f1 = textField.getFont().deriveFont(31f);
        textField.setFont(f1);
        textField.setText("0");
        textField.setEditable(false);

        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        c.ipady = 10;
        pane.add(textField, c);

        stworzDzialania(pane);
        stworzLiczby(pane);

        addKeyListener(keyList);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setFocusable(true);
        setSize(Config.getWINDOW_WIDTH(), Config.getWINDOW_HEIGHT());
        setResizable(false);
        setVisible(true);

    }

    public void stworzDzialania(JPanel pane) {
        JButton deleteLast = new JButton("\u25C4");
        JButton deleteAll = new JButton("C");
        JButton add = new JButton("+");
        JButton sub = new JButton("-");
        JButton multi = new JButton("*");
        JButton div = new JButton("/");
        JButton procent = new JButton("%");
        JButton pi = new JButton("\u03C0");


        JButton[] buttons = new JButton[]{add, sub, multi, div, procent, pi};
        JPanel panel1 = new JPanel(new GridLayout(4,3));

        deleteLast.addActionListener(new RemoveLastListener());
        deleteLast.setFocusable(false);
        deleteAll.addActionListener(new RemoveAllListener());
        deleteAll.setFocusable(false);

        panel1.add(deleteLast);
        panel1.add(deleteAll);

        for(JButton b: buttons) {
            b.addActionListener(new dodajZnakListener());
            b.setFocusable(false);
            panel1.add(b);
        }


        c.gridy = 1;
        c.gridx = 0;
        c.gridwidth = 1;
        c.gridheight = 4;
        c.ipady = 120;


        pane.add(panel1, c);

    }

    public void stworzLiczby(JPanel pane) {
        JButton p0 = new JButton("0");
        JButton equals = new JButton("=");
        JButton p1 = new JButton("1");
        JButton p2 = new JButton("2");
        JButton p3 = new JButton("3");
        JButton p4 = new JButton("4");
        JButton p5 = new JButton("5");
        JButton p6 = new JButton("6");
        JButton p7 = new JButton("7");
        JButton p8 = new JButton("8");
        JButton p9 = new JButton("9");
        JButton comma = new JButton(",");
        JPanel panel1 = new JPanel(new GridLayout(4,3));

        JButton[] buttonsList = new JButton[] {p1,p2,p3,p4,p5,p6,p7,p8,p9,p0, comma};
        for(JButton button: buttonsList) {
            button.addActionListener(new dodajZnakListener());
            button.setFocusable(false);
            panel1.add(button);
        }

        equals.addActionListener(new dodajZnakListener());
        equals.setFocusable(false);
        panel1.add(equals);

        c.gridy = 1;
        c.gridx = 1;
        c.gridheight = 4;
        c.gridwidth = 1;
        c.ipady = 50;

        pane.add(panel1, c);
    }




    public static void setTextField(String text) {
        textField.setText(text);
    }

    public static String getTextField() {
        return textField.getText();
    }


    class dodajZnakListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String s = e.getActionCommand();
            Controller.wykonajAkcje(s);
        }
    }

    class RemoveLastListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            RemoveText.removeLast();
        }
    }

    class RemoveAllListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            RemoveText.removeAll();
        }
    }
}
