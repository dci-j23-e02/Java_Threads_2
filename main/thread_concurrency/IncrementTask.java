package thread_concurrency;

public class IncrementTask implements Runnable {

  private final Counter counter;

  public IncrementTask() {
    this.counter = new Counter();
  }

  public IncrementTask(Counter object) {
    this.counter = object; // Wrong approach: example requirements

   // this.counter = new Counter(object.getCount()); // Correct approach
  }

  @Override
  public void run() {
    for (int i = 0; i < 10000; i++) {
      counter.increment();
    }
  }
}
