package GAME.Threads;

import OBJECTS.DucksHp;
import OBJECTS.MissedDucks;
import OBJECTS.Player;
import OBJECTS.Points;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;

public class ShouldGameStopCheck extends Thread {
    JFrame frame;
    JPanel panel;
    JList<Player> playerJList;

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
                //gameOverLabel.setVisible(true);
                gameOverLabel.setText("GAME OVER");
                //frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
                String nick = JOptionPane.showInputDialog(null,
                        "Your nickname: ",
                        "Enter your nickname",
                        JOptionPane.PLAIN_MESSAGE);
                System.out.println(nick);
                Player player = new Player(nick, Points.getValue(),TimerInGame.timeInGameMinutes, TimerInGame.timeInGameSecounds);

             //   playerJList.add(player);
                frame.dispose();
            //    Points.reset();
                HpIncrement.interrupted();
//                DucksHp.ducksHpReset();
//                MissedDucks.reset();
//                TimerInGame.timeInGameSecounds = 0;
//                TimerInGame.timeInGameMinutes = 0;

                interrupt();

                break;


            }
        }
    }

    public boolean end(){
        end = true;
        return end;
    }
}

