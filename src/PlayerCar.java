import javax.swing.*;
import java.awt.*;

public class PlayerCar {

    private int x = 150;
    private int y = 450;

    private Image carImage;

    public PlayerCar(){
        carImage = new ImageIcon(getClass().getResource("/Car.png")).getImage();
    }

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
        return new Rectangle(x,y,80,120);
    }
}
