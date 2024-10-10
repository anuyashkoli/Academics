class SharedPrinter {
    private boolean isNumberTurn = true;  // To alternate between number and letter

    // Method to print numbers
    public synchronized void printNumber(int number) {
        while (!isNumberTurn) {
            try {
                wait();  // Wait for the letter to print
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("NumberThread - Number: " + number);
        isNumberTurn = false;
        notify();  // Notify letter thread
    }

    // Method to print letters
    public synchronized void printLetter(char letter) {
        while (isNumberTurn) {
            try {
                wait();  // Wait for the number to print
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("LetterThread - Letter: " + letter);
        isNumberTurn = true;
        notify();  // Notify number thread
    }
}

class NumberThread extends Thread {
    private SharedPrinter printer;

    public NumberThread(SharedPrinter printer) {
        this.printer = printer;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {  // Print numbers from 1 to 5
            printer.printNumber(i);
        }
    }
}

class LetterThread extends Thread {
    private SharedPrinter printer;

    public LetterThread(SharedPrinter printer) {
        this.printer = printer;
    }

    @Override
    public void run() {
        for (char letter = 'A'; letter <= 'E'; letter++) {  // Print letters from A to E
            printer.printLetter(letter);
        }
    }
}

public class LetterNumber {
    public static void main(String[] args) {
        SharedPrinter printer = new SharedPrinter();

        NumberThread numberThread = new NumberThread(printer);
        LetterThread letterThread = new LetterThread(printer);

        // Start both threads
        numberThread.start();
        letterThread.start();
    }
}
