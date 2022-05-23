package OBJECTS;

import javax.swing.*;

public class Cloud extends Obstacle {

    public Cloud(JPanel panel){
        panel.add(this);
        setLocation(0,100);
        setSize(200,200);
    }
    public void loc(JButton button,JPanel panel,int x, int y){
        setBorder(BorderFactory.createEmptyBorder());
        button.setLocation(x,y);
        setSize(170,106);

    }

}
