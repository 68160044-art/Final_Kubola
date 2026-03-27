import javax.swing.JFrame;

public class GameFrame extends JFrame {

    public GameFrame(){

        setTitle("Car Runner Game");
        setSize(400,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        add(new GamePanel());

        setVisible(true);
    }

    public static void main(String[] args){
        new GameFrame();
    }
}
