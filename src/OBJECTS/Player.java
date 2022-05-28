package OBJECTS;

import javax.swing.*;
import java.io.*;

public class Player implements Serializable {
    public static String nick;
    public static int points;
    public static int timeInGameMinutes;
    public static int timeInGameSecounds;
    public Player(String nick, int points, int timeInGameMinutes, int timeInGameSecounds){
        Player.nick = nick;
        Player.points = points;
        Player.timeInGameMinutes = timeInGameMinutes;
        Player.timeInGameSecounds = timeInGameSecounds;

    }

    @Override
    public String toString() {
        return "Nick:" + nick + "\nPoints: " + points + "\nTime: " +timeInGameMinutes + ":" + timeInGameSecounds;
    }

    public static Player readObjectFromFile(File file) throws IOException, ClassNotFoundException {
        Player result = null;
        try (FileInputStream fis = new FileInputStream(file);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            result = (Player) ois.readObject();
        }
        return result;
    }

}
