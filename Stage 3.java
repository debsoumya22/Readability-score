package readability;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) throws IOException {
        String str = Files.readString(Path.of(args[0]));
        String[] sentences = str.split("[.!]");
        int total_sentences = sentences.length;
        String[] words = str.split("\\s");
        int total_words = words.length;
        String str1 = str.replaceAll("[\\s\\n\\t]", "");
        int total_chars = str1.length();
        double score = (4.71 * ((double)total_chars/(double)total_words)) + (0.5 * (double)total_words/(double)total_sentences) - 21.43;
        double rounded_score = Math.round(score);
        System.out.println(str);
        System.out.println("Words: " + total_words);
        System.out.println("Sentences: " + total_sentences);
        System.out.println("Characters: " + total_chars);
        System.out.println("The Score is: " + rounded_score);

        switch((int)rounded_score) {
            case 1:
                System.out.println("This text should be understood by 5-6-year-olds");
                break;
            case 2:
                System.out.println("This text should be understood by 6-7-year-olds");
                break;
            case 3:
                System.out.println("This text should be understood by 7-9-year-olds");
                break;
            case 4:
                System.out.println("This text should be understood by 9-10-year-olds");
                break;
            case 5:
                System.out.println("This text should be understood by 10-11-year-olds");
                break;
            case 6:
                System.out.println("This text should be understood by 11-12-year-olds");
                break;
            case 7:
                System.out.println("This text should be understood by 12-13-year-olds");
                break;
            case 8:
                System.out.println("This text should be understood by 13-14-year-olds");
                break;
            case 9:
                System.out.println("This text should be understood by 14-15-year-olds");
                break;
            case 10:
                System.out.println("This text should be understood by 15-16-year-olds");
                break;
            case 11:
                System.out.println("This text should be understood by 17-18-year-olds");
                break;
            case 13:
                System.out.println("This text should be understood by 18-24-year-olds");
                break;
        }

    }
}
