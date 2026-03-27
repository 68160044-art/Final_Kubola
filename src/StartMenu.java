import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StartMenu extends JFrame {

    public StartMenu(){

        setTitle("Car Runner Game");
        setSize(400,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.BLACK);

        JLabel title = new JLabel("CAR RUNNER GAME");
        title.setBounds(60,100,300,50);
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Arial",Font.BOLD,20));

        JButton startBtn = new JButton("Start Game");
        startBtn.setBounds(120,250,150,40);

        JButton exitBtn = new JButton("Exit");
        exitBtn.setBounds(120,320,150,40);

        // ปุ่มเริ่มเกม
        startBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                new GameFrame();
                dispose(); // ปิดหน้า menu
            }
        });

        // ปุ่มออก
        exitBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        });

        panel.add(title);
        panel.add(startBtn);
        panel.add(exitBtn);

        add(panel);
        setVisible(true);
    }
}
