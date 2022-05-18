package GAME;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class GameModeFrame extends JFrame implements Mode {

    JPanel panel = new JPanel(){
        public void paint (Graphics g){
            GameModeStartPaint(g);
        }
    };
    JFrame frame = new JFrame("DUCK SHOOTER");

    JButton easy = new JButton("Easy");
    JButton medium = new JButton("Medium");
    JButton hard = new JButton("Hard");
    public GameModeFrame() {

        this.setLayout(null);

        panel.setBorder(BorderFactory.createEmptyBorder(270, 10, 600, 3));
        Font buttonFont = new Font("Agency FB", Font.BOLD, 40);
        setEasyButoon(buttonFont);
        setMediumButton(buttonFont);
        setHardButton(buttonFont);

        frame.add(panel);
        frame.setSize(800,600);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void GameModeStartPaint(Graphics g){
        Font fnt0 = new Font("Agency FB", Font.BOLD, 50);
        g.setFont(fnt0);
        g.setColor(Color.BLACK);
        g.drawString("CHOOSE A DIFFICULTY LEVEL",175,150);

    }

    public void setEasyButoon(Font buttonFont){
        panel.add(easy);
        easy.setPreferredSize(new Dimension(400,55));
        easy.setFont(buttonFont);
        easy.setBackground(Color.yellow);
        easy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(() -> {
                    try {
                        new Game(setMode(1));
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                });
            }
        });

    }
    public void setMediumButton(Font buttonFont){
        panel.add(medium);
        medium.setPreferredSize(new Dimension(400,55));
        medium.setFont(buttonFont);
        medium.setBackground(Color.yellow);

        medium.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(() -> {
                    try {
                        new Game(setMode(2));
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                });
            }
        });

    }
    public void setHardButton(Font buttonFont){
        panel.add(hard);
        hard.setPreferredSize(new Dimension(400,55));
        hard.setFont(buttonFont);
        hard.setBackground(Color.yellow);
        hard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(() -> {
                    try {
                        new Game(setMode(3));
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                });
            }
        });
    }

}
