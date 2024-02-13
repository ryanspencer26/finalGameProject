import java.awt.*;

public class Bird {

    private int size;
    private Color color;
    private int yVel;
    public final static int x = 250;
    private int y;

    private boolean game;

    public Bird(int y){

        this.y = y;
        size = 15;
        yVel = 5;
        color = Color.ORANGE;
        game = true;

    }

    public void setSize(int size){

        this.size = size;

    }

    public void setColor(Color color){

        this.color = color;

    }

    public void draw(Graphics g){

        g.setColor(color);
        g.fillOval(x,y,size,size);

    }

    public void fall(int height){

        yVel = 5;
        y += yVel;

        if(y >= height){

            yVel = 0;
            game = false;

        }

    }

    public void jump(){

        yVel = -20;
        y += yVel;

        if(y <= 0){

            yVel = 0;
            game = false;

        }

    }

}