import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {
    GUI() {

        JLabel label = new JLabel();
        label.setText("Autoclicker -");
        label.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 35));
        label.setForeground(Color.LIGHT_GRAY);
        label.setOpaque(false);
        label.setBounds(0,0,370, 50);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.DARK_GRAY);
        panel.add(label);


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.setBackground(Color.BLUE);
        this.add(panel);
        this.setSize(400,90);
        this.setVisible(true);
    }
}
