import javax.swing.*;
import java.awt.*;

public class MyPanel extends JPanel {

    Bird flappy = new Bird(250, 250);

    public MyPanel() {

        setBackground(Color.LIGHT_GRAY);

    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        flappy.draw(g);
        flappy.jump(getHeight());

        try {
            Thread.sleep(25);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        repaint();

    }

}
