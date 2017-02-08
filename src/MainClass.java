import java.text.SimpleDateFormat;
import java.util.*;

public class MainClass {

    private static Scanner scanner;
    private static String letter;
    private static String finishWord = "";
    private static boolean wasFirstSpace;
    private static ArrayList<String> newWord;
    private static char[] charArray;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
//        System.out.println(convertSpacesWithArray(scanner.nextLine()));
//        System.out.println(convertSpacesWithList(scanner.nextLine()));
//        checkPalindromWord(scanner.nextLine());
//        stringCutter(scanner.nextLine(), 16);
    }

    //The first version of method where we work with simple array

    private static String convertSpacesWithArray(String incWord) {
        charArray = incWord.toCharArray();
        for (int i = 0; i < incWord.length(); i++) {
            if (charArray[i] == ' ') {
                if (!wasFirstSpace) {
                    finishWord += charArray[i];
                    wasFirstSpace = true;
                }
            } else {
                wasFirstSpace = false;
                finishWord += charArray[i];
            }
        }

        return finishWord;
    }

    //The second version of method where we work with List
    //P.S For correctly functionality you must use only one method (One must be commented, because both methods use the same variables)

//    private static String convertSpacesWithList(String incWord) {
//    newWord = new ArrayList<>();
//        for (int i = 0; i < incWord.length(); i++) {
//            letter = incWord.substring(i, i+1);
//            if (letter.equals(" ")) {
//                if (!wasFirstSpace) {
//                    newWord.add(letter);
//                    wasFirstSpace = true;
//                }
//            } else {
//                wasFirstSpace = false;
//                newWord.add(letter);
//            }
//        }
//
//        for (String s: newWord){
//            finishWord += s;
//        }
//
//        return finishWord;
//    }


    private static void stringCutter(String userWord, int decForCut){
        char[] charArray = userWord.toCharArray();
        String newWord = "";
        boolean wasFoundLastSpace = false;
            for (int i = 0; i < decForCut; i++) {
                if (charArray[decForCut-i]== ' ' && !wasFoundLastSpace) {
                    newWord = userWord.substring(0, decForCut-i);
                    wasFoundLastSpace = true;
                }
        }
        System.out.println(newWord);
    }

    private static void checkPalindromWord(String userWord){
        if(userWord.length()==5) {
            if (userWord.substring(0, 1).equalsIgnoreCase(userWord.substring(4, 5))
                    && userWord.substring(1, 2).equalsIgnoreCase(userWord.substring(3, 4))) {
                System.out.println("Congratulate! You word is palindrome");
            } else System.out.println("Your word is not palindrome");
        } else System.out.println("Your word length != 5. Please try again with correct length");
    }
}

