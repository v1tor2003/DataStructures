

import dsjava.tree.TreeBS;

public class Main2 {
  public static void main(String[] args) {
    TreeBS<Character> tree = new TreeBS<>();
    tree.insertBT('F');
    tree.insertBT('B');
    tree.insertBT('G');
    tree.insertBT('A');
    tree.insertBT('D');
    tree.insertBT('I');
    tree.insertBT('C');
    tree.insertBT('E');
    tree.insertBT('H');

    System.out.println("PreOrder");
    tree.preOrderTraversal();   
    System.out.println("\nInOrder");
    tree.inOrderTraversal();
    System.out.println("\nPostOrder");
    tree.postOrderTraversal();
  }
}
