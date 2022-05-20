package GAME;

import GAME.Threads.DucksComing;
import GAME.Threads.HpIncrement;
import GAME.Threads.ShouldGameStopCheck;
import GAME.Threads.TimerInGame;
import OBJECTS.Gun;
import OBJECTS.GunLevel;
import OBJECTS.Points;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Game extends JFrame {


    List players = new ArrayList();
    Timer timer;


    JPanel panel = new JPanel();
//    JPanel panel2 = new JPanel(){
//        public void paint (Graphics g){
//            menuStartPaint(g);
//        }
//    };
    JFrame frameG = new JFrame();
    JLabel label;

    int secound;

    public Game(int mode) throws IOException {

//        String nick = JOptionPane.showInputDialog(null,
//                "Your nickname: ",
//                "Enter your nickname",
//                JOptionPane.PLAIN_MESSAGE);
//        players.add(nick);
        // setBackground();


        //panel.setBackground(Color.BLUE);

        panel.setOpaque(true);
        panel.setLayout(null);
        TimerInGame timerInGame = new TimerInGame(panel);
        timerInGame.start();


        Gun gun = new Gun(panel, 1);
        gun.gunButtonDetails(gun, 1780, 0, 157, 85);
        Icon gunIcon1 = new ImageIcon("RESOURCES\\GunIcon1.png");
        gun.setIcon(gunIcon1);

        gun.setEnabled(false);
        gun.addActionListener(e -> {
            gun.setIcon(GunLevel.gunSetIcon());
            gun.setEnabled(false);
        });




        DucksComing ducksComing = new DucksComing(panel, gun, mode);
        ducksComing.start();

        HpIncrement hpIncrement = new HpIncrement(panel);
        hpIncrement.start();

        ShouldGameStopCheck shouldGameStopCheck = new ShouldGameStopCheck(frameG);
        shouldGameStopCheck.start();

        gun.addActionListener(e -> {
            GunLevel.increment();
            System.out.println(GunLevel.getValue());
        });
        Font fnt0 = new Font("Agency FB", Font.BOLD, 50);
        setBackGround();
        this.add(panel);

        this.setSize(1940, 1080);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setVisible(true);

    }

    public void setBackGround(){
        ImageIcon icon = new ImageIcon("RESOURCES\\GameBackGround.png",
                "");
        JLabel backGround = new JLabel("", icon, JLabel.CENTER);

        panel.add(backGround);
    }
}


