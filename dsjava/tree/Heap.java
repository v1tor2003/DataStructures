package dsjava.tree;

import java.util.Comparator;
import dsjava.tree.TreeBS.Node;

public class Heap{
  private static final int MIN = 1;
  private static final int MAX = 2;

  public static <T, K extends Comparator<T>> void heapify(T[] array, K key, int heapType){
    if(heapType == MAX) buildMaxHeap(array, key);
    else if(heapType == MIN) buildMinHeap(array, key);
    else{
      System.out.println("Invalid Heap type, choose (1-MIN, 2-MAX).");
      return;
    }
  }

  public static <T, K extends Comparator<T>> void heapSort(T[] array, K key){
    heapify(array, key, 2);
    
    for(int i = array.length - 1; i > 0; --i){
      swap(array, 0, i);
      maxHeapify(array, key, 0);
    }
  }

  public static <T, K extends Comparator<T>> void buildMaxHeap(T[] array, K key){
    for(int i = Math.floorDiv(array.length, 2) - 1; i >= 0; i--)
      maxHeapify(array, key, i);
  }

  public static <T, K extends Comparator<T>> void buildMinHeap(T[] array, K key){
    for(int i = Math.floorDiv(array.length, 2) - 1; i >= 0; i--)
      minHeapify(array, key, i);
  }

  private static <T, K extends Comparator<T>> void maxHeapify(T[] array, K key, int i){
    int root = i;
    int left = 2*i + 1;
    int right = 2*i + 2;
    
    if(left < array.length && key.compare(array[left], array[root]) > 0){
      root = left;
    }

    if(right < array.length && key.compare(array[right], array[root]) > 0){
      root = right;
    }
    if(root != i){
      swap(array, i, root);
      maxHeapify(array, key, root);
    }
  }

  private static <T, K extends Comparator<T>> void minHeapify(T[] array, K key, int i){
    int root = i;
    int left = 2*i + 1;
    int right = 2*i + 2;
    
    if(left < array.length && key.compare(array[left], array[root]) <= 0){
      root = left;
    }

    if(right < array.length && key.compare(array[right], array[root]) <= 0){
      root = right;
    }
    if(root != i){
      swap(array, i, root);
      minHeapify(array, key, root);
    }
  }

  private static <T> void swap(T[] array, int index1, int index2) {
    T tmp = array[index1];
    array[index1] = array[index2];
    array[index2] = tmp;
  }

  public static <T extends Comparable<T>> int isHeap(Node<T> root){
    TreeBS<T> tree = new TreeBS<>(root);
    return tree.isHeap();
  }
}