package readability;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String str = new Scanner(System.in).nextLine();

        int numOfWords = str.split(" ").length;
        int numOfSentence = str.split("[.?!]").length;

        System.out.println((float)numOfWords / numOfSentence > 10 ? "HARD" : "EASY");
    }
}
