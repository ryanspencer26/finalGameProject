import java.awt.*;

public class Bird {

    private int size;
    private Color color;
    private int yVel;
    public final static int x = 250;
    private int y;
    private boolean gameOver;

    public Bird(int y){

        this.y = y;
        size = 15;
        yVel = 5;
        color = Color.ORANGE;
        gameOver = false;

    }

    public boolean isGameOver(){

        return gameOver;

    }

    public void draw(Graphics g){

        g.setColor(color);
        g.fillOval(x,y,size,size);

    }

    public void fall(int height){

        y += yVel;
        yVel++;

        if(y >= height - size || y <= 0){

            gameOver = true;

        }

    }

    public void jump(){

        yVel = -15;
        y += yVel;

        if(y <= 0){

            y = 0;
            gameOver = true;

        }

    }

}