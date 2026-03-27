import java.awt.*;

public abstract class Vehicle implements Movable {

    protected int lane;
    protected int y;
    protected int speed;

    public Vehicle(int lane,int speed){

        this.lane = lane;
        this.speed = speed;
        this.y = 0;
    }

    public int getLane(){

        return lane;

    }

    public int getY(){

        return y;

    }

    public void setLane(int lane){

        this.lane = lane;

    }

    public abstract void draw(Graphics g);

}
