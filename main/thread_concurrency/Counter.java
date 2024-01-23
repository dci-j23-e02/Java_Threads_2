package thread_concurrency;

public class Counter {

  private int count = 0;

  public Counter() {}

  public Counter(int i) {
    this.count = i;
  }




  // Synchronized  method to increment count
  public  synchronized  void increment(){
    count++; // Increment the count by 1
  }


  // Synchronized  method to decrement count
  public  synchronized  void decrement(){
    count--; // Decrement the count by 1
  }

  public int getCount() {
    return count;
  }
}
