class NumberPrinter {
    private int currentNumber = 1;

    // Synchronized method to ensure proper sequential printing
    public synchronized void printNumbers() {
        while (currentNumber <= 100) {
            System.out.printf("%02d ", currentNumber);
            if (currentNumber % 10 == 0) {
                System.out.println();  // New line after every 10 numbers
            }
            currentNumber++;

            try {
                Thread.sleep(50);  // Sleeping to simulate clipping numbers
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class NumberThread extends Thread {
    private NumberPrinter printer;

    public NumberThread(NumberPrinter printer) {
        this.printer = printer;
    }

    @Override
    public void run() {
        printer.printNumbers();
    }
}

public class Main {
    public static void main(String[] args) {
        NumberPrinter printer = new NumberPrinter();

        // Creating two threads
        NumberThread thread1 = new NumberThread(printer);
        NumberThread thread2 = new NumberThread(printer);

        // Starting both threads
        thread1.start();
        thread2.start();
    }
}
