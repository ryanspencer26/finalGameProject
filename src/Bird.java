import java.awt.*;

public class Bird {

    private int size;
    private Color color;
    private int ySpeed;
    private int x;
    private int y;

    private boolean game;

    public Bird(int x, int y){

        this.x = x;
        this.y = y;
        size = 15;
        ySpeed = 5;
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

    public void jump(int height){

        y += ySpeed;

        if(y >= height - size || y<= 0){

            ySpeed = 0;
            game = false;

        }

    }

}