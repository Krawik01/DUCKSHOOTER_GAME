package GAME;

import GAME.Threads.*;
import OBJECTS.Cloud;
import OBJECTS.Frog;
import OBJECTS.Gun;
import OBJECTS.GunLevel;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Game extends JFrame {


    List players = new ArrayList();
    Timer timer;


    JPanel panel = new JPanel();
    JPanel panel2 = new JPanel();
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


        panel.setBackground(Color.cyan);

        panel.setOpaque(true);
        panel.setLayout(null);
        TimerInGame timerInGame = new TimerInGame(panel);
        timerInGame.start();
        Frog frog = new Frog(panel);
        frog.setIcon(new ImageIcon("RESOURCES\\frog.png"));
        Cloud cloud = new Cloud(panel);
        cloud.setIcon(new ImageIcon("RESOURCES\\cloud.jpg"));

        MoveFrog moveFrog = new MoveFrog(frog, panel, mode, 670);
        MoveCloud moveCloud = new MoveCloud(cloud,panel,mode,410);
        moveFrog.start();
        moveCloud.start();



        Gun gun = new Gun(panel, 1);
        gun.gunButtonDetails(gun, 1780, 0, 157, 85);
        Icon gunIcon1 = new ImageIcon("RESOURCES\\GunIcon1.png");
        gun.setIcon(gunIcon1);

        gun.setEnabled(false);

        gun.addActionListener(e -> {
            GunLevel.increment();
            System.out.println(GunLevel.getValue());
            gun.setIcon(GunLevel.gunSetIcon());
            gun.setEnabled(false);

        });

        DucksComing ducksComing = new DucksComing(panel, gun, mode);
        ducksComing.start();


        HpIncrement hpIncrement = new HpIncrement(panel);
        hpIncrement.start();

        ShouldGameStopCheck shouldGameStopCheck = new ShouldGameStopCheck(frameG,panel);
        shouldGameStopCheck.start();


        Font fnt0 = new Font("Agency FB", Font.BOLD, 50);

        this.add(panel);
       // setBackGround();

        this.setSize(1940, 1030);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(frameG.HIDE_ON_CLOSE);
        this.setVisible(true);


    }

    public void setBackGround(){
        ImageIcon icon = new ImageIcon("RESOURCES\\GameBackGround.png",
                "");
        JLabel backGround = new JLabel("", icon, JLabel.CENTER);

        panel.add(backGround);
        //zeby dzialalo to setLayout nie moze byc null

    }
}


