import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class EnemyCar extends Vehicle {

    private Image enemyImage;
    private Random rand = new Random();

    public EnemyCar(){
        super(100, -120); // เรียก constructor ของ Vehicle
        enemyImage = new ImageIcon(getClass().getResource("/Car2.png")).getImage();
        resetPosition();
    }

    // Override จาก abstract class
    @Override
    public void move(){
        y += speed;
    }

    // Overloading (เพิ่มความเร็วพิเศษ)
    public void move(int extraSpeed){
        y += (speed + extraSpeed);
    }

    @Override
    public void draw(Graphics g){
        g.drawImage(enemyImage, x, y, 80, 120, null);
    }

    // Overloading
    public void resetPosition(){
        int lane = rand.nextInt(2);

        if(lane == 0){
            x = 100;
        }else{
            x = 220;
        }

        y = -120;
    }

    public void resetPosition(int lane){
        if(lane == 0){
            x = 100;
        }else{
            x = 220;
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
        return new Rectangle(x, y, 80, 120);
    }
}
