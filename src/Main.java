import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Main extends JPanel {

    public static int frameSize = 750;
    public static boolean start = false;

    public static void main(String[] args) {

        JFrame frame = new JFrame("Flappy Ball Java Edition");
        frame.setSize(frameSize, frameSize);
        frame.setLocationRelativeTo(null);

        MyPanel panel = new MyPanel();
        panel.setBackground(Color.CYAN);

        frame.add(panel);
        frame.addKeyListener(new KeyListener() {
            @Override
            public void keyPressed(KeyEvent e) {

                if(e.getKeyCode() == KeyEvent.VK_SPACE){

                        panel.getBird().jump();

                }

            }

            @Override
            public void keyReleased(KeyEvent e) {

                System.out.println("jump");

            }

            @Override
            public void keyTyped(KeyEvent e){

                System.out.println("jump");

            }

        });

        frame.setVisible(true);

    }
}
