
public class Patient extends Thread {

    @Override
    public void run() {
            Main.patientsCounter++;
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Main.patientsCounter--;
    }
}


