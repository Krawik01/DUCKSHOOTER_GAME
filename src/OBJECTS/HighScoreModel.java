package OBJECTS;

import javax.swing.*;

public class HighScoreModel extends AbstractListModel<Player> {


    @Override
    public int getSize() {
        return Player.playersList.size();
    }

    @Override
    public Player getElementAt(int index) {
        return Player.playersList.get(index);
    }
}
