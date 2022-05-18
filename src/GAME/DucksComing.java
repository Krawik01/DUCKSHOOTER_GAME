package GAME;

import OBJECTS.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class DucksComing extends Thread {

    JPanel panel;


    int day;
    Gun gun;
   public static JLabel pointsL = new JLabel("score " + Points.getValue());

    public DucksComing(JPanel panel,Gun gun){
        this.panel = panel;
        this.gun = gun;
    }

    public void run() {

        while (!isInterrupted()) {
             levels(gun,panel);
        }

    }

    public static void levels(Gun gun, JPanel panel){

        String r = "right";
        String l = "left";

        //stage 1
        if(Points.getValue() <= 80) {
            addMovingduck(540,"yellow",gun,panel,r);
            addMovingduck(700,"red",gun,panel,l);
            addMovingduck(780,"yellow",gun,panel,l);


            wait(2000);

            addMovingduck(620,"red",gun,panel,l);
            addMovingduck(850,"yellow",gun,panel,r);


            wait(4000);

            addMovingduck(460,"yellow",gun,panel,r);
            addMovingduck(940,"red",gun,panel,l);
            addMovingduck(700,"yellow",gun,panel,r);

            wait(3000);

            }
        //stage 2
        if((Points.getValue() > 80)&&(Points.getValue() <= 200)){
            addMovingduck(460,"red",gun,panel,r);
            addMovingduck(860,"purple",gun,panel,l);
            addMovingduck(620,"yellow",gun,panel,r);

            wait(3000);

            addMovingduck(940,"red",gun,panel,r);
            addMovingduck(700,"purple",gun,panel,l);

            wait(4000);

            addMovingduck(540,"yellow",gun,panel,l);
            addMovingduck(860,"pink",gun,panel,r);

            wait(3000);
        }

    }

    public static void wait(int millis){
        try {
            sleep(millis);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void addMovingduck(int start, String type, Gun gun, JPanel panel,String from) {
       Duck duck = new Duck(type,panel,from, start);


       pointsL.setPreferredSize(new Dimension(100,100));
       pointsL.setLocation(100,100);
       panel.add(pointsL);


       if(Objects.equals(from,"left")) {
           if (Objects.equals(type, "yellow")) {
               duck.setBackground(Color.YELLOW);
               duck.setIcon(new ImageIcon("C:\\Users\\SZEF\\Desktop\\DUCKSHOOTER\\src\\RESOURCES\\YellowDuckR.png"));
           }
           if (Objects.equals(type, "red")) {
               duck.setBackground(Color.red);
               duck.setIcon(new ImageIcon("C:\\Users\\SZEF\\Desktop\\DUCKSHOOTER\\src\\RESOURCES\\RedDuckR.png"));
           }
           if (Objects.equals(type, "purple")) {
               duck.setBackground(Color.blue);
               duck.setIcon(new ImageIcon("C:\\Users\\SZEF\\Desktop\\DUCKSHOOTER\\src\\RESOURCES\\PurpleDuckR.png"));
           }
           if (Objects.equals(type, "pink")) {
               duck.setBackground(Color.pink);
               duck.setIcon(new ImageIcon("C:\\Users\\SZEF\\Desktop\\DUCKSHOOTER\\src\\RESOURCES\\PinkDuckR.png"));
           }
       } else {
           if (Objects.equals(type, "yellow")) {
               duck.setBackground(Color.YELLOW);
               duck.setIcon(new ImageIcon("C:\\Users\\SZEF\\Desktop\\DUCKSHOOTER\\src\\RESOURCES\\YellowDuckL.png"));
           }
           if (Objects.equals(type, "red")) {
               duck.setBackground(Color.red);
               duck.setIcon(new ImageIcon("C:\\Users\\SZEF\\Desktop\\DUCKSHOOTER\\src\\RESOURCES\\RedDuckL.png"));
           }
           if (Objects.equals(type, "purple")) {
               duck.setBackground(Color.blue);
               duck.setIcon(new ImageIcon("C:\\Users\\SZEF\\Desktop\\DUCKSHOOTER\\src\\RESOURCES\\PurpleDuckL.png"));
           }
           if (Objects.equals(type, "pink")) {
               duck.setBackground(Color.pink);
               duck.setIcon(new ImageIcon("C:\\Users\\SZEF\\Desktop\\DUCKSHOOTER\\src\\RESOURCES\\PinkDuckL.png"));
           }
       }


        Move move = new Move(duck, duck, panel, start, from);

        final int[] clicks = {0};

        duck.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clicks[0]++;

                if(Objects.equals(type, "yellow")){
                    duck.setVisible(false);
                    panel.remove(duck);
                    move.interrupt();
                    Points.increment(1);
                    System.out.println(Points.getValue());
                   // Points.setScoresCounter(pointsL,panel,Points.getValue());
                    GunLevel.checkPoints(gun);

                }

                if(Objects.equals(type, "red")) {
                    if (clicks[0] >= DucksHp.redDuckHpGetValue()/GunLevel.getValue()) {
                        duck.setVisible(false);
                        panel.remove(duck);
                        move.interrupt();
                        Points.increment(5);
                        System.out.println(Points.getValue());
                        GunLevel.checkPoints(gun);
                       // Points.setScoresCounter(pointsL, panel,Points.getValue());
                    }
                }
                if(Objects.equals(type, "purple")) {
                    if (clicks[0] >= DucksHp.purpleDuckHpGetValue()/GunLevel.getValue()) {
                        duck.setVisible(false);
                        panel.remove(duck);
                        move.interrupt();
                        Points.increment(10);
                        System.out.println(Points.getValue());
                        GunLevel.checkPoints(gun);
                    //    Points.setScoresCounter(pointsL, panel,Points.getValue());

                    }
                }
                if(Objects.equals(type, "pink")) {
                    if (clicks[0] >= DucksHp.pinkDuckHpGetValue()/GunLevel.getValue()) {
                        System.out.println(20/GunLevel.getValue());
                        duck.setVisible(false);
                        panel.remove(duck);
                        move.interrupt();
                        Points.increment(20);
                        System.out.println(Points.getValue());
                        GunLevel.checkPoints(gun);
                      //  Points.setScoresCounter(pointsL, panel,Points.getValue());

                    }
                }
            }
        });

        move.start();

    }

}
