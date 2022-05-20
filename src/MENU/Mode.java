package MENU;

public interface Mode {

    int mode = 0;

    public default int setMode(int mode){
        return mode;
    }

}
