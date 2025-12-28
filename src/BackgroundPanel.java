import java.awt.*;
import javax.swing.*;

public class BackgroundPanel extends JPanel {

    private Image bgImage;

    public BackgroundPanel(String imagePath) {
        bgImage = new ImageIcon(getClass().getResource(imagePath)).getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(bgImage, 0, 0, getWidth(), getHeight(), this);
    }
}

