package GAME.Threads;

import OBJECTS.MissedDucks;
import OBJECTS.Player;
import OBJECTS.Points;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

public class ShouldGameStopCheck extends Thread {
    public static Player player;
    public static File file = new File("RESOURCES\\players.bin");
    JFrame frame;
    JPanel panel;
    static ArrayList<Player> playersList;

    public static boolean end = false;
    JLabel gameOverLabel;
    Font fnt0 = new Font("Agency FB", Font.BOLD, 200);

    public ShouldGameStopCheck(JFrame frame, JPanel panel) {
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

            if (MissedDucks.getValue() > 9) {
                end();
                gameOverLabel.setText("GAME OVER");
                String nick = JOptionPane.showInputDialog(null,
                        "Your nickname: ",
                        "Enter your nickname",
                        JOptionPane.PLAIN_MESSAGE);
                System.out.println(nick);

                player = new Player(nick, Points.getValue(),TimerInGame.timeInGameMinutes, TimerInGame.timeInGameSecounds);
            //    System.out.println(Player.nick + " " + Player.points + " " + Player.timeInGameMinutes + " " + Player.timeInGameSecounds);
              //  System.out.println("Player: " + Player.nick + " added");

                try {
                    writeObjectToFile(player);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                try {
                    readObjectFromFile(playersList);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }

                // playersList.add(player);

               // System.out.println(playersList.get(0));
                frame.dispose();
                HpIncrement.interrupted();
                interrupt();
                break;
            }
        }
    }

    public static void writeObjectToFile(Player obj) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("player.file"));
        Player player = new Player(obj.nick, obj.points, obj.timeInGameMinutes, obj.timeInGameSecounds);
        objectOutputStream.writeObject(player);
    }
    public static void readObjectFromFile(ArrayList<Player> playersList) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(new File("player.file")));
        Player myPlayer = (Player) objectInputStream.readObject();
        System.out.println(myPlayer);
        System.out.println(myPlayer.points);
        System.out.println(myPlayer.timeInGameMinutes);
        System.out.println(myPlayer.timeInGameSecounds);
        playersList.add(new Player(myPlayer.nick,myPlayer.points,myPlayer.timeInGameMinutes,myPlayer.timeInGameSecounds));

    }


    public static ArrayList<Player> getPlayerList(){
        return playersList;
    }

    public boolean end(){
        end = true;
        return end;
    }
}

