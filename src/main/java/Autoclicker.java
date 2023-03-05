
import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;

public class Autoclicker extends Thread {
    public static boolean active = false;
    public static int hotkey;
    public static Robot robot;
    public static Autoclicker autoclicker;
    public static void toggle() {
        if (active) {
            autoclicker.interrupt();
            active = false;
            GUI.hotkeyBox.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 5, false));
            GUI.delayFieldObject.setEditable(true);
        } else {
            GUI.delayFieldObject.setEditable(false);
            autoclicker = new Autoclicker();
            try {
                robot = new Robot();
            } catch (AWTException ignored) {}
            autoclicker.start();
            active = true;
            GUI.hotkeyBox.setBorder(BorderFactory.createLineBorder(Color.GREEN, 5, false));
        }
    }
    @Override
    public void run() {
        boolean rep = true;
        while (rep) {
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
            try {
                Thread.sleep(Math.max(GUI.getDelay(), 10));
            } catch (InterruptedException e) {
                rep = false;
            }
        }
    }
}