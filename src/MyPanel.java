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

            for(int i = 0; i < walls.length; i++){

                walls[i] = new Wall(getWidth(), getHeight(), i);

            }

    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        flappy.draw(g);
        flappy.fall(getHeight());
        walls[0].draw(g);
        walls[1].draw(g);
        walls[0].move();
        walls[1].move();
        if(walls[0].getX() <= (-1 * Wall.WIDTH)){
            newWalls();
        }
        if((walls[0].getX() - 250 >= 0) && (walls[0].getX() - 250 <= Wall.WIDTH)){
            if((flappy.getY() <= walls[0].getHeight()) || (flappy.getY() + flappy.getSize() >= walls[1].getY())){
                JOptionPane.showMessageDialog(null, "GAME OVER");
                System.exit(0);
            }
        }
        if(flappy.isGameOver()){
            JOptionPane.showMessageDialog(null, "GAME OVER");
            System.exit(0);
        }

        try {
            Thread.sleep(15);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        repaint();

    }

}
