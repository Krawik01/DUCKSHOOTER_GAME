package GAME;

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


    JPanel panel = new JPanel();

    JPanel frontPanel = new JPanel();
    JFrame frameG = new JFrame();
    ImageIcon icon = new ImageIcon("C:\\Users\\SZEF\\Desktop\\DUCKSHOOTER\\out\\production\\DUCKSHOOTER\\RESOURCES\\GameBackGround.jpg");
    int mode;

    public Game(int mode) throws IOException {

//        String nick = JOptionPane.showInputDialog(null,
//                "Your nickname: ",
//                "Enter your nickname",
//                JOptionPane.PLAIN_MESSAGE);
//        players.add(nick);
       // setBackground();

        System.out.println("mode: " + mode);



        panel.setOpaque(true);
        panel.setLayout(null);


        Gun gun = new Gun(panel,1);
        gun.gunButtonDetails(gun,1780,0,157,85);
        Icon gunIcon1 = new ImageIcon("C:\\Users\\SZEF\\Desktop\\DUCKSHOOTER\\src\\RESOURCES\\GunIcon1.png");
        gun.setIcon(gunIcon1);

        gun.setEnabled(false);

        gun.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gun.setIcon(GunLevel.gunSetIcon());
                gun.setEnabled(false);
            }
        });


        DucksComing ducksComing = new DucksComing(panel,gun,mode);
        ducksComing.start();



        Timer timer = new Timer(panel);
        timer.start();


        gun.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GunLevel.increment();
                System.out.println(GunLevel.getValue());
            }
        });
        frameG.add(panel);
        frameG.setSize(1940, 1080);
        frameG.setResizable(false);
        frameG.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameG.setVisible(true);
        setBackground();
    }

    public void setBackground() {
        JLabel backGround= new JLabel("", icon, JLabel.CENTER);
        backGround.setBounds(0,0,1940,1080);
        frontPanel.add(backGround);
    }

    public static void paintScores(Graphics g){

        Font fnt0 = new Font("Agency FB", Font.BOLD, 50);
        g.setFont(fnt0);
        g.setColor(Color.BLACK);
        g.drawString("Score: " + Points.getValue(),215,100);

    }

}

