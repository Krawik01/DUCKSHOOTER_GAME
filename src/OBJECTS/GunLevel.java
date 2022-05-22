package OBJECTS;

import javax.swing.*;

public class GunLevel {

    private static int value = 1;
    static Icon gunIcon2 = new ImageIcon("\\RESOURCES\\GunIcon2.png");

    public static void increment() {
        value++;
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

    public static void checkPoints(Gun gun) {

        //gun level for stage 2
        if ((value == 1) && (Points.getValue() > 80)) {
            gun.setEnabled(true);
        }
        //gun level for stage 3
        if ((value == 2) && (Points.getValue() > 160)) {
            gun.setEnabled(true);
        }
        if((value == 3)&&(Points.getValue()> 250)){
            gun.setEnabled(true);
        }
        if((value == 4)&&(Points.getValue()> 450)){
            gun.setEnabled(true);
        }

    }

    public static Icon gunSetIcon() {
        Icon gunIcon2 = new ImageIcon("RESOURCES\\GunIcon2.png");
        if (value == 2) {
            return gunIcon2;
        }
        if (value == 3) {
            return gunIcon2;
        }
        else {
            return null;
        }
    }
}
