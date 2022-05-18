package OBJECTS;

import javax.swing.*;

public class Points {

    private static int value = 0;

    public static void increment(int x) {
        value = value + x;
    }

    void reset() {
        value = 0;
    }

    public static int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public static void setScoresCounter(JLabel label,JPanel panel,int scores){
            label = new JLabel(""  + scores);
            label.setLocation(120, 100);
            label.setSize(200, 200);
            panel.add(label);
    }



}
