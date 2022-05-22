package OBJECTS;

import javax.swing.*;

public class Player {
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


}
