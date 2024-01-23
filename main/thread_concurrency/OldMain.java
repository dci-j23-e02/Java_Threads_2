package thread_concurrency;

import java.util.Scanner;

public class OldMain {

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);


    // Ask the user for the number of increments and decrements
    System.out.print("Enter the number of increments: ");
    int increments = input.nextInt();

    System.out.print("Enter the number of decrements: ");
    int decrements = input.nextInt();

    // Shared Counter object between threads
    Counter counter = new Counter();

    // Create tasks for incrementing and decrementing the counter
    Runnable incrementTask = () -> {
      for (int i = 0; i < increments; i++) {
        counter.increment();
        System.out.println("Incremented: "+ counter.getCount());

      }
    };


    Runnable decrementTask = () -> {
      for (int i = 0; i < decrements; i++) {
        counter.decrement();
        System.out.println("Decremented: "+ counter.getCount());

      }
    };


    // Create threads for the tasks
    Thread incrementThread = new Thread(incrementTask);
    Thread decrementThread = new Thread(decrementTask);


    // Start the Threads

    incrementThread.start();
    decrementThread.start();

    // Wait for both threads to finish
    try {
      incrementThread.join();
      decrementThread.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }


    // Print the final count value
    System.out.println("Final count is "+ counter.getCount());

    // Close the Scanner object
    input.close();


  }
}
