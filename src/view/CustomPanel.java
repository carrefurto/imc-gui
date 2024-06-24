package view;

import javax.swing.*;
import java.awt.*;

public class CustomPanel extends JPanel {
    private Image backgroundImage;

    public CustomPanel(String imagemPainel) {
        try {
            backgroundImage = new ImageIcon(getClass().getResource(imagemPainel)).getImage();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        if (backgroundImage != null) {
            graphics.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);

        }
    }
}
