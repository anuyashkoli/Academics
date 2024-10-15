
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;

public class TypingSpeedGUI extends JFrame {

    private JTextArea inputTextArea;
    private JLabel speedLabel, accuracyLabel, timerLabel;
    private JButton startButton, stopButton;
    private Timer countdownTimer;
    private int remainingTime = 30; // 30 minutes in seconds
    private long startTime;

    private String sampleText = "The quick brown fox jumps over the lazy dog.";

    public TypingSpeedGUI() {
        // Set up the frame
        setTitle("Typing Speed Calculator");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Sample text label
        JLabel sampleLabel = new JLabel("Sample Text: " + sampleText);
        sampleLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        add(sampleLabel, BorderLayout.NORTH);

        // Text area for typing
        inputTextArea = new JTextArea();
        inputTextArea.setLineWrap(true);
        inputTextArea.setWrapStyleWord(true);
        inputTextArea.setFont(new Font("Arial", Font.PLAIN, 16));
        inputTextArea.setEditable(false);
        add(new JScrollPane(inputTextArea), BorderLayout.CENTER);

        // Panel for buttons, timer, and results
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2, 10, 10));

        // Timer label
        timerLabel = new JLabel("Time left: 00:30");
        timerLabel.setFont(new Font("Arial", Font.BOLD, 14));

        // Start button (Green)
        startButton = new JButton("Start");
        startButton.setBackground(Color.GREEN);
        startButton.setForeground(Color.BLACK);

        // Stop button (Red)
        stopButton = new JButton("Stop");
        stopButton.setBackground(Color.RED);
        stopButton.setForeground(Color.WHITE);
        stopButton.setEnabled(false);

        // Labels for speed and accuracy
        speedLabel = new JLabel("Speed (WPM): ");
        accuracyLabel = new JLabel("Accuracy (%): ");

        panel.add(timerLabel);
        panel.add(new JLabel()); // Empty space
        panel.add(startButton);
        panel.add(stopButton);
        panel.add(speedLabel);
        panel.add(accuracyLabel);

        add(panel, BorderLayout.SOUTH);

        // Start button action
        startButton.addActionListener((ActionEvent e) -> {
            startTest();
        });

        // Stop button action
        stopButton.addActionListener((ActionEvent e) -> {
            stopTest();
        });

        // Countdown timer action (runs every second)
        countdownTimer = new Timer(1000, (ActionEvent e) -> {
            updateTimer();
        });

        // Key Listener for Enter key
        inputTextArea.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    stopTest();
                }
            }
        });

        // Bind Enter key to Start button
        startButton.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
                .put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "start");
        startButton.getActionMap().put("start", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startTest();
            }
        });
    }

    // Start the typing test
    private void startTest() {
        inputTextArea.setEditable(true);
        inputTextArea.setText("");
        startTime = System.currentTimeMillis();
        startButton.setEnabled(false);
        stopButton.setEnabled(true);
        remainingTime = 30; // Reset the timer to 30 minutes
        countdownTimer.start(); // Start the countdown timer
        inputTextArea.requestFocus(); // Focus on text area for typing
    }

    // Stop the typing test and calculate results
    private void stopTest() {
        countdownTimer.stop(); // Stop the timer
        inputTextArea.setEditable(false);
        long endTime = System.currentTimeMillis();
        String userInput = inputTextArea.getText();

        // Calculate time taken in minutes
        double timeTaken = (endTime - startTime) / 1000.0 / 60.0;

        // Check if userInput is empty
        if (userInput.trim().isEmpty()) {
            speedLabel.setText("Speed (WPM): User didn't type anything");
        } else {
            // Calculate word count and typing speed (WPM)
            int wordCount = userInput.split("\\s+").length;

            // Ensure timeTaken is greater than zero to avoid division by zero
            double typingSpeed = (timeTaken > 0) ? wordCount / timeTaken : 0;

            // Calculate accuracy
            double accuracy = calculateAccuracy(sampleText, userInput);

            // Display results
            speedLabel.setText(String.format("Speed (WPM): %.2f", typingSpeed));
            accuracyLabel.setText(String.format("Accuracy (%%): %.2f", accuracy));
        }

        startButton.setEnabled(true);
        stopButton.setEnabled(false);
    }

    // Update the timer label each second
    private void updateTimer() {
        remainingTime--;
        int minutes = remainingTime / 60;
        int seconds = remainingTime % 60;
        timerLabel.setText(String.format("Time left: %02d:%02d", minutes, seconds));

        if (remainingTime <= 0) {
            countdownTimer.stop();
            stopTest(); // Auto-stop the test when time runs out
            JOptionPane.showMessageDialog(this, "Time's up! Test stopped.");
        }
    }

    // Calculate accuracy between sample text and user input
    private double calculateAccuracy(String sample, String input) {
        int correctChars = 0;
        int totalChars = Math.min(sample.length(), input.length());

        for (int i = 0; i < totalChars; i++) {
            if (sample.charAt(i) == input.charAt(i)) {
                correctChars++;
            }
        }

        return ((double) correctChars / sample.length()) * 100;
    }

    // Main method to run the program
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TypingSpeedGUI frame = new TypingSpeedGUI();
            frame.setVisible(true);
        });
    }
}
