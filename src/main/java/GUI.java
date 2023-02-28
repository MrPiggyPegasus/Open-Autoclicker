import javax.swing.*;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.text.ParseException;

public class GUI extends JFrame implements ActionListener {
    public static int getDelay() {
        return Integer.parseInt(delayFieldObject.getValue().toString());
    }
    public static JFormattedTextField delayFieldObject;
    public static JPanel hotkeyBox;
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

        JPanel delay = new JPanel();
        delay.setBounds(30 ,40, 60,60);
        delay.setBackground(Color.DARK_GRAY);
        delay.setLayout(null);
        JLabel delayLabel = new JLabel();
        delayLabel.setText("Delay");
        delayLabel.setForeground(Color.LIGHT_GRAY);
        delayLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
        delayLabel.setBounds(0,20,60,15);
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
                if (text.length()==0) {
                    return null;
                }
                return super.stringToValue(text);
            }
        };
        formatter.setValueClass(Integer.class);
        formatter.setAllowsInvalid(false);
        formatter.setCommitsOnValidEdit(true);
        formatter.setMaximum(60000);
        JFormattedTextField delayField = new JFormattedTextField(formatter);
        delayField.setBounds(0,0,60,20);
        delayField.setEditable(true);
        delayField.setValue(10);
        delayFieldObject = delayField;
        delay.add(delayField);

        hotkeyBox = new JPanel();
        hotkeyBox.setBounds(165, 40, 70, 70);
        hotkeyBox.setBackground(Color.DARK_GRAY);
        hotkeyBox.setLayout(new BorderLayout());
        hotkeyBox.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 5, false));
        JLabel hotkey = new JLabel();
        hotkey.setText("F8");
        hotkey.setForeground(Color.LIGHT_GRAY);
        hotkey.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 35));
        hotkeyBox.add(hotkey);
        hotkey.setHorizontalAlignment(JLabel.CENTER);

        this.setTitle("Open Autoclicker");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.DARK_GRAY);
        this.setLayout(null);
        this.setSize(400,190);
        this.add(banner);
        this.add(delay);
        this.add(hotkeyBox);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
