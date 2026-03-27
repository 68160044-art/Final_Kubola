import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Coin {

    private int x;
    private int y;

    private Image coinImage;

    private Random rand = new Random();

    public Coin(){
        coinImage = new ImageIcon(getClass().getResource("/Coin.png")).getImage();
    }

    public void draw(Graphics g){
        g.drawImage(coinImage,x,y,40,40,null);
    }

    public void move(int speed){
        y += speed;
    }

    public void resetPosition(int enemyX){

        do{

            int lane = rand.nextInt(2);

            if(lane==0){
                x = 120;
            }else{
                x = 240;
            }

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
