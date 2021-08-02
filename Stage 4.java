package readability;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        String str = Files.readString(Path.of(args[0]));
        calculateAndDisplayScores(str);
    }

        public static void calculateAndDisplayScores(String str) {
            String[] sentences = str.split("[.!]");
            int total_sentences = sentences.length;
            String[] words = str.split("\\s");
            int total_words = words.length;
            String str1 = str.replaceAll("[\\s\\n\\t]", "");
            int total_chars = str1.length();
            int total_syllables = 0;
            int total_polysyllables = 0;


            //calculate vowels, syllable and polysyllables
            for (int j = 0; j < total_words; j++) {
                int vowels = 0;
                ArrayList<Integer> index = new ArrayList<Integer>();
                //calculate vowels and keep adding vowels indexes to an ArrayList
                for (int x = 0; x < words[j].length(); x++) {
                    if (x != (words[j].length() - 1) && (words[j].charAt(x) == 'a' || words[j].charAt(x) == 'e' || words[j].charAt(x) == 'i' || words[j].charAt(x) == 'o' || words[j].charAt(x) == 'u' || words[j].charAt(x) == 'y')) {
                        vowels += 1;
                        index.add(x);
                    }
                    //don't count 'e' at the end of the word as vowel
                    else if (x == (words[j].length() - 1) && (words[j].charAt(x) == 'a' || words[j].charAt(x) == 'i' || words[j].charAt(x) == 'o' || words[j].charAt(x) == 'u' || words[j].charAt(x) == 'y')) {
                        vowels += 1;
                        index.add(x);
                    }
                }
                //calculate syllable in particular word
                if (index.isEmpty()) {
                    total_syllables += 1;
                } else {
                    int adjacentVowelCount = 0;
                    for (int i = 0; i < index.size() - 1; i++) {
                        if (index.get(i) + 1 == index.get(i + 1)) {
                            adjacentVowelCount += 1;
                        }
                    }
                    int syllables = index.size() - adjacentVowelCount;
                    total_syllables += syllables;

                    if (syllables > 2) {
                        //polysyllables which is the number of words with more than 2 syllables
                        total_polysyllables += 1;
                    }
                }
            }

            double avg_chars = (total_chars / total_words) * 100;
            double avg_sentences = (total_sentences / total_words) * 100;
            double fk = (0.39 * ((double) total_words / (double) total_sentences)) + (11.8 * (double) total_syllables / (double) total_words) - 15.59;
            double smog = (1.043 * Math.sqrt(total_polysyllables * 30 / total_sentences) + 3.1291);
            double cli = 0.0588 * avg_chars - 0.296 * avg_sentences - 15.8;
            double ari = (4.71 * ((double) total_chars / (double) total_words)) + (0.5 * (double) total_words / (double) total_sentences) - 21.43;

            System.out.println(str);
            System.out.println("Words: " + total_words);
            System.out.println("Sentences: " + total_sentences);
            System.out.println("Characters: " + total_chars);
            System.out.println("Syllables: " + total_syllables);
            System.out.println("polysyllables: " + total_polysyllables);

            user_input(ari, fk, smog, cli);
        }

        public static void user_input(double ari, double fk, double smog, double cli) {
        Scanner scanner = new Scanner(System.in);
        double rounded_score = 0.0;
        System.out.println("Enter the score you want to calculate (ARI, FK, SMOG, CL, all)");
        String input = scanner.next();
        switch (input) {
            case "ARI":
                System.out.print("Automated Readability Index: " + ari);
                rounded_score = Math.round(ari);
                switch_call(rounded_score);
                break;
            case "FK":
                System.out.print("Flesch–Kincaid readability tests: " + fk);
                rounded_score = Math.round(fk);
                switch_call(rounded_score);
                break;
            case "SMOG":
                System.out.print("Simple Measure of Gobbledygook: " + smog);
                rounded_score = Math.round(smog);
                switch_call(rounded_score);
                break;
            case "CL":
                System.out.print("Simple Measure of Gobbledygook: " + cli);
                rounded_score = Math.round(cli);
                switch_call(rounded_score);
                break;
            case "all":
                System.out.print("Automated Readability Index: " + ari);
                rounded_score = Math.round(ari);
                switch_call(rounded_score);
                System.out.print("Flesch–Kincaid readability tests: " + fk);
                rounded_score = Math.round(fk);
                switch_call(rounded_score);
                System.out.print("Simple Measure of Gobbledygook: " + smog);
                rounded_score = Math.round(smog);
                switch_call(rounded_score);
                System.out.print("Coleman–Liau index: " + cli);
                rounded_score = Math.round(cli);
                switch_call(rounded_score);
                break;
        }
    }

        public static void switch_call(double rounded_score) {
            switch ((int) rounded_score) {
                case 1:
                    System.out.println("(about 6-year-olds)");
                    break;
                case 2:
                    System.out.println("(about 7-year-olds");
                    break;
                case 3:
                    System.out.println("(about 9-year-olds)");
                    break;
                case 4:
                    System.out.println("(about 10-year-olds)");
                    break;
                case 5:
                    System.out.println("(about 11-year-olds)");
                    break;
                case 6:
                    System.out.println("(about 12-year-olds)");
                    break;
                case 7:
                    System.out.println("(about 13-year-olds)");
                    break;
                case 8:
                    System.out.println("(about 14-year-olds)");
                    break;
                case 9:
                    System.out.println("(about 15-year-olds)");
                    break;
                case 10:
                    System.out.println("(about 16-year-olds)");
                    break;
                case 11:
                    System.out.println("(about 17-year-olds)");
                    break;
                case 12:
                    System.out.println("(about 18-year-olds)");
                    break;
                case 13:
                    System.out.println("(about 24-year-olds)");
                    break;
                case 14:
                    System.out.println("(about 24+ year-olds)");
                    break;
            }
        }
}
