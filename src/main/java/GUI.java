import org.jnativehook.keyboard.NativeKeyEvent;

import javax.swing.*;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Objects;
import java.util.Properties;

public class GUI extends JFrame {
    public static int getDelay() {
        return Integer.parseInt(delayFieldObject.getValue().toString());
    }
    public static JFormattedTextField delayFieldObject;
    public static JPanel hotkeyBox;
    public static JLabel hotkeyLabel = new JLabel();
    public static JButton hotkeyButton;
    public static HotkeyChanger hotkeyChanger;
    public static int defaultDelay;
    public static Properties prop;
    public static File file;
    public static void saveDelay() {
        try {
            prop.setProperty("delay", delayFieldObject.getValue().toString());
            FileOutputStream fos = new FileOutputStream(file);
            prop.store(fos, null);
        } catch (Exception e) {
            System.exit(1);
        }
    }
    GUI() {
        try {
            FileInputStream fis = new FileInputStream("config.properties");
            prop = new Properties();
            prop.load(fis);
        } catch (IOException e) {
            // config.properties not found
            e.printStackTrace();
            System.exit(1);
        }
        file = new File("config.properties");
        defaultDelay = Integer.parseInt(prop.getProperty("delay"));
        Autoclicker.hotkey = Integer.parseInt(prop.getProperty("hotkey"));
        ImageIcon icon = new ImageIcon(Objects.requireNonNull(getClass().getResource("icon.jpg")));

        JPanel banner = new JPanel();
        banner.setBounds(0, 0, 400, 30);
        banner.setLayout(new BorderLayout());
        banner.setBackground(Color.DARK_GRAY);
        JLabel title = new JLabel();
        title.setText("Open Autoclicker");
        title.setForeground(Color.LIGHT_GRAY);
        title.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
        banner.add(title);
        title.setHorizontalAlignment(JLabel.CENTER);

        JPanel delay = new JPanel();
        delay.setBounds(30, 40, 60, 60);
        delay.setBackground(Color.DARK_GRAY);
        delay.setLayout(null);
        JLabel delayLabel = new JLabel();
        delayLabel.setText("Delay");
        delayLabel.setForeground(Color.LIGHT_GRAY);
        delayLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
        delayLabel.setBounds(0, 20, 60, 15);
        delay.add(delayLabel);
        JLabel delayMsLabel = new JLabel();
        delayMsLabel.setText("(ms)");
        delayMsLabel.setForeground(Color.LIGHT_GRAY);
        delayMsLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
        delayMsLabel.setBounds(0, 40, 50, 15);
        delay.add(delayMsLabel);
        NumberFormat format = NumberFormat.getInstance();
        NumberFormatter formatter = new NumberFormatter(format) {
            @Override
            public Object stringToValue(String text) throws ParseException {
                if (text.length() == 0) {
                    return null;
                }
                return super.stringToValue(text);
            }
        };
        formatter.setValueClass(Integer.class);
        formatter.setAllowsInvalid(false);
        formatter.setCommitsOnValidEdit(true);
        formatter.setMinimum(0);
        formatter.setMaximum(60000);
        JFormattedTextField delayField = new JFormattedTextField(formatter);
        delayField.setBounds(0, 0, 60, 20);
        delayField.setEditable(true);
        delayField.setValue(defaultDelay);
        delayFieldObject = delayField;
        delay.add(delayField);

        hotkeyButton = new JButton();
        hotkeyButton.setLayout(null);
        hotkeyButton.setBounds(305,40,60,30);
        hotkeyButton.setBackground(Color.LIGHT_GRAY);
        JLabel hotkeyButtonLabel = new JLabel();
        hotkeyButtonLabel.setBounds(2,0,58,30);
        hotkeyButtonLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 10));
        hotkeyButtonLabel.setText("Edit Hotkey");
        hotkeyButtonLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 10));
        hotkeyButton.add(hotkeyButtonLabel);
        hotkeyButton.setFocusable(false);
        hotkeyButton.addActionListener(GUI::hotkeyButtonListener);

        hotkeyBox = new JPanel();
        hotkeyBox.setBounds(165, 40, 70, 70);
        hotkeyBox.setBackground(Color.DARK_GRAY);
        hotkeyBox.setLayout(new BorderLayout());
        hotkeyBox.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 5, false));
        String hotkeyText = "<HTML>"+NativeKeyEvent.getKeyText(Integer.parseInt(prop.getProperty("hotkey")))+"</HTML>";
        Autoclicker.hotkey = Integer.parseInt(prop.getProperty("hotkey"));
        hotkeyLabel.setText(hotkeyText);
        hotkeyLabel.setForeground(Color.LIGHT_GRAY);
        hotkeyLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
        hotkeyBox.add(hotkeyLabel);
        hotkeyLabel.setHorizontalAlignment(JLabel.CENTER);

        this.setLocationRelativeTo(null);
        this.setIconImage(icon.getImage());
        this.setTitle("Open Autoclicker");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.DARK_GRAY);
        this.setLayout(null);
        this.setResizable(false);
        this.setSize(400, 190);
        this.add(banner);
        this.add(delay);
        this.add(hotkeyBox);
        this.add(hotkeyButton);
        this.setVisible(true);
    }
    public static void hotkeyButtonListener(AWTEvent e) {
        if(!HotkeyChanger.active && !Autoclicker.active) {
            hotkeyChanger = new HotkeyChanger();
        }
    }
}
