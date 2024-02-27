import java.awt.*;

public class Wall {

    private int x;
    public final static int WIDTH = 125;
    private int y;
    private int height;
    private final Color COLOR = Color.GREEN;
    private int xVel;



    public Wall(int fWidth, int fHeight, int topBottom){

        height = (int)(Math.random() * 125 + 175);
        if(topBottom == 0){
            y = 0;
        } else {
            y = fHeight - height;
        }
        x = fWidth;
        if(Bird.score >= 29){
            xVel = -20;
        } else if(Bird.score >= 24){
            xVel = -18;
        } else if(Bird.score >= 19){
            xVel = -15;
        } else if(Bird.score >= 14){
            xVel = -13;
        } else if(Bird.score >= 9){
            xVel = -10;
        } else if(Bird.score >= 4){
            xVel = -8;
        } else {
            xVel = -5;
        }

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