package allQuestions.byUsingQueue;

import dsjava.queue.Queue;

public class PrimeNumber {
  private static Queue<Integer> factors = new Queue<>();
  
  public static void main(String[] args) {
    primeFactors(3960);
  }

  public static void primeFactors(int n){
    addFactors(n);
    reverseQueue();
    System.out.println(factors.toString().replace(' ', '*'));
  }
  
  private static void reverseQueue() {
    if(factors.isEmpty()) return;
    int temp = factors.first().getData();
    factors.deQueue();
    reverseQueue();
    factors.enQueue(temp);
  }
  
  private static void addFactors(int n) {
    while(n == 1) return;
    int d = findPrimeFactor(n);
    factors.enQueue(d);
    addFactors(n/d); 
  }
  private static Integer findPrimeFactor(int n){
    for(int i = 2; i < n; i++)
      if(n % i == 0)
        return i;

    return n;
  }
}
