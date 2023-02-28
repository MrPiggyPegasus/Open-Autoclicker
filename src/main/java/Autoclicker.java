
import org.jnativehook.keyboard.NativeKeyEvent;

import java.awt.*;
import java.awt.event.InputEvent;

public class Autoclicker extends Thread {
    public static boolean active = false;
    public static int hotkey = NativeKeyEvent.VC_F8;
    public static Robot robot;
    public static Autoclicker autoclicker;
    public static void toggle() {
        if (active) {
            autoclicker.interrupt();
            active = false;
        } else {
            autoclicker = new Autoclicker();
            try {
                robot = new Robot();
            } catch (AWTException ignored) {}
            autoclicker.start();
            active = true;
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