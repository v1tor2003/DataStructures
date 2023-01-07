package allQuestions.sorting.menu;

import java.util.Comparator;

import allQuestions.sorting.GradeComparator;
import allQuestions.sorting.NameComparator;
import allQuestions.sorting.RegistrationComparator;
import allQuestions.sorting.Sort;

public class SortingMenu extends MenuBase{
  
  private class KeyMenu extends MenuBase{
    protected int methodChoice;
    private Object[] arrayRef;

    public <T> KeyMenu(T[] array, int choice){
      super(false,
            new String[] {"Select Sorting Key:\n", "0. Back.\n", "1. Nome.\n", "2. Matricula.\n", "3. Nota.\n"}
            , "");
      this.methodChoice = choice;
      this.arrayRef = array;
    }

    @SuppressWarnings("unchecked")
    private <T, K extends Comparator<T>> void runMethod(K userKey){
      T[] castedArray = (T[]) arrayRef;
      System.out.println("userkey" + userKey);
      System.out.println("sorting method" + methodChoice);
      switch (this.methodChoice) {
        case 1:
          Sort.quickSort(castedArray, userKey, 0, castedArray.length - 1);
          break;
        case 2:
          Sort.mergeSort(castedArray, userKey);
          break;
        case 3:
          Sort.insertionSort(castedArray, userKey);
          break;
        case 4:
          Sort.selectionSort(castedArray, userKey);
          break;
        case 5:
          Sort.heapSort(castedArray, userKey);
          break;
        default:
          break;
      }
      System.out.print("Sorted Array:\n");
      for(T element : castedArray)
        System.out.print(element);
      System.out.print("Exiting Program...\n");
      super.exit = true;
    }    

    @Override
    protected void performAction(short option){
      super.performAction(option);
      if(option == 1) runMethod(new NameComparator());
      else if (option == 2) runMethod(new RegistrationComparator());
      else runMethod(new GradeComparator());
    }
  } 
  private Object[] arrayRef;

  public <T> SortingMenu(T[] array){
    super(true,
      new String[] {"Select Sorting Method:\n", 
                  "0. Exit.\n", "1. QuickSort.\n", "2. MergeSort.\n", "3. InsertionSort.\n",
                  "4. SelectionSort.\n", "5. HeapSort.\n"},
      menuInfo(array));
    this.arrayRef = array;
  }

  private static <T> String menuInfo(T[] array){
    String str = "----Sorting Program----\n\n";
    str += "Stored Array:\n";
    for(T element : array)
      str += element.toString();
    
    return str;
  }

  @Override
  protected void performAction(short option){
    super.performAction(option);
    KeyMenu keyMenu = new KeyMenu(arrayRef, option);
    keyMenu.run();
    exit = true;
  }
}
