package GAME.Threads;

import OBJECTS.DucksHp;
import OBJECTS.MissedDucks;
import OBJECTS.Points;

import javax.swing.*;

public class
HpIncrement extends Thread implements Runnable {
    public static int secounds = 0;
    ImageIcon icon = new ImageIcon("C:\\Users\\SZEF\\Desktop\\DUCKSHOOTER\\out\\production\\DUCKSHOOTER\\RESOURCES\\GameBackGround.jpg");
    JPanel panel;
    public HpIncrement(JPanel panel){
        this.panel = panel;
    }
    public void run() {

        while (!ShouldGameStopCheck.end) {
            try {
                this.sleep(5000);
                // notify();
            } catch (InterruptedException exc) {
                System.out.println("Timer has been stoped.");
                return;
            }


        if(Points.getValue() <= 80){
            System.out.println("yellow duck hp incremented");
            DucksHp.incrementYellowDuckHp(1);
        }
        if((Points.getValue() > 80)&&(Points.getValue() <= 200)){
            System.out.println("red duck hp incremented");
            DucksHp.incrementRedDuckHp(1);

        }
        if((Points.getValue() > 200)&&(Points.getValue() <= 350)){
            System.out.println("purple duck hp incremented");
                DucksHp.incrementPurpleDuckHp(1);
        }
        else {
            System.out.println("pink duck hp incremented");
            DucksHp.incrementPinkDuckHp(1);
        }





        }
    }

}
