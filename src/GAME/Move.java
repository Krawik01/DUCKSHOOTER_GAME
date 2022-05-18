package GAME;

import OBJECTS.Duck;
import OBJECTS.MissedDucks;

import javax.swing.*;
import java.util.Objects;

public class Move extends Thread {
    Duck duck;
    public JButton button;
    public JPanel panel;
    public int starty;
    String from;


    Move(Duck duck, JButton button, JPanel panel, int starty, String from) {
        this.duck = duck;
        this.starty = starty;
        this.button = button;
        this.panel = panel;
        this.from = from;
    }

    public void run() {

        while (!isInterrupted()) {


            try {
                this.sleep(5);
            } catch (InterruptedException exc) {
                interrupt();
              //  break;
            }

            if (from.equals("left")) {
                if (duck.getX() > 1940) {
                    panel.remove(this.duck);
                    MissedDucks.increment();
                    System.out.println("Missed ducks left:" + MissedDucks.getValue());
                    System.out.println("removed");
                    interrupt();
                    break;
                } else {
                    duck.loc(button, panel, duck.getX() + 1, starty, "left");

                }
            }

            if (from.equals("right")) {
                if (duck.getX() < 0) {
                    panel.remove(this.duck);
                    panel.updateUI();//aktualizuje obraz
                    MissedDucks.increment();
                    System.out.println("Missed ducks right:" + MissedDucks.getValue());
                    System.out.println("removed");
                    interrupt();
                    break;
                } else {
                    duck.loc(button, panel, duck.getX() - 1, starty, "right");
                }
            }
        }

    }
}


