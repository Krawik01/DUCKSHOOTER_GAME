package MENU;

public interface Mode {

    int mode = 0;

     default int setMode(int mode){
        return mode;
    }

}
