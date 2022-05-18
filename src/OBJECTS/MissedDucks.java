package OBJECTS;

public class MissedDucks {

    private static int value = 0;

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
}
