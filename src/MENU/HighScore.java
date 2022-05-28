package MENU;

import GAME.Game;
import GAME.Threads.GameStop;
import OBJECTS.HighScoreModel;
import OBJECTS.HighScoreView;
import OBJECTS.Player;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.util.Vector;

public class HighScore extends JFrame {

    //private static ArrayList<Player> players = new ArrayList<>();
    HighScoreModel highScoreModel = new HighScoreModel();
    JList<Player> jList = new JList<>();
    JPanel panel = new JPanel(){
//        protected void paintComponent(Graphics g) {
//            super.paintComponent(g);
//            ImageIcon imageIcon = new ImageIcon("RESOURCES\\BACKGROUND.jpg");
//            g.drawImage(imageIcon.getImage(), 0,0,this);
//            g.drawImage(imageIcon.getImage(), 0, 0, this);
//            g.drawImage(imageIcon.getImage(), 0, 0, this);
//            g.drawImage(imageIcon.getImage(), 0, 0, this);
//        }
    };


    public HighScore() {

        generateFrame();

    }

    public void generateFrame() {

        try {
            readObjectFromFile();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }


        System.out.println("Check");

        jList.setModel(highScoreModel);


        //JList jList = new JList(highScoreModel);
        render();

        for (int i = 0; i < highScoreModel.getSize(); i++) {
            System.out.println("players list: " + highScoreModel.getElementAt(i));
        }



        JScrollPane jScrollPane = new JScrollPane(jList);

        //this.getContentPane().add(jScrollPane);


        //this.getContentPane().add(jList);
        panel.add(jScrollPane);

        this.add(panel);
        //this.setPreferredSize(new Dimension(800,800));
        pack();
        this.setResizable(true);
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setVisible(true);
        this.setLocationRelativeTo(null);


    }

    private void render(){
        jList.setCellRenderer(new ListCellRenderer<Player>() {

            final HighScoreView highScoreView = new HighScoreView();

            @Override
            public Component getListCellRendererComponent(JList<? extends Player> list, Player value, int index, boolean isSelected, boolean cellHasFocus) {
                if(value != null){
                    highScoreView.setScore(value);
                }
                return highScoreView;
            }
        });

    }

    public static void readObjectFromFile() throws IOException, ClassNotFoundException {
        File file = new File("PlayersList.txt");

        if(!file.exists()){
            file.createNewFile();
            return;
        }

        FileInputStream fileInputStream = new FileInputStream(file);

        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        Player.playersList = (ArrayList<Player>) objectInputStream.readObject();

        objectInputStream.close();

    }


}
