import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Main extends JPanel {

    public static int frameSize = 750;

    public static boolean game = false;

    public static int jumps = 0;

    public static void main(String[] args) {

        JFrame gameFrame = new JFrame("Flappy Bron Java Edition");
        gameFrame.setSize(frameSize, frameSize);
        gameFrame.setLocationRelativeTo(null);
        gameFrame.setResizable(false);

        MyPanel panel = new MyPanel();
        gameFrame.add(panel);

        JFrame menuFrame = new JFrame("Flappy Bron Java Edition");
        menuFrame.setSize(frameSize, frameSize);
        menuFrame.setLocationRelativeTo(null);
        menuFrame.setResizable(false);

        Menu menu = new Menu();
        menuFrame.add(menu);
        menuFrame.setVisible(true);

        menuFrame.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

                if(e.getKeyCode() == KeyEvent.VK_DOWN){

                    Menu.quit = true;
                    Menu.start = false;
                    System.out.println("down");

                }

                if(e.getKeyCode() == KeyEvent.VK_UP){

                    Menu.start = true;
                    Menu.quit = false;
                    System.out.println("up");

                }

                if(e.getKeyCode() == KeyEvent.VK_ENTER){

                    if(Menu.start){

                        menuFrame.setVisible(false);
                        game = true;
                        gameFrame.setVisible(true);

                    } else if(Menu.quit){

                        System.exit(0);

                    }

                    System.out.println("enter");

                }

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        gameFrame.addKeyListener(new KeyListener() {
            @Override
            public void keyPressed(KeyEvent e) {

                    if(e.getKeyCode() == KeyEvent.VK_SPACE){

                        System.out.println("space");
                        panel.getBird().jump();
                        jumps++;

                    }

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }

            @Override
            public void keyTyped(KeyEvent e){

            }

        });

    }
}
