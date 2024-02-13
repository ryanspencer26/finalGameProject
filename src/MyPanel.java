import javax.swing.*;
import java.awt.*;

public class MyPanel extends JPanel {

    public Bird flappy = new Bird(250);

    public MyPanel() {

        setBackground(Color.CYAN);

    }

    public Bird getBird(){

        return flappy;

    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        flappy.draw(g);
        flappy.fall(getHeight());

        try {
            Thread.sleep(25);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        repaint();

    }

}
