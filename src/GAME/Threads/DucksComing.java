package GAME.Threads;

import MENU.Mode;
import OBJECTS.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class DucksComing extends Thread implements Mode {

    JPanel panel;
    Gun gun;
    int mode;
   public static JLabel pointsL = new JLabel("score " + Points.getValue());

    public DucksComing(JPanel panel,Gun gun,int mode){
        this.panel = panel;
        this.gun = gun;
        this.mode = mode;
    }

    public void run() {

        while (!ShouldGameStopCheck.end) {
             levels(gun,panel,mode,2000);//stages 1-5

        }

    }

    public void levels(Gun gun, JPanel panel, int mode, int millis) {

        String r = "right";
        String l = "left";


        //stage 1
        if (Points.getValue() <= 80) {

            addMovingduck(800, "yellow", gun, panel, l, mode);
            addMovingduck(670, "yellow", gun, panel, r, mode);

            wait(millis);

            addMovingduck(410, "red", gun, panel, r, mode);
            addMovingduck(540, "yellow", gun, panel, l, mode);

            wait(millis);
            addMovingduck(410, "yellow", gun, panel, r, mode);
            addMovingduck(540, "red", gun, panel, l, mode);
            addMovingduck(670, "yellow", gun, panel, r, mode);

            wait(millis);

        }
        //stage 2
        if ((Points.getValue() > 80) && (Points.getValue() <= 200)) {

            addMovingduck(410, "purple", gun, panel, r, mode);
            addMovingduck(670, "yellow", gun, panel, r, mode);

            wait(millis);

            addMovingduck(540, "red", gun, panel, r, mode);
            addMovingduck(670, "purple", gun, panel, l, mode);

            wait(millis);

            addMovingduck(800, "pink", gun, panel, r, mode);

            wait(millis);
        }
        //stage 3
        if ((Points.getValue() > 200) && (Points.getValue() < 350)) {

            addMovingduck(410, "purple", gun, panel, r, mode);
            addMovingduck(540, "red", gun, panel, l, mode);
            addMovingduck(800, "yellow", gun, panel, l, mode);

            wait(millis);

            addMovingduck(800, "pink", gun, panel, l, mode);

            wait(millis);

            addMovingduck(410, "yellow", gun, panel, r, mode);
            addMovingduck(540, "red", gun, panel, l, mode);
            wait(millis);
        } //stage 3
        if ((Points.getValue() > 350) && (Points.getValue() < 700)) {
            addMovingduck(670, "red", gun, panel, r, mode);
            addMovingduck(800, "yellow", gun, panel, l, mode);

            wait(millis);
            addMovingduck(410, "pink", gun, panel, r, mode);
            addMovingduck(540, "purple", gun, panel, l, mode);

            wait(millis);

            addMovingduck(800, "yellow", gun, panel, l, mode);

        } if(Points.getValue() >= 700) {
            addMovingduck(670, "red", gun, panel, r, mode);
            addMovingduck(410, "pink", gun, panel, r, mode);
            addMovingduck(800, "purple", gun, panel, l, mode);

            wait(millis);

            addMovingduck(540, "red", gun, panel, l, mode);
            addMovingduck(410, "yellow", gun, panel, r, mode);
        }
    }


    public static void wait(int millis){
        try {
            sleep(millis);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void addMovingduck(int start, String type, Gun gun, JPanel panel,String from,int mode) {
       Duck duck = new Duck(type,panel,from, start);


       pointsL.setPreferredSize(new Dimension(100,100));
       pointsL.setLocation(100,100);
       panel.add(pointsL);



       if(Objects.equals(from,"left")) {
           if (Objects.equals(type, "yellow")) {
               duck.setBackground(Color.YELLOW);
               duck.setIcon(new ImageIcon("RESOURCES\\YellowDuckR.png"));
           }
           if (Objects.equals(type, "red")) {
               duck.setBackground(Color.red);
               duck.setIcon(new ImageIcon("RESOURCES\\RedDuckR.png"));
           }
           if (Objects.equals(type, "purple")) {
               duck.setBackground(Color.blue);
               duck.setIcon(new ImageIcon("RESOURCES\\PurpleDuckR.png"));
           }
           if (Objects.equals(type, "pink")) {
               duck.setBackground(Color.pink);
               duck.setIcon(new ImageIcon("RESOURCES\\PinkDuckR.png"));
           }
       } else {
           if (Objects.equals(type, "yellow")) {
               duck.setBackground(Color.YELLOW);
               duck.setIcon(new ImageIcon("RESOURCES\\YellowDuckL.png"));
           }
           if (Objects.equals(type, "red")) {
               duck.setBackground(Color.red);
               duck.setIcon(new ImageIcon("RESOURCES\\RedDuckL.png"));
           }
           if (Objects.equals(type, "purple")) {
               duck.setBackground(Color.blue);
               duck.setIcon(new ImageIcon("RESOURCES\\PurpleDuckL.png"));
           }
           if (Objects.equals(type, "pink")) {
               duck.setBackground(Color.pink);
               duck.setIcon(new ImageIcon("RESOURCES\\PinkDuckL.png"));
           }
       }



        MoveDuck moveDuck = new MoveDuck(duck, duck, panel, start, from, mode);

        final int[] clicks = {0};

        duck.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clicks[0]++;

                if(Objects.equals(type, "yellow")){
                    duck.setVisible(false);
                    panel.remove(duck);
                    moveDuck.interrupt();
                    Points.increment(1);
                   // Points.setScoresCounter(pointsL,panel,Points.getValue());
                    GunLevel.checkPoints(gun);

                }

                if(Objects.equals(type, "red")) {
                    if (clicks[0] >= DucksHp.redDuckHpGetValue()/GunLevel.getValue()) {
                        duck.setVisible(false);
                        panel.remove(duck);
                        moveDuck.interrupt();
                        Points.increment(5);
                        GunLevel.checkPoints(gun);
                       // Points.setScoresCounter(pointsL, panel,Points.getValue());
                    }
                }
                if(Objects.equals(type, "purple")) {
                    if (clicks[0] >= DucksHp.purpleDuckHpGetValue()/GunLevel.getValue()) {
                        duck.setVisible(false);
                        panel.remove(duck);
                        moveDuck.interrupt();
                        Points.increment(10);
                        GunLevel.checkPoints(gun);
                    //    Points.setScoresCounter(pointsL, panel,Points.getValue());

                    }
                }
                if(Objects.equals(type, "pink")) {
                    if (clicks[0] >= DucksHp.pinkDuckHpGetValue()/GunLevel.getValue()) {
                        duck.setVisible(false);
                        panel.remove(duck);
                        moveDuck.interrupt();
                        Points.increment(20);
                        GunLevel.checkPoints(gun);
                      //  Points.setScoresCounter(pointsL, panel,Points.getValue());

                    }
                }
            }
        });

        moveDuck.start();

    }

}
