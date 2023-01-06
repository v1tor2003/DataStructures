package dsjava.tree;

import dsjava.queue.Queue;

public class TreeBS<T extends Comparable<T>> {
  public static class Node<T extends Comparable<T>> {
    private T key;
    private Node<T> right;
    private Node<T> left;

    protected Node(T key) {
      this.key = key;
      this.right = null;
      this.left = null;
    }

    protected Node() {
      this.right = null;
      this.left = null;
    }

    public T getKey() {
      return key;
    }

    public Node<T> getRight() {
      return right;
    }

    public Node<T> getLeft() {
      return left;
    }

    protected void setKey(T value) {
      this.key = value;
    }

    protected void setRight(Node<T> nodeReference) {
      this.right = nodeReference;
    }

    protected void setLeft(Node<T> nodeReference) {
      this.left = nodeReference;
    }

    protected void setRight(Node<T> nodeReference, T value) {
      this.right = nodeReference;
      this.right.setKey(value);
    }

    protected void setLeft(Node<T> nodeReference, T value) {
      this.left = nodeReference;
      this.left.setKey(value);
    }

    protected Node<T> createNode() {
      Node<T> tempNode = new Node<T>();
      return tempNode;
    }

  }

  private Node<T> root;

  public TreeBS() {
    this.root = null;
  }

  public TreeBS(Node<T> root) {
    this.root = root;
  }

  public Node<T> getRoot() {
    return root;
  }

  public void insertRight(T value){
    root = insert(root, value, true);
  }

  public void insertLeft(T value){
    root = insert(root, value, false);
  }

  private Node<T> insert(Node<T> root, T value, boolean RIGHT){
    if(root == null) return new Node<T>(value);
    else if(RIGHT)
      if(root.getRight() == null)
        root.setRight(new Node<T>(value));
      else
        return insert(root.getRight(), value, RIGHT);
    else
      if(root.getLeft() == null)
        root.setLeft(new Node<T>(value));
      else
        return insert(root.getLeft(), value, RIGHT);

    return root;
  }

  public void insertBST(T value){
    root = insertBST(root, value);
  }

  private Node<T> insertBST(Node<T> root, T value) {
    if(root == null) return new Node<T> (value);
    else if(value.compareTo(root.getKey()) < 0)
      root.left = insertBST(root.getLeft(), value);
    else
      root.right = insertBST(root.getRight(), value);

    return root;
  }

  public void preOrderTraversal(){
    preOrderTraversal(root);
  }

  public void inOrderTraversal(){
    inOrderTraversal(root);
  }

  public void postOrderTraversal(){
    postOrderTraversal(root);
  }

  private void preOrderTraversal(Node<T> root) {
    if(root == null){
      System.out.println("Empty tree.");
      return;
    }

    System.out.print(" " + root.getKey());
    if(root.getLeft() != null)
      preOrderTraversal(root.getLeft());
    if(root.getRight() != null)
      preOrderTraversal(root.getRight());
  }

  private void inOrderTraversal(Node<T> root) {
    if(root == null){
      System.out.println("Empty tree.");
      return;
    }
    if(root.getLeft() != null)
      inOrderTraversal(root.getLeft());
    System.out.print(" " + root.getKey()); 
    if(root.getRight() != null)
      inOrderTraversal(root.getRight());
  }

  private void postOrderTraversal(Node<T> root) {
    if(root == null){
      System.out.println("Empty tree.");
      return;
    }
    if(root.getLeft() != null)
      postOrderTraversal(root.getLeft());
    if(root.getRight() != null)
      postOrderTraversal(root.getRight());
    System.out.print(" " + root.getKey());
  }
  
  private Node<T> findKey(Node<T> root, String name) {
    if (root == null) return null;
    if (root.getKey().equals(name)) return root;
    
    Node<T> nodeAux = new Node<T>();
    nodeAux = findKey(root.getLeft(), name);
    if (nodeAux != null) return nodeAux;
    return findKey(root.getRight(), name);
  }

  protected Node<T> findNode(Node<T> root, T value) {
    if (root == null) return null;
    if (root.getKey().compareTo(value) == 0)  return root;
  
    Node<T> nodeAux = new Node<T>();
    nodeAux = findNode(root.getLeft(), value);
    if (nodeAux != null) return nodeAux;
    return findNode(root.getRight(), value);
  }

  public int height(){  return height(root);  }

  private int height(Node<T> root){
    if(root == null) return -1;
    return Math.max(height(root.getLeft()), height(root.getRight())) + 1;
  }

  public int isHeap(){
    return isHeap(root);
  }

  private int isHeap(Node<T> root){
    if(isComplete(root))
      if(isMaxHeap(root)) return 1;
      else if(isMinHeap(root)) return -1;
    
    return 0;
  }

  private boolean isMinHeap(Node<T> root){
    return hasHeapCondition(root, false);
  }

  private boolean isMaxHeap(Node<T> root){
    return hasHeapCondition(root, true);
  }

  private boolean hasHeapCondition(Node<T> root, boolean MAX){
    if(root == null) return false;
    Queue<Node<T>> LOTQueue = new Queue<>();
    T a = null, b = null;
    LOTQueue.enQueue(root);
    while(!LOTQueue.isEmpty()){
      Node<T> current = LOTQueue.first().getData();
      LOTQueue.deQueue();
      if(current.getLeft() != null){
        a = current.getLeft().getKey();
        LOTQueue.enQueue(current.getLeft());
      }
      if(current.getRight() != null){
        b = current.getRight().getKey();
        LOTQueue.enQueue(current.getRight());
      }
      if(MAX)
        return !(a.compareTo(current.getKey()) > 0 || b.compareTo(current.getKey()) > 0);
      else
        return !(a.compareTo(current.getKey()) < 0 || b.compareTo(current.getKey()) < 0);
    } 
    return true;
  }


  public boolean isComplete(){
    return isComplete(root);
  }

  public boolean isComplete(Node<T> root){
    if(root == null) return true;
    boolean completeCondition = false;
    Queue<Node<T>> LOTQueue = new Queue<>();
    LOTQueue.enQueue(root);
    while(!LOTQueue.isEmpty()){
      Node<T> current = LOTQueue.first().getData();
      LOTQueue.deQueue();
      if(current.getLeft() != null){
        if(completeCondition) return false;
        LOTQueue.enQueue(current.getLeft());
      }else{
        completeCondition = true;
      }
      if(current.getRight() != null){
        if(completeCondition) return false;
        LOTQueue.enQueue(current.getRight());
      }else{
        completeCondition = true;
      }
    }
    return true;
  }

  public boolean contains(T value){
    return contains(root, value);
  }

  private boolean contains(Node<T> root, T value) {
    return !(findNode(root, value) == null);
  }

  public boolean containsKey(Node<T> root, String value) {
    return !(findKey(root, value) == null);
  }

  private boolean hasTwoChild(Node<T> root) {
    return (root.getLeft() != null && root.getRight() != null);
  }

  private boolean hasOneChild(Node<T> root) {
    return (root.getLeft() != null || root.getRight() != null);
  }

  private boolean isLeaf(Node<T> root) {
    return (root.getLeft() == null && root.getRight() == null);
  }

  public int size(){
    return size(root);
  }

  private int size(Node<T> root) {
    if (root == null) return 0;
    else 
      return 1 + size(root.getLeft()) + size(root.getRight());
  }

  private T valueSubstitute(Node<T> root) {
    if (root.getRight() != null) 
      return (valueSubstitute(root.getRight()));
    
    return root.getKey();
  }

  public void removeBT(T value) {
    removeNode(this.root, value);
  }

  private Node<T> removeNode(Node<T> root, T value) {
    if (contains(root, value)) {
      if (root.getKey().compareTo(value) == 1) {
        root.setLeft(removeNode(root.getLeft(), value));
      } else if (root.getKey().compareTo(value) == -1) {
        root.setRight(removeNode(root.getRight(), value));
      } else {
        if (isLeaf(root)) {
          root = null;
          return root;
        } else if (hasTwoChild(root)) {
          T substituteValue = valueSubstitute(root.getLeft());
          root.setKey(substituteValue);
          root.setLeft(removeNode(root.getLeft(), substituteValue));
        } else if (hasOneChild(root)) {
          if (root.getLeft() == null) {
            return root.getRight();
          } else if (root.getRight() == null) {
            return root.getLeft();
          }
        }
      }
      return root;
    }
    return null;
  }

  /*
   * private Node<T> removeNode(Node<T> root, T value) {
   * if (containsKey(root, value)){
   * if(root.getKey().compareTo(value) == 1) {
   * root.setLeft(removeNode(root.getLeft(), value));
   * }else if(root.getKey().compareTo(value) == -1) {
   * root.setRight(removeNode(root.getRight(), value));
   * }else{
   * if(isLeaf(root)){
   * root = null;
   * return root;
   * } else if (hasTwoChild(root)) {
   * T substituteValue = valueSubstitute(root.getLeft());
   * root.setKey(substituteValue);
   * root.setLeft(removeNode(root.getLeft(), substituteValue));
   * }
   * else if (hasOneChild(root)) {
   * if (root.getLeft() == null) {
   * return root.getRight();
   * } else if (root.getRight() == null) {
   * return root.getLeft();
   * }
   * }
   * }
   * return root;
   * }
   * return null;
   * }
   */

}
