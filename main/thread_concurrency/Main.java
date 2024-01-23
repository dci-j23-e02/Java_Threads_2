package thread_concurrency;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) throws InterruptedException {
    Scanner scanner = new Scanner(System.in);

    // Ask the user for the number of increments and decrements
    System.out.print("Enter the number of increments: ");
    int increments = scanner.nextInt();
    System.out.print("Enter the number of decrements: ");
    int decrements = scanner.nextInt();

    // Shared Counter object between threads
    Counter counter = new Counter();

    // Create tasks for incrementing and decrementing the counter
    IncrementTask incrementTask = new IncrementTask(counter, increments);
    DecrementTask decrementTask = new DecrementTask(counter, decrements);

    // Create threads for the tasks
    Thread incrementThread = new Thread(incrementTask);
    Thread decrementThread = new Thread(decrementTask);

    // Start the threads
    incrementThread.start();
    decrementThread.start();

    // Wait for both threads to finish
    incrementThread.join();
    decrementThread.join();

    // Print the final count value
    System.out.println("Final count is: " + counter.getCount());

    // Close the scanner
    scanner.close();
  }
}

/**
 *
 * The `Main` class now uses the `IncrementTask` and `DecrementTask` classes
 * to create threads that increment and decrement the counter.
 * The `IncrementTask` and `DecrementTask` classes have been modified
 * to accept the number of operations to perform as parameters,
 * which are passed from the `Main` class.
 * */