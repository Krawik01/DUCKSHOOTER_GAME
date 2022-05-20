package GAME.Threads;

import OBJECTS.MissedDucks;

import javax.swing.*;
import java.awt.event.WindowEvent;

public class ShouldGameStopCheck extends Thread{
    JFrame frame;

    public ShouldGameStopCheck(JFrame frame){
        this.frame = frame;
    }

    @Override
    public void run() {

        while (!isInterrupted()) {
            try {
                this.sleep(7);
            } catch (InterruptedException exc) {
                interrupt();

            }
            if(MissedDucks.getValue() >= 10){
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
                        String nick = JOptionPane.showInputDialog(null,
                "Your nickname: ",
                "Enter your nickname",
                JOptionPane.PLAIN_MESSAGE);
                System.out.println(nick);
                frame.dispose();
                //endgame wyniki
            }
        }
    }

}
