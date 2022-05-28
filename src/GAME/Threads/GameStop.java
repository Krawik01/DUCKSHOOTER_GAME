package GAME.Threads;

import GAME.Game;
import GAME.GameModeFrame;
import MENU.HighScore;
import MENU.Mode;
import OBJECTS.MissedDucks;
import OBJECTS.Player;
import OBJECTS.Points;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;

public class GameStop extends Thread implements Mode {
    public static Player player;
    public static File file = new File("RESOURCES\\players.bin");
    JFrame frame;
    JPanel panel;

    public static String nicks;
    public static boolean end = false;
    JLabel gameOverLabel;
    Font fnt0 = new Font("Agency FB", Font.BOLD, 200);
    public int playersN = 0;

    public GameStop(JFrame frame, JPanel panel) {
        this.frame = frame;
        this.panel = panel;
    }

    @Override
    public void run() {

        gameOverLabel = new JLabel();
        gameOverLabel.setBounds(450,5,1000,500);
        gameOverLabel.setHorizontalAlignment(JLabel.CENTER);
        gameOverLabel.setFont(fnt0);
    //    gameOverLabel.setVisible(false);
        panel.add(gameOverLabel);

        while (!isInterrupted()) {
            try {
                this.sleep(7);
            } catch (InterruptedException exc) {
                interrupt();

            }

            if (MissedDucks.getValue() > 10) {
                end();
                gameOverLabel.setText("GAME OVER");
                nicks = JOptionPane.showInputDialog(null,
                        "Your nickname: ",
                        "Enter your nickname",
                        JOptionPane.PLAIN_MESSAGE);
                System.out.println(nicks);


                Player player = new Player(nicks,Points.getValue()* GameModeFrame.getMode,returnTimeMinutes(),returnTimeSecounds());
                System.out.println(nicks + "played on:" + GameModeFrame.getMode + " mode");

                //Collections.sort(player);
                Player.playersList.add(player);

//                Player.playersList.sort(new Comparator<Player>() {
//                    @Override
//                    public int compare(Player o1, Player o2) {
//                        return o2.points().compareTo(o1.points);
//                    }
//                });

                try {
                    writeObjectToFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                frame.dispose();
                HpIncrement.interrupted();
                interrupt();
                break;
            }
        }
    }
    public static String returnNick(){
        return nicks;
    }
    public static int returnPoints(){
       return Points.getValue();
    }
    public static int returnTimeMinutes(){
        return TimerInGame.timeInGameMinutes;
    }
    public static int returnTimeSecounds(){
        return TimerInGame.timeInGameSecounds;
    }


    public void writeObjectToFile() throws IOException {
        File file = new File("PlayersList.txt");

        if(!file.exists()){
            file.createNewFile();
        }

        FileOutputStream fileOutputStream = new FileOutputStream("PlayersList.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(Player.playersList);
        objectOutputStream.flush();
        objectOutputStream.close();
    }



    public boolean end(){
        end = true;
        return end;
    }
}

