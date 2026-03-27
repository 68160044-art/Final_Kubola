import javax.swing.*;
import java.awt.*;

public class PlayerCar extends Vehicle {

    private Image carImage;

    public PlayerCar(){
        super(150,450);
        carImage = new ImageIcon(getClass().getResource("/Car.png")).getImage();
    }

    @Override
    public void move(){
        // ไม่ต้องเคลื่อนที่เอง
    }

    @Override
    public void draw(Graphics g){
        g.drawImage(carImage,x,y,80,120,null);
    }

    public void moveLeft(){
        x = 100;
    }

    public void moveRight(){
        x = 220;
    }

    public Rectangle getBounds(){
        return super.getBounds(80,120);
    }
}
