public class AutoSave extends Thread {

    @Override
    public void run() {
        boolean run = true;
        while (run) {
            try {
                Thread.sleep(200);
                GUI.saveDelay();
            } catch (InterruptedException e) {
                run = false;
            }
        }
    }
}
