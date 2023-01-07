import allQuestions.sorting.NameComparator;
import allQuestions.sorting.Person;
import dsjava.tree.Heap;
import dsjava.tree.TreeBS;

public class TreeAndHeapProgram {
  public static void main(String[]args) {
    Person[] people = {
      new Person("B", 2, 8),
      new Person("A", 3, 7),
      new Person("C", 4, 10),
      new Person("F", 1, 5),
      new Person("V", 5, 8)
    };   

    TreeBS<Integer> tree = new TreeBS<>();
    tree.insertBST(1);
    tree.insertBST(2);
    tree.insertBST(3);
    tree.insertBST(4);
    System.out.print(tree.height());
    System.out.print(Heap.isHeap(tree.getRoot()));
    
    System.out.println("To Max heap:");
    Heap.heapify(people, new NameComparator(), 2);
    for(Person person : people)
      System.out.print(person);      
    
    System.out.println("To Min heap:");
    Heap.heapify(people, new NameComparator(), 1);
    for(Person person : people)
      System.out.print(person);
  }
}
