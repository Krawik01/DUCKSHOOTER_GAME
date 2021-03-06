package GAME;

import GAME.Threads.GameStop;
import GAME.Threads.TimerInGame;
import MENU.Mode;
import OBJECTS.DucksHp;
import OBJECTS.GunLevel;
import OBJECTS.MissedDucks;
import OBJECTS.Points;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class GameModeFrame extends JFrame implements Mode {


    JPanel panel = new JPanel() {
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            ImageIcon imageIcon = new ImageIcon("RESOURCES\\BACKGROUND.jpg");
            g.drawImage(imageIcon.getImage(), 0,0,this);
            g.drawImage(imageIcon.getImage(), 0, 0, this);
            g.drawImage(imageIcon.getImage(), 0, 0, this);
            g.drawImage(imageIcon.getImage(), 0, 0, this);
            GameModeStartPaint(g);
        }
    };

    JFrame frame = new JFrame("DUCK SHOOTER");
    JButton easy = new JButton("Easy");
    JButton medium = new JButton("Medium");
    JButton hard = new JButton("Hard");

    public static int getMode;
    public GameModeFrame() {

        this.setLayout(null);

        panel.setBorder(BorderFactory.createEmptyBorder(270, 10, 600, 3));
        Font buttonFont = new Font("Agency FB", Font.BOLD, 40);
        setEasyButoon(buttonFont,frame);
        setMediumButton(buttonFont,frame);
        setHardButton(buttonFont,frame);

        frame.add(panel);
        frame.setSize(800,600);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void GameModeStartPaint(Graphics g){
        Font fnt0 = new Font("Agency FB", Font.BOLD, 50);
        g.setFont(fnt0);
        g.setColor(Color.BLACK);
        g.drawString("CHOOSE A DIFFICULTY LEVEL",175,150);

    }

    public void setEasyButoon(Font buttonFont, JFrame frame){
        panel.add(easy);
        easy.setPreferredSize(new Dimension(400,55));
        easy.setFont(buttonFont);
        easy.setBackground(Color.yellow);
        easy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(() -> {
                    try {
                        resetGame();
                        GameStop.end=false;
                        new Game(setMode(1));
                        getMode=1;

                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                });
                frame.dispose();
            }
        });

    }
    public void setMediumButton(Font buttonFont, JFrame frame){
        panel.add(medium);
        medium.setPreferredSize(new Dimension(400,55));
        medium.setFont(buttonFont);
        medium.setBackground(Color.yellow);

        medium.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(() -> {
                    try {
                        resetGame();
                        GameStop.end=false;
                        new Game(setMode(2));
                        getMode=2;
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                });
                frame.dispose();
            }
        });

    }
    public void setHardButton(Font buttonFont, JFrame frame){
        panel.add(hard);
        hard.setPreferredSize(new Dimension(400,55));
        hard.setFont(buttonFont);
        hard.setBackground(Color.yellow);
        hard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(() -> {
                    try {
                       resetGame();
                        GameStop.end=false;
                        new Game(setMode(3));
                        getMode=3;
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                });
                frame.dispose();
            }
        });
    }
    public static void resetGame(){
        MissedDucks.reset();
        TimerInGame.timerReset();
        Points.reset();
        DucksHp.ducksHpReset();
        GunLevel.reset();
    }

}
