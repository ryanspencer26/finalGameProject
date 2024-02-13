import java.awt.*;

public class Wall {

    private int x;
    public final static int WIDTH = 50;
    private int y;
    private int height;
    private final Color COLOR = Color.GREEN;
    private int xVel;



    public Wall(int fWidth, int fHeight, int topBottom){

        if(topBottom == 0){
            y = 0;
        } else {
            y = fHeight;
        }
        x = fWidth;
        xVel = -2;
        height = (int)(Math.random() * 200 + 100);

    }

    public int getX(){

        return x;

    }

    public int getY(){

        return y;

    }

    public int getHeight(){

        return height;

    }

    public void draw(Graphics g){

        g.setColor(COLOR);
        g.fillRect(x,y,WIDTH, height);

    }

    public void move(){

        x += xVel;

    }

}