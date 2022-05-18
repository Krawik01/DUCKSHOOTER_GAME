package GAME;

import MENU.Menu;

import javax.swing.*;
import java.io.IOException;

public class Start {
    public static void main(String[] args) throws IOException {

        SwingUtilities.invokeLater(() -> {
            try {
                new Menu();
            } catch (IOException e) {
                e.printStackTrace();
            }

        });





    }
}
