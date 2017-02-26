
public class Doctor extends Thread {

    @Override
    public void run() {
        if (Main.doctorsCounter >= 0) {
            Main.doctorsCounter++;
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Main.doctorsCounter--;
        } else System.out.println("In the room can't be more than one doctor");
    }
}
