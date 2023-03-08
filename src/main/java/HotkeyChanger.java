import org.jnativehook.keyboard.NativeKeyEvent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Objects;
public class HotkeyChanger extends JFrame implements WindowListener {
    public static boolean active = false;

    public HotkeyChanger() {
        active = true;
        JLabel label = new JLabel();
        label.setText("Press new hotkey:");
        label.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 25));
        label.setBounds(0, 0, 250, 40);
        label.setForeground(Color.LIGHT_GRAY);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setIconImage(new ImageIcon(Objects.requireNonNull(getClass().getResource("icon.jpg"))).getImage());
        this.setSize(250, 80);
        this.setTitle("Hotkeys");
        this.getContentPane().setBackground(Color.DARK_GRAY);
        this.setVisible(true);
        this.add(label);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(this );
    }

    public void close(int keyCode) {
        active = false;
        String name;
        name = "<HTML>" + NativeKeyEvent.getKeyText(keyCode) + "</HTML>";
        GUI.hotkeyLabel.setText(name);
        GUI.prop.setProperty("hotkey", String.valueOf(keyCode));
        Autoclicker.hotkey = keyCode;
        GUI.hotkeyChanger = null;
        this.dispose();
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        active = false;
        this.dispose();
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}