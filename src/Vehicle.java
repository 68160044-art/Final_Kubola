import java.awt.*;

public abstract class Vehicle implements Movable {

    protected int x, y, speed;

    public Vehicle(int x, int y) {
        this.x = x;
        this.y = y;
        this.speed = 5;
    }

    // Abstract method
    public abstract void move();

    // Method Overloading
    public void move(int extraSpeed) {
        y += (speed + extraSpeed);
    }

    public abstract void draw(Graphics g);

    public Rectangle getBounds(int w, int h) {
        return new Rectangle(x, y, w, h);
    }
}
