package GAME;

import javax.swing.*;

public class testFrame extends JFrame {


    public testFrame(){

        setBackGround();

        this.setSize(1940, 1080);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setVisible(true);
    }

    public void setBackGround(){
        ImageIcon icon = new ImageIcon("RESOURCES\\GameBackGround.png",
                "");
        JLabel backGround = new JLabel("", icon, JLabel.CENTER);

        this.add(backGround);
    }
}
