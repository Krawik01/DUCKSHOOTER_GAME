package MENU;

import GAME.Threads.ShouldGameStopCheck;
import OBJECTS.Player;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class HighScore extends JFrame {


    JFrame frameG = new JFrame();

    public HighScore(){



       // System.out.println(ShouldGameStopCheck.getPlayerList());
        frameG.setSize(800, 800);
        frameG.setResizable(false);
        frameG.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frameG.setVisible(true);


    }

}
