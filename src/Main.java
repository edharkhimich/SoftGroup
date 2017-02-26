import java.util.Random;

public class Main {

    public static volatile int patientsCounter = 0;
    public static volatile int doctorsCounter = 0;
    private static Random random;
    private static Patient patient;
    private static Doctor doctor;
    private static Room room;
    private static boolean isDoctorWillCome;

    public static void main(String[] args) {
        init();
        crazyPeople();
    }

    private static void init() {
        random = new Random();
        room = new Room();
        doctor = new Doctor();
        patient = new Patient();
    }

    public static Room getRoom() {
        return room;
    }

    private static void crazyPeople() {
        synchronized (room) {
            while (true) {
                if (patientsCounter != 5) {
                    System.out.print("\r" + "Patients counter " + patientsCounter + " | Doctors counter " + doctorsCounter);

                    if (patientsCounter < 0) {
                        patientsCounter = 0;
                    }
                    isDoctorWillCome = random.nextBoolean();
                    goToRoom();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else if (patientsCounter >=5) {
                    for(int i = 0; i < 5; i++) {
                        for (int x = 0; x < 5; x++) {
                            String fight = " FIGHT ";
                            System.out.print(fight);
                        }
                        System.out.println();
                    }
                }
            }
        }
    }

    private static void goToRoom() {
        if (isDoctorWillCome) {
            if (patientsCounter == 0) {
                Doctor doctor = new Doctor();
                doctor.start();
            }
        } else {
            if (doctorsCounter >= 0) {
                Patient patient = new Patient();
                patient.start();
            }
        }
    }
}
