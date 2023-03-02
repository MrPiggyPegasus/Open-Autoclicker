import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {

        new GUI();

        Runtime.getRuntime().addShutdownHook(new Thread(GUI::saveDelay));

        try {
            GlobalScreen.registerNativeHook();
            LogManager.getLogManager().reset();
            Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
            logger.setLevel(Level.OFF);
            GlobalScreen.addNativeKeyListener(new NativeKeyListener()
            {
                @Override
                public void nativeKeyTyped(NativeKeyEvent nativeEvent) {
                }
                @Override
                public void nativeKeyReleased(NativeKeyEvent nativeEvent) {
                }
                @Override
                public void nativeKeyPressed(NativeKeyEvent nativeEvent) {
                    if(nativeEvent.getKeyCode()==Autoclicker.hotkey) {
                        Autoclicker.toggle();
                    }
                }
            });
        }
        catch (NativeHookException e) {
            System.exit(1);
        }
    }
}