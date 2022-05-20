package OBJECTS;

import javax.swing.*;
import java.util.Objects;

public class Duck extends JButton {
    private final String type;
    JButton duck = new JButton();
    String from;
    int x;



    public Duck(String type, JPanel panel,String from, int starty){
        this.type = type;
        panel.add(this);
        if(Objects.equals(from, "right")){
            setLocation(1940, starty);

        } else {
            setLocation(0, starty);

        }


    }
    public void loc(JButton button,JPanel panel,int x, int y,String from){
        setBorder(BorderFactory.createEmptyBorder());
        button.setLocation(x,y);
        setSize(70,70);

    }

}