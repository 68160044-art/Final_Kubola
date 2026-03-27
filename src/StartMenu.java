import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StartMenu extends JFrame {

    public StartMenu() {

        setTitle("Car Runner Game");
        setSize(400, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // ใช้ BoxLayout แนวตั้ง
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(Color.BLACK);

        JLabel title = new JLabel("CAR RUNNER GAME");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setBorder(BorderFactory.createEmptyBorder(100,0,50,0)); // เว้นระยะบนและล่าง

        JButton startBtn = new JButton("Start Game");
        startBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        startBtn.setMaximumSize(new Dimension(150, 40));
        startBtn.setFocusable(false);

        JButton exitBtn = new JButton("Exit");
        exitBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        exitBtn.setMaximumSize(new Dimension(150, 40));
        exitBtn.setFocusable(false);

        // ปุ่มเริ่มเกม
        startBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new GameFrame();
                dispose(); // ปิดหน้า menu
            }
        });

        // ปุ่มออก
        exitBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // เพิ่มวัตถุลง panel
        panel.add(title);
        panel.add(startBtn);
        panel.add(Box.createRigidArea(new Dimension(0, 20))); // เว้นช่องว่าง
        panel.add(exitBtn);

        add(panel);
        setVisible(true);
    }

    // ทดสอบเมนู
    public static void main(String[] args) {
        new StartMenu();
    }
}
