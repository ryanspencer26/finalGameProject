import javax.swing.*;
import java.awt.*;

public class MyPanel extends JPanel {

    public Bird flappy = new Bird();
    public Wall[] walls = new Wall[2];

    public boolean newGame = false;

    private final static ImageIcon background = new ImageIcon("Images/flappyBackground2.png");

    public MyPanel() {

        setBackground(new Color(135, 220, 235));
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

        g.drawImage(background.getImage(),0,0,null);

        if(newGame){

            flappy = new Bird();
            newWalls();
            Main.jumps = 0;
            newGame = false;

        }

        flappy.draw(g);
        walls[0].draw(g);
        walls[1].draw(g);

        if(walls[0].getX() <= (-1 * Wall.WIDTH)){

            newWalls();
            flappy.addScore();

        }

        g.setColor(Color.BLACK);
        g.setFont(new Font("SansSerif", Font.PLAIN, 75));
        int textWidth2 = g.getFontMetrics().stringWidth("" + Bird.score);
        g.drawString("" + Bird.score, (375 - textWidth2 / 2), 150);

        if(Main.jumps == 0){

            g.setFont(new Font("SansSerif", Font.PLAIN, 35));
            int textWidth1 = g.getFontMetrics().stringWidth("Press space to jump");
            g.drawString("Press space to jump", (375 - textWidth1 / 2), 300);

        }
        if((walls[0].getX() <= Bird.X + Bird.SIZE) && (walls[0].getX() + Wall.WIDTH >= Bird.X)){
            if((flappy.getY() <= walls[0].getHeight()) || (flappy.getY() + Bird.SIZE >= walls[1].getY())){

                JOptionPane.showMessageDialog(null, "GAME OVER");
                System.exit(0);

            }
        }
        if(flappy.isGameOver()){

            int again = JOptionPane.showConfirmDialog(null, "New game?", "Game Over", JOptionPane.YES_NO_OPTION);

            if(again == JOptionPane.YES_OPTION){

                flappy.gameOver = false;
                newGame = true;
                setFocusable(true);

            } else {

                System.exit(0);

            }

        }
        if(Main.jumps != 0){

            flappy.fall(Main.frameSize);
            walls[0].move();
            walls[1].move();

        }

        try {
            Thread.sleep(15);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        repaint();

        }

}
