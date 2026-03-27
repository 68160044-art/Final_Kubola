import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Coin {

    private int x, y;
    private Image coinImage;
    private Random rand = new Random();

    public Coin(){
        coinImage = new ImageIcon(getClass().getResource("/Coin.png")).getImage();
    }

    public void draw(Graphics g){
        g.drawImage(coinImage,x,y,40,40,null);
    }

    public void move(){
        y += 5;
    }

    public void resetPosition(int enemyX){

        do{
            int lane = rand.nextInt(2);
            x = (lane==0)?120:240;
        }while(x == enemyX);

        y = -50;
    }

    public int getY(){
        return y;
    }

    public Rectangle getBounds(){
        return new Rectangle(x,y,40,40);
    }
}
