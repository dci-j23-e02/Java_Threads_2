package thread_concurrency;

class DecrementTask implements Runnable {
  private final Counter counter;
  private final int decrements;

  public DecrementTask(Counter counter, int decrements) {
    this.counter = counter;
    this.decrements = decrements;
  }

  public void run() {
    for (int i = 0; i < decrements; i++) {
      counter.decrement();
      System.out.println("Decremented: " + counter.getCount());
    }
  }
}