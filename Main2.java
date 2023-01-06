import dsjava.tree.Heap;
import dsjava.tree.TreeBS;

public class Main2 {
  public static void main(String[] args) {
    TreeBS<Integer> tree = new TreeBS<>();
    tree.insertBST(1);
    tree.insertRight(0);
    tree.insertLeft(-1);
    //tree.insertBT("A");
    //tree.insertBT("D");
    //tree.insertBT("I");
    //tree.insertBT("C");
    //tree.insertBT("E");
    //tree.insertBT("H");

    System.out.println("PreOrder");
    tree.preOrderTraversal();   
    System.out.println("\nInOrder");
    tree.inOrderTraversal();
    System.out.println("\nPostOrder");
    tree.postOrderTraversal();
    System.out.println("\n" + tree.height());
    System.out.println("\n" + tree.isComplete());
    System.out.println("\n" + tree.isHeap());
    System.out.println("\n" + Heap.isHeap(tree.getRoot()));

    Character[] test = {'F', 'T', 'R', 'A'};
    Heap.heapSort(test, "teste",test.length);
    System.out.println(test);
  }

}
