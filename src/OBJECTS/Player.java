package OBJECTS;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Vector;

public class Player implements Serializable {

    private static final long serialVersionUID = 1L;

    public static ArrayList<Player> playersList = new ArrayList<>();

    public String nick;
    public int points;
    public int timeInGameMinutes;
    public int timeInGameSecounds;

    public Player(String nick, int points, int timeInGameMinutes, int timeInGameSecounds) {
        this.nick = nick;
        this.points = points;
        this.timeInGameMinutes = timeInGameMinutes;
        this.timeInGameSecounds = timeInGameSecounds;

    }

    public Integer getPoints(){
        return points;
    }

    @Override
    public String toString() {
        return "Player{" +
                "nick='" + nick + '\'' +
                ", points=" + points +
                ", timeInGameMinutes=" + timeInGameMinutes +
                ", timeInGameSecounds=" + timeInGameSecounds +
                '}';
    }



//    public String toString() {
//        return new StringBuffer(" Nick: ").append(this.nick).append("Points: ").append(this.points)
//                .append("Minutes: ").append(this.timeInGameMinutes).append(" Seconds : ").append(this.timeInGameSecounds).toString();
//    }

}




