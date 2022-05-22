package GAME.Threads;

import OBJECTS.Cloud;
import OBJECTS.Frog;

import javax.swing.*;

public class MoveCloud extends Thread {

    Cloud cloud;
    JPanel panel;
    int mode;
    int startY;

    public MoveCloud(Cloud cloud, JPanel panel, int mode, int startY) {
        this.cloud = cloud;
        this.panel = panel;
        this.mode = mode;
        this.startY = startY;
    }

    @Override
    public void run() {
        setCloudWithOutBackground();
        int speed = 3;
        while (!ShouldGameStopCheck.end) {
            try {
                this.sleep(2);
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
    public void setCloudWithOutBackground(){
        cloud.setOpaque(false);
        cloud.setContentAreaFilled(false);
        cloud.setBorderPainted(false);
    }
}
