import javax.swing.*;
import java.awt.*;

public class Bird {

    public final static int SIZE = 50;
    private int yVel;
    public final static int X = 250;
    public final static ImageIcon pic = new ImageIcon("Images/kingJamesCropped.png");
    private int y;
    private boolean gameOver;

    public static int score;

    public Bird(int y){

        this.y = y;
        yVel = 5;
        gameOver = false;
        score = 0;

    }

    public boolean isGameOver(){

        return gameOver;

    }

    public void addScore(){

        score += 1;

    }

    public int getY(){

        return y;

    }

    public void draw(Graphics g){

        g.drawImage(pic.getImage(),X,y,SIZE, SIZE, null);

    }

    public void fall(int height){

        y += yVel;
        yVel++;

        if(y >= height - SIZE || y <= 0){

            gameOver = true;

        }

    }

    public void jump(){

        yVel = -13;
        y += yVel;

        if(y <= 0){

            y = 0;
            gameOver = true;

        }

    }

}