package GAME.Threads;

import OBJECTS.Duck;
import OBJECTS.MissedDucks;

import javax.swing.*;

public class MoveDuck extends Thread {
    Duck duck;
    public JButton button;
    public JPanel panel;
    public int starty;
    String from;
    int mode;


    MoveDuck(Duck duck, JButton button, JPanel panel, int starty, String from, int mode) {
        this.duck = duck;
        this.starty = starty;
        this.button = button;
        this.panel = panel;
        this.from = from;
        this.mode = mode;
    }

    public void run() {

        while (!isInterrupted()) {


            try {
                this.sleep(7);
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
                    duck.loc(button, panel, duck.getX() + mode, starty, "left");

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
                    duck.loc(button, panel, duck.getX() - mode, starty, "right");
                }
            }
        }

    }

}


