package Project;
import java.util.Scanner;
import java.util.Random;

public class TypingSpeedCalculator {
    private static final String[] WORDS = {
        "the", "be", "of", "and", "a", "to", "in", "he", "have", "it",
        "that", "for", "they", "with", "as", "not", "on", "she", "at",
        "by", "this", "we", "you", "do", "but", "from", "or", "which",
        "one", "would", "all", "will", "there", "say", "who", "make",
        "when", "can", "more", "if", "no", "man", "out", "other", "so",
        "what", "time", "up", "go", "about", "than", "into", "could"
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Welcome to the Typing Speed Test!");
        System.out.println("You will be given 30 seconds to type as many words as you can.");
        System.out.println("Press Enter when you're ready to start.");
        scanner.nextLine();

        StringBuilder testText = new StringBuilder();
        for (int i = 0; i < 200; i++) {
            testText.append(WORDS[random.nextInt(WORDS.length)]).append(" ");
        }

        System.out.println("Start typing:");
        System.out.println(testText.toString());

        long startTime = System.currentTimeMillis();
        String typed = scanner.nextLine();
        long endTime = System.currentTimeMillis();

        double elapsedTimeInSeconds = (endTime - startTime) / 1000.0;
        String[] typedWords = typed.trim().split("\\s+");
        int wordCount = typedWords.length;

        double wordsPerMinute = (wordCount / elapsedTimeInSeconds) * 60;

        System.out.printf("Time elapsed: %.2f seconds%n", elapsedTimeInSeconds);
        System.out.printf("Words typed: %d%n", wordCount);
        System.out.printf("Your typing speed: %.2f words per minute%n", wordsPerMinute);

        scanner.close();
    }
}