package OBJECTS;

import javax.swing.*;

public class Frog extends Obstacle {

    public Frog(JPanel panel){
      panel.add(this);
      setLocation(0,100);
      setSize(200,200);
    }
    public void loc(JButton button,JPanel panel,int x, int y){
        setBorder(BorderFactory.createEmptyBorder());
        button.setLocation(x,y);
        setSize(130,153);

    }

}
