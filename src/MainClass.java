import java.util.ArrayList;

public class MainClass {

    private static int current = 1;
    private static int previous = 0;
    private static int result;


    public static void main(String[] args) {
        fibanacciCounter(5);
    }


    private static void fibanacciCounter(int incomingNumber) {
        if (incomingNumber != 0) {
            while (current != incomingNumber) {
                if (incomingNumber == 1) {
                    System.out.println("1");
                } else if (incomingNumber == 2) {
                    System.out.println("1");
                } else {
                    result = current + previous;
                    previous = current;
                    current = result;
                    System.out.println(result);
                }
            }
        } else {
            throw new NullPointerException("Please write correct number. The number cannot be 0");
        }
    }
}
