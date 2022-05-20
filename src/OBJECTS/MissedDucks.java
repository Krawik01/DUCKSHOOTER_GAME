package OBJECTS;

public class MissedDucks {

    private static int value = 0;
    static boolean gameStop = false;

    public static void increment() {
        value ++;
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
    public static boolean getGameStopValue(){
        return gameStop;
    }

    public void setGameStop(boolean gameStop){
        this.gameStop = gameStop;
    }
}
