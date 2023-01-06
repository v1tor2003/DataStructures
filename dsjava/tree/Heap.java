package dsjava.tree;

import java.util.Comparator;
import dsjava.tree.TreeBS.Node;

public class Heap{
  public static <T extends Comparator<T>> void heapify(T[] array, int n, boolean MAX){
    if(MAX) maxHeapify(array, n);
    else minHeapify(array, n); 
  }
  
  public static <T extends Comparator<T>, K> void heapSort(T[] array, K key, int n){
    heapify(array, n, true);
    System.out.println(key);
    for(int i = n; i >= 2; i--){
      swap(array[1], array[i]);
      n = n - 1;
      maxHeapify(array, 1);
    }
  }

  public static <T extends Comparator<T>> void buildMaxHeap(T[] array, int n){
    for(int i = Math.floorDiv(n, 2); i >=1; i--)
      maxHeapify(array, i);
  }

  private static <T extends Comparator<T>> void maxHeapify(T[] array, int i){
    T largest = null;
    int largestPositon;

    if(left(i) <= array.length && ){//array[left(i)].compareTo(array[i]) > 0){
      largest = array[left(i)];
      largestPositon = left(i);
    }
    else{
      largest = array[i];
      largestPositon = i;
    }

    if(right(i) <= array.length && )
      largest = array[right(i)];
      largestPositon = right(i);
    if(largestPositon != i){
      swap(array[i], array[largestPositon]);
      maxHeapify(array, largestPositon);
    }
  }

  private static <T extends Comparator<T>> void minHeapify(T[] array, int i){

  }

  private static <T> void swap(T index1, T index2) {
    T tmp = index1;
    index1 = index2;
    index2 = tmp;
  }

  private static int left(int i){
    return 2*i + 1;
  }

  private static int right(int i){
    return 2*i + 2;
  }
  public static <T extends Comparable<T>> int isHeap(Node<T> root){
    TreeBS<T> tree = new TreeBS<>(root);
    return tree.isHeap();
  }
}