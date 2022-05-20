package MENU;
import GAME.GameModeFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;



public class Menu extends JFrame {

    String status = "menu";
    JFrame frame = new JFrame("DUCK SHOOTER");
    JPanel panel = new JPanel(){
        public void paint (Graphics g){
          menuStartPaint(g);
      }
    };

    Rectangle r = frame.getBounds();
    int w = r.width;


    JButton newGame = new JButton("NEW GAME");
    JButton highScores = new JButton("HIGH SCORES");
    JButton exit = new JButton("EXIT");


    public Menu() throws IOException {

        this.setLayout(null);


        panel.setBorder(BorderFactory.createEmptyBorder(270, 10, 600, 3));
        Font buttonFont = new Font("Agency FB", Font.BOLD, 40);

        setNewGameButton(buttonFont);
        setHighScoresButton(buttonFont);
        setExitButton(buttonFont);

        frame.add(panel);
        frame.setSize(800,600);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        setBackGround();


    }

    public void setNewGameButton(Font buttonFont){

        panel.add(newGame);
        newGame.setPreferredSize(new Dimension(400,55));
        newGame.setFont(buttonFont);
        newGame.setBackground(Color.yellow);

        newGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(GameModeFrame::new);
            }
        });
    }
    public void setHighScoresButton(Font buttonFont){
        panel.add(highScores);
        highScores.setPreferredSize(new Dimension(400,55));
        highScores.setFont(buttonFont);

        highScores.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(HighScore::new);
            }
        });
    }
    public void setExitButton(Font buttonFont){
        panel.add(exit);
        exit.setPreferredSize(new Dimension(400,55));
        exit.setFont(buttonFont);
    }

    public void setBackGround(){
        ImageIcon icon = new ImageIcon("RESOURCES\\BACKGROUND.jpg",
                "");
        JLabel backGround= new JLabel("", icon, JLabel.CENTER);
        frame.add(backGround);
    }

    public void menuStartPaint(Graphics g){

        Font fnt0 = new Font("Agency FB", Font.BOLD, 50);
        g.setFont(fnt0);
        g.setColor(Color.BLACK);
        g.drawString("DUCK SHOOTER GAME",215,100);

    }


}
//        try {
//            setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("test.jpg")))));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//  setBackground();


//        JButton button1 = new JButton();
//        button1.setBackground(Color.RED);
//
//        button1.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                button1.remove(button1);
//                new JButton();
//
//            }
//        });
//        // elsewhere
//        BufferedImage myImage = ImageIO.read(...);
//        JFrame myJFrame = new JFrame("Image pane");
//        myJFrame.setContentPane(new ImagePanel(myImage));
//

//setSize(800,800);