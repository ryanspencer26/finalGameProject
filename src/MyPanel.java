import javax.swing.*;
import java.awt.*;

public class MyPanel extends JPanel {

    public Bird flappy = new Bird(250);
    public Wall[] walls = new Wall[2];

    public MyPanel() {

        setBackground(Color.CYAN);
        newWalls();

    }

    public Bird getBird(){

        return flappy;

    }

    public void newWalls(){

            for(int i = 0; i < 2; i++){

                walls[i] = new Wall(Main.frameSize, Main.frameSize, i);

            }

    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        flappy.draw(g);
        walls[0].draw(g);
        walls[1].draw(g);
        g.setColor(Color.BLACK);
        g.drawString("" + Bird.score, 375, 150);

        if(walls[0].getX() <= (-1 * Wall.WIDTH)){

            newWalls();
            flappy.addScore();

        }
        if((walls[0].getX() <= Bird.X + Bird.SIZE) && (walls[0].getX() + Wall.WIDTH >= Bird.X)){
            if((flappy.getY() <= walls[0].getHeight()) || (flappy.getY() + Bird.SIZE >= walls[1].getY())){

                JOptionPane.showMessageDialog(null, "GAME OVER");
                System.exit(0);

            }
        }
        if(flappy.isGameOver()){

            JOptionPane.showMessageDialog(null, "GAME OVER");
            System.exit(0);

        }

        flappy.fall(getHeight());
        walls[0].move();
        walls[1].move();

        try {
            Thread.sleep(15);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        repaint();

        }

}
