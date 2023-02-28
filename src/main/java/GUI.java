import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame implements ActionListener {
    GUI() {
        JPanel banner = new JPanel();
        banner.setBounds(0,0,400,30);
        banner.setLayout(new BorderLayout());
        banner.setBackground(Color.DARK_GRAY);
        JLabel title = new JLabel();
        title.setText("Open Autoclicker");
        title.setForeground(Color.LIGHT_GRAY);
        title.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
        banner.add(title);
        title.setHorizontalAlignment(JLabel.CENTER);


        JPanel cps = new JPanel();
        cps.setBounds(30 ,40, 60,60);
        cps.setBackground(Color.LIGHT_GRAY);
        cps.setLayout(new BorderLayout());
        JTextField cpsField = new JTextField();
        cpsField.setPreferredSize(new Dimension(60,30));
        cpsField.setEditable(true);
        cps.add(cpsField);
        cpsField.setHorizontalAlignment(JTextField.CENTER);


        JPanel hotkeyBox = new JPanel();
        hotkeyBox.setBounds(165, 40, 70, 70);
        hotkeyBox.setBackground(Color.DARK_GRAY);
        hotkeyBox.setLayout(new BorderLayout());
        hotkeyBox.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 3, false));
        JLabel hotkey = new JLabel();
        hotkey.setText("F8");
        hotkey.setForeground(Color.LIGHT_GRAY);
        hotkey.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 35));
        hotkeyBox.add(hotkey);
        hotkey.setHorizontalAlignment(JLabel.CENTER);


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.DARK_GRAY);
        this.setLayout(null);
        this.setSize(400,190);
        this.add(banner);
        this.add(cps);
        this.add(hotkeyBox);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
