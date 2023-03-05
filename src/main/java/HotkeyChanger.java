import javax.swing.*;
import java.awt.*;
import java.util.Objects;
public class HotkeyChanger extends JFrame {
    public static boolean active = false;
    public HotkeyChanger() {
        if (active) {
            this.dispose();
        }
        active = true;
        JLabel label = new JLabel();
        label.setText("Press new hotkey:");
        label.setFont( new Font(Font.SANS_SERIF, Font.BOLD, 25));
        label.setBounds(0,0,250,40);
        label.setForeground(Color.LIGHT_GRAY);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setIconImage(new ImageIcon(Objects.requireNonNull(getClass().getResource("icon.jpg"))).getImage());
        this.setSize(250, 80);
        this.setTitle("Hotkeys");
        this.getContentPane().setBackground(Color.DARK_GRAY);
        this.setVisible(true);
        this.add(label);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    public void close(int keyCode) {
        active = false;
        GUI.hotkeyLabel.setText(String.valueOf(keyCode));
        GUI.prop.setProperty("hotkey", String.valueOf(keyCode));
        Autoclicker.hotkey = keyCode;
        GUI.hotkeyChanger = null;
        this.dispose();
    }
}