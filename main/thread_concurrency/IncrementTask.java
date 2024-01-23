package thread_concurrency;

class IncrementTask implements Runnable {
  private final Counter counter;
  private final int increments;

  public IncrementTask(Counter counter, int increments) {
    this.counter = counter;
    this.increments = increments;
  }

  public void run() {
    for (int i = 0; i < increments; i++) {
      counter.increment();
      System.out.println("Incremented: " + counter.getCount());
    }
  }
}