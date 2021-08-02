package readability;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String words = sc.nextLine();
        String[] splitWords=words.split("");
        if(splitWords.length>100)
            System.out.println("HARD");
        else
            System.out.println("EASY");
    }
}
