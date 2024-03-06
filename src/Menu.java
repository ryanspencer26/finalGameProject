import javax.swing.*;
import java.awt.*;

public class Menu extends JPanel{

    public static boolean start;
    public static boolean quit;

    public Menu(){

        setBackground(Color.LIGHT_GRAY);
        start = true;
        quit = false;

    }

    @Override
    public void paintComponent(Graphics g){

        super.paintComponent(g);

        if(start && !quit){

            g.setFont(new Font("SansSerif", Font.PLAIN, 75));
            int textWidth1 = g.getFontMetrics().stringWidth("Flappy Bron");
            g.drawString("Flappy Bron", (375 - textWidth1 / 2), 150);
            g.setFont(new Font("SansSerif", Font.PLAIN, 35));
            g.setColor(Color.YELLOW);
            int textWidth2 = g.getFontMetrics().stringWidth("Start");
            g.drawString("Start", (375 - textWidth2 / 2), 450);
            g.setColor(Color.BLACK);
            int textWidth3 = g.getFontMetrics().stringWidth("Quit");
            g.drawString("Quit", (375 - textWidth3 / 2), 500);

        } else if(!start && quit) {

            g.setFont(new Font("SansSerif", Font.PLAIN, 75));
            int textWidth1 = g.getFontMetrics().stringWidth("Flappy Bron");
            g.drawString("Flappy Bron", (375 - textWidth1 / 2), 150);
            g.setFont(new Font("SansSerif", Font.PLAIN, 35));
            g.setColor(Color.BLACK);
            int textWidth2 = g.getFontMetrics().stringWidth("Start");
            g.drawString("Start", (375 - textWidth2 / 2), 450);
            g.setColor(Color.YELLOW);
            int textWidth3 = g.getFontMetrics().stringWidth("Quit");
            g.drawString("Quit", (375 - textWidth3 / 2), 500);
            g.setColor(Color.BLACK);

        }

        try {
            Thread.sleep(15);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        repaint();

    }

}
