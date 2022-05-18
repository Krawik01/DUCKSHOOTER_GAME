package OBJECTS;

public class DucksHp {
    private static int YellowDuckHp = 1;
    private static int RedDuckHp = 4;
    private static int PurpleDuckHp = 10;
    private static int PinkDuckHp = 20;

    public static void incrementYellowDuckHp(int x) {
        YellowDuckHp = YellowDuckHp + x;
    }
    public static void incrementRedDuckHp(int x) {
        RedDuckHp = RedDuckHp + x;
    }
    public static void incrementPurpleDuckHp(int x) {
        PurpleDuckHp = PurpleDuckHp + x;
    }
    public static void incrementPinkDuckHp(int x) {
        PinkDuckHp = PinkDuckHp + x;
    }

    public static int yellowDuckHpGetValue() {
        return YellowDuckHp;
    }
    public static int redDuckHpGetValue() {
        return RedDuckHp;
    }
    public static int purpleDuckHpGetValue() {
        return PurpleDuckHp;
    }
    public static int pinkDuckHpGetValue() {
        return PinkDuckHp;
    }







}
