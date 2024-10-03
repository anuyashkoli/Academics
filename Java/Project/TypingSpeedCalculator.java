import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class TypingSpeedCalculator {

    private String sampleText;
    private String userInput = ""; // Initialize user input
    private long startTime;
    private long endTime;
    private boolean timeUp = false; // To check if the time is up

    // Word pool for longer text samples
    private final String[] wordPool = {
        "The quick brown fox jumps over the lazy dog.",
        "Java is a high-level programming language.",
        "A journey of a thousand miles begins with a single step.",
        "Practice makes perfect, so keep typing to improve.",
        "Artificial Intelligence is transforming the world.",
        "Typing speed can be improved through regular practice.",
        "The cat sat on the mat and looked at the moon.",
        "Consistent effort is the key to mastering any skill.",
        "Data science is an interdisciplinary field.",
        "Cloud computing enables scalable resource management."
    };

    // Constructor to initialize a longer sample text by merging multiple lines
    public TypingSpeedCalculator() {
        sampleText = getMergedSampleText();
    }

    // Method to merge multiple lines from the word pool for longer sample text
    private String getMergedSampleText() {
        StringBuilder mergedText = new StringBuilder();
        for (String sentence : wordPool) {
            mergedText.append(sentence).append(" "); // Append each sentence
        }
        return mergedText.toString().trim();
    }

    // Method to display the sample text
    private void displaySampleText() {
        System.out.println("Type the following text and press Enter when done (or after 30 seconds):");
        System.out.println(sampleText);
    }

    // Method to capture user input with a 30-second time limit
    private void captureUserInput() {
        Scanner scanner = new Scanner(System.in);

        // Create a timer to stop after 30 seconds
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                timeUp = true;  // Set the flag when time is up
                System.out.println("\nTime's up!"); // Notify the user
                scanner.close(); // Close the scanner
            }
        };
        timer.schedule(task, 30000); // Set the timer for 30 seconds (30000 milliseconds)

        // Start time before typing
        startTime = System.currentTimeMillis();

        // While time is not up, keep capturing the user's input
        while (!timeUp && scanner.hasNextLine()) {
            userInput += scanner.nextLine(); // Append user input as a string
        }

        // End time after user finishes or time's up
        endTime = System.currentTimeMillis();
    }

    // Method to calculate time taken
    private double calculateTimeTaken() {
        return (endTime - startTime) / 1000.0; // Convert milliseconds to seconds
    }

    // Method to calculate typing speed in words per minute
    private double calculateTypingSpeed(double timeTaken) {
        if (userInput.trim().isEmpty()) {
            return 0; // No words typed if input is empty
        }
        int wordCount = userInput.split("\\s+").length;
        return (wordCount / timeTaken) * 60; // Words per minute
    }

    // Method to calculate typing accuracy
    private double calculateAccuracy() {
        if (userInput.trim().isEmpty()) {
            return 0; // No accuracy if no input was provided
        }
        int correctChars = 0;
        int minLength = Math.min(sampleText.length(), userInput.length());

        // Compare character by character for the portion that the user typed
        for (int i = 0; i < minLength; i++) {
            if (sampleText.charAt(i) == userInput.charAt(i)) {
                correctChars++;
            }
        }

        // Return accuracy as a percentage based on the user's input length
        return (correctChars / (double) userInput.length()) * 100;
    }

    // Method to display the results
    private void displayResults(double timeTaken, double typingSpeed, double accuracy) {
        int wordsTyped = userInput.trim().isEmpty() ? 0 : userInput.split("\\s+").length;

        System.out.printf("You typed %d words in %.2f seconds.%n", wordsTyped, timeTaken);
        System.out.printf("Your typing speed is %.2f words per minute.%n", typingSpeed);
        System.out.printf("Your accuracy is %.2f%%%n", accuracy);
    }

    // Main method to run the program
    public static void main(String[] args) {
        TypingSpeedCalculator calculator = new TypingSpeedCalculator();

        // Display sample text
        calculator.displaySampleText();

        // Capture user input
        calculator.captureUserInput();

        // Calculate results
        double timeTaken = calculator.calculateTimeTaken();
        double typingSpeed = calculator.calculateTypingSpeed(timeTaken);
        double accuracy = calculator.calculateAccuracy();

        // Display results
        calculator.displayResults(timeTaken, typingSpeed, accuracy);
    }
}