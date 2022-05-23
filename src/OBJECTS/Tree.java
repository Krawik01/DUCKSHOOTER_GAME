package OBJECTS;

import javax.swing.*;

public class Tree extends Obstacle {

    public Tree(JPanel panel){
        panel.add(this);

    }

    public void loc(JButton button, JPanel panel, int x, int y){
        setBorder(BorderFactory.createEmptyBorder());
        button.setLocation(x,y);
        setSize(295,450);
    }
}
