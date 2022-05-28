package GAME.Threads;

import OBJECTS.Frog;

import javax.swing.*;

public class MoveFrog extends Thread {

    Frog cloud;
    JPanel panel;
    int mode;
    int startY;

    public MoveFrog(Frog cloud, JPanel panel, int mode, int startY) {
        this.cloud = cloud;
        this.panel = panel;
        this.mode = mode;
        this.startY = startY;
    }

    @Override
    public void run() {
        setFrogWithOtBackground();
        int speed = 3;
        while (!GameStop.end) {
            try {
                this.sleep(3);
            } catch (InterruptedException exc) {
                interrupt();
                //  break;
            }

            if(cloud.getX() == 1770){
                speed = -mode;
            }
            if(cloud.getX() == 0) {
                speed = mode;
            }
            panel.updateUI();
            cloud.loc(cloud, panel, cloud.getX() + speed, startY);
            panel.updateUI();
        }
    }
    public void setFrogWithOtBackground(){
        cloud.setOpaque(false);
        cloud.setContentAreaFilled(false);
        cloud.setBorderPainted(false);
    }
}
