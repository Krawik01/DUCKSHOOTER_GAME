package GAME;

import javax.swing.*;
import java.awt.*;

public class ImagePanel extends JPanel {

    private Image image = null;

    public ImagePanel(String filename) {
        this.image = new ImageIcon(filename).getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, image.getWidth(null), image.getHeight(null), null);
    }

}