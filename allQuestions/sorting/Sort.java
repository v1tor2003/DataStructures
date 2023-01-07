package allQuestions.sorting;

import java.util.Comparator;

import dsjava.tree.Heap;

public class Sort {
  // for some reason in heapSort, it sorts the array in desc order
  // and for the grades places a element in a wrong position
  public static <T, K extends Comparator<T>> void heapSort(T[] array, K key){
    Heap.heapSort(array, key);
  }

  public static <T, K extends Comparator<T>> void quickSort(T[] array, K key, int start, int end){
    if(end <= start) return;
    int pivot = partition(array, key, start, end);
    quickSort(array, key, start, pivot - 1);
    quickSort(array, key, pivot + 1, end);
  }

  private static <T, K extends Comparator<T>> int partition(T[] array, K key, int start, int end){
    T partitionPivot = array[end];
    int i = start - 1;

    for(int j = start; j <= end-1; j++){
      if(key.compare(array[j], partitionPivot) == -1) {
        i++;
        T aux = array[i];
        array[i] = array[j];
        array[j] = aux;
      } 
    }
    i++;
    T aux = array[i];
    array[i] = array[end];
    array[end] = aux;
    return i;
  }
  
  @SuppressWarnings("unchecked")
  public static <T, K extends Comparator<T>> void mergeSort(T[] array, K key){
    int n = array.length;
    if(n <= 1) return;

    int mid = n / 2;
    // forcing the use of a generic array by casting a Object to it 
    // its not recomended and unsafe
    // but the mergeSort algorithm cannot work without these
    T[] leftArray = (T[]) new Object[mid];
    T[] rightArray = (T[]) new Object[n - mid];

    int i = 0, j = 0;
    
    for(i = 0; i < n; i++){
      if(i < mid)
        leftArray[i] = array[i];
      else{
        rightArray[j] = array[i];
        j++;
      }
    }

    mergeSort(leftArray, key);
    mergeSort(rightArray,key);
    merge(leftArray, rightArray, array, key);
  }

  private static <T, K extends Comparator<T>> void merge(T[] letfArray, T[] rightArray, T[] array, K key){
    int leftSize = array.length / 2;
    int rightSize = array.length - leftSize;
    int i = 0, left = 0, right = 0;
    
    while(left < leftSize && right < rightSize){
      if(key.compare(letfArray[left], rightArray[right]) == -1){
        array[i] = letfArray[left];
        i++;
        left++;
      }else {
        array[i] = rightArray[right];
        i++;
        right++;
      }
    }

    while(left < leftSize){
      array[i] = letfArray[left];
      i++;
      left++;
    }

    while(right < rightSize){
      array[i] = rightArray[right];
      i++;
      right++;
    }
  }

  public static <T, K extends Comparator<T>> void insertionSort(T[] array, K key){
    for(int i = 1; i < array.length; i++){
      T temp = array[i];
      int j = i - 1;

      while(j >= 0 && key.compare(array[j], temp) == 1){
        array[j + 1] = array[j];
        j--;
      }
      array[j + 1] = temp;
    }
  }

  public static <T, K extends Comparator<T>> void selectionSort(T[] array, K key){
    for(int i = 0; i < array.length - 1; i++){
      int minimum = i;
      for(int j = i + 1; j < array.length; j++){
        if(key.compare(array[minimum], array[j]) == 1)
          minimum = j;
      }
      T aux = array[i];
      array[i] = array[minimum];
      array[minimum] = aux;
    }
  }
}
