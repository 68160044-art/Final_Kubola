import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class EnemyCar {

    private int x;
    private int y;

    private Image enemyImage;

    private Random rand = new Random();

    public EnemyCar(){

        enemyImage = new ImageIcon(getClass().getResource("/Car2.png")).getImage();
        resetPosition();
    }

    public void draw(Graphics g){
        g.drawImage(enemyImage,x,y,80,120,null);
    }

    public void move(int speed){
        y += speed;
    }

    public void resetPosition(){

        int lane = rand.nextInt(2);

        if(lane==0){
            x=100;
        }else{
            x=220;
        }

        y = -120;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public Rectangle getBounds(){
        return new Rectangle(x,y,80,120);
    }
}
