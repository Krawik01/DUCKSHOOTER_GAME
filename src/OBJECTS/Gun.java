package OBJECTS;

import javax.swing.*;
import java.awt.*;


public class Gun extends JButton {

    JPanel panel;
    public int typeOfGun;

    public Gun(JPanel panel, int typeOfGun) {
        this.panel = panel;
        this.typeOfGun = typeOfGun;
        panel.add(this);
    }

      public void gunButtonDetails(JButton button,int x, int y, int w, int h){
        button.setLocation(x,y);
        button.setSize(w,h);
        button.setBackground(Color.red);
        button.setText("UPGRADE GUN");
    }

}
