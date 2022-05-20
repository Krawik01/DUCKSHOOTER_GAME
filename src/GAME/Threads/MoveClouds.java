package GAME.Threads;

import OBJECTS.Cloud;

import javax.swing.*;

public class MoveClouds extends Thread {

    Cloud cloud;
    JPanel panel;

    public MoveClouds(Cloud cloud, JPanel panel) {
        this.cloud = cloud;
        this.panel = panel;
    }

    @Override
    public void run() {

        int speed = 3;
        while (!isInterrupted()) {
            try {
                this.sleep(3);
            } catch (InterruptedException exc) {
                interrupt();
                //  break;
            }

            if(cloud.getX() == 1920){
                speed = -3;
            }
            if(cloud.getX() == 0) {
                speed = 3;
            }
            cloud.loc(cloud, panel, cloud.getX() + speed, 700);
        }
    }
}
