package GAME;

import GAME.Threads.*;
import OBJECTS.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Game extends JFrame {

    JPanel panel = new JPanel() {
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            ImageIcon imageIcon = new ImageIcon("RESOURCES\\GameBackGround.png");
            g.drawImage(imageIcon.getImage(), 0,0,this);
            g.drawImage(imageIcon.getImage(), 0, 0, this);
            g.drawImage(imageIcon.getImage(), 0, 0, this);
            g.drawImage(imageIcon.getImage(), 0, 0, this);
        }
    };

    JFrame frameG = new JFrame();

    public Game(int mode) throws IOException{

//        String nick = JOptionPane.showInputDialog(null,
//                "Your nickname: ",
//                "Enter your nickname",
//                JOptionPane.PLAIN_MESSAGE);
//        players.add(nick);
        // setBackground();


        panel.setBackground(Color.cyan);

        KeyStroke keyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.CTRL_MASK + ActionEvent.SHIFT_MASK);
        panel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(keyStroke, "closeHotkey");
        panel.getActionMap().put("closeHotkey", new AbstractAction() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        ShouldGameStopCheck.end = true;
                        setVisible(false);
                    }
                });


        panel.setOpaque(true);
        panel.setLayout(null);
        TimerInGame timerInGame = new TimerInGame(panel);
        timerInGame.start();
        Frog frog = new Frog(panel);
        frog.setIcon(new ImageIcon("RESOURCES\\frog.png"));
        Cloud cloud = new Cloud(panel);
        cloud.setIcon(new ImageIcon("RESOURCES\\cloud.png"));

        MoveFrog moveFrog = new MoveFrog(frog, panel, mode, 670);
        MoveCloud moveCloud = new MoveCloud(cloud,panel,mode,410);
        moveFrog.start();
        moveCloud.start();

        Tree tree = new Tree(panel);
        tree.loc(tree,panel,1000,565);
        Icon treeIcon = new ImageIcon("RESOURCES\\tree.png");
        tree.setIcon(treeIcon);
        tree.setOpaque(false);
        tree.setContentAreaFilled(false);
        tree.setBorderPainted(false);


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
        this.setResizable(true);
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


