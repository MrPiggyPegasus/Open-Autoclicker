import lc.kra.system.keyboard.GlobalKeyboardHook;
import lc.kra.system.keyboard.event.GlobalKeyAdapter;
import lc.kra.system.keyboard.event.GlobalKeyEvent;


public class Main {
    public static void main(String[] args) {

        new GUI();


        // Hook for global hotkeys using https://github.com/kristian/system-hook
        GlobalKeyboardHook keyboardHook = new GlobalKeyboardHook(true);
        keyboardHook.addKeyListener(new GlobalKeyAdapter() {
            @Override
            public void keyPressed(GlobalKeyEvent event) {
                if(event.getVirtualKeyCode()==Autoclicker.hotKey) {
                    Autoclicker.toggle();
                }
            }
            @Override
            public void keyReleased(GlobalKeyEvent event) {
            }
        });
    }
}
