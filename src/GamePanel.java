import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GamePanel extends JPanel implements ActionListener, KeyListener {

    private PlayerCar player;
    private EnemyCar enemy;
    private Coin coin;

    private Image roadImage;
    private Timer timer;

    private int score = 0;
    private int coinCount = 0;
    private int highScore;

    private int speed = 5;

    public GamePanel(){

        setFocusable(true);
        addKeyListener(this);

        roadImage = new ImageIcon(getClass().getResource("/road.gif")).getImage();

        player = new PlayerCar();
        enemy = new EnemyCar();
        coin = new Coin();

        highScore = HighScore.loadHighScore();
        coin.resetPosition(enemy.getX());

        timer = new Timer(30,this);
        timer.start();
    }

    protected void paintComponent(Graphics g){
        super.paintComponent(g);

        g.drawImage(roadImage,0,0,getWidth(),getHeight(),null);

        coin.draw(g);
        enemy.draw(g);
        player.draw(g);

        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial",Font.BOLD,18));

        g.drawString("Score : "+score,10,20);
        g.drawString("High Score : "+highScore,10,40);
        g.drawString("Coins : "+coinCount,10,60);
    }

    public void actionPerformed(ActionEvent e){

        // ใช้ Overloading ตรงนี้ 🔥
        enemy.move(speed);

        coin.move();

        if(player.getBounds().intersects(enemy.getBounds())){

            if(score > highScore){
                highScore = score;
                HighScore.saveHighScore(highScore);
            }

            timer.stop();

            int choice = JOptionPane.showOptionDialog(
                    this,
                    "Game Over\nScore : "+score,
                    "Game Over",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    new String[]{"Play Again","Exit"},
                    "Play Again"
            );

            if(choice==0){
                restartGame();
            }else{
                System.exit(0);
            }
        }

        if(player.getBounds().intersects(coin.getBounds())){
            score += 5;
            coinCount++;
            coin.resetPosition(enemy.getX());
        }

        if(enemy.getY()>600){
            enemy.resetPosition();
            score++;
            speed++;
        }

        if(coin.getY()>600){
            coin.resetPosition(enemy.getX());
        }

        repaint();
    }

    private void restartGame(){
        score = 0;
        coinCount = 0;
        speed = 5;

        enemy.resetPosition();
        coin.resetPosition(enemy.getX());

        timer.start();
    }

    public void keyPressed(KeyEvent e){

        if(e.getKeyCode()==KeyEvent.VK_LEFT){
            player.moveLeft();
        }

        if(e.getKeyCode()==KeyEvent.VK_RIGHT){
            player.moveRight();
        }
    }

    public void keyReleased(KeyEvent e){}
    public void keyTyped(KeyEvent e){}
}
