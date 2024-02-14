import java.awt.*;

public class Bird {

    public final static int SIZE = 15;
    private Color color;
    private int yVel;
    public final static int X = 250;
    private int y;
    private boolean gameOver;

    public static int score;

    public Bird(int y){

        this.y = y;
        color = Color.ORANGE;
        yVel = 5;
        gameOver = false;
        score = 0;

    }

    public boolean isGameOver(){

        return gameOver;

    }

    public void addScore(){

        score += 10;

    }

    public int getY(){

        return y;

    }

    public void draw(Graphics g){

        g.setColor(color);
        g.fillOval(X,y,SIZE,SIZE);

    }

    public void fall(int height){

        y += yVel;
        yVel++;

        if(y >= height - SIZE || y <= 0){

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