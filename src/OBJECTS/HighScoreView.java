package OBJECTS;

import javax.swing.*;
import java.awt.*;

public class HighScoreView extends JPanel {
    public int place = 1;
    public final JLabel score;
    public final Font fnt0 = new Font("Agency FB", Font.BOLD, 45);

    public HighScoreView(){
        score = new JLabel();
        score.setFont(fnt0);
        add(score);
    }

    public void setScore(){

    }

    public void setScore(Player player){
        score.setText("NICK: " + player.nick + "    SCORE: " + player.points + " Time: " + player.timeInGameMinutes + ":" + player.timeInGameSecounds);
        place++;
    }

}
