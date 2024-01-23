package thread_concurrency;

public class DecrementTask implements  Runnable{
 private final Counter counter;


  public DecrementTask() {
    this.counter = new Counter();
  }

  public DecrementTask(Counter object) {
    this.counter = object; // Wrong approach: example requirements

   // this.counter = new Counter(object.getCount()); // Correct approach
  }


  @Override
  public void run() {
    for (int i = 0; i < 10000; i++) {
       counter.decrement();
    }
  }
}
