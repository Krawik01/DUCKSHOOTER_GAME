package GAME.Threads;

import OBJECTS.MissedDucks;
import OBJECTS.Points;

import javax.swing.*;
import java.awt.*;

public class TimerInGame extends Thread{

    public static int timeInGameSecounds;
    public static int timeInGameMinutes;
    
    JPanel panel;
    JLabel timerLabel;
    JLabel pointsLabel;
    JLabel missedDucksLabel;


    Font fnt0 = new Font("Agency FB", Font.BOLD, 50);


    public TimerInGame(JPanel panel){
        this.panel = panel;
    }

    @Override
    public void run() {
        timeInGameSecounds = 0;
        timeInGameMinutes = 0;
        
        timerLabel = new JLabel();
        timerLabel.setBounds(10,10,200,100);
        timerLabel.setHorizontalAlignment(JLabel.CENTER);
        timerLabel.setFont(fnt0);
        panel.add(timerLabel);

        pointsLabel = new JLabel();
        pointsLabel.setBounds(2,80,200,100);
        pointsLabel.setHorizontalAlignment(JLabel.CENTER);
        pointsLabel.setFont(fnt0);
        panel.add(pointsLabel);

        missedDucksLabel = new JLabel();
        missedDucksLabel.setBounds(5,150,250,100);
        missedDucksLabel.setHorizontalAlignment(JLabel.CENTER);
        missedDucksLabel.setFont(fnt0);
        panel.add(missedDucksLabel);

        while (!isInterrupted()) {

            try {
                this.sleep(1000);
            } catch (InterruptedException exc) {
                interrupt();
                //  break;
            }

            if(timeInGameSecounds == 60){
                timeInGameMinutes++;
                timeInGameSecounds = 0;
            }
            if(timeInGameMinutes < 10){
                if(timeInGameSecounds<10) {
                    timerLabel.setText("0" + timeInGameMinutes + ":0" + timeInGameSecounds);
                }
                else {
                    timerLabel.setText("0" + timeInGameMinutes + ":" + timeInGameSecounds);
                }
            } else {
                if(timeInGameSecounds<10) {
                    timerLabel.setText(timeInGameMinutes + ":0" + timeInGameSecounds);
                }
                else {
                    timerLabel.setText(timeInGameMinutes + ":" + timeInGameSecounds);
                }
            }

            timeInGameSecounds++;

            pointsLabel.setText("Points: " + Points.getValue());

            missedDucksLabel.setText("Missed: " + MissedDucks.getValue() + "/10");



        }
    }
//    public static void setTime(int timeInGameSecounds, int timeInGameMinutes){
//        if(timeInGameSecounds == 60){
//
//            timeInGameSecounds = 0;
//            timeInGameMinutes++;
//        }
//    }

}
