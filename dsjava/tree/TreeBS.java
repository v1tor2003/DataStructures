package dsjava.tree;

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

  public TreeBS(T value) {
    insertBT(this.root, value);
  }

  public Node<T> getRoot() {
    return root;
  }

  public void insertBT(T value){
    root = insertBT(root, value);
  }

  private Node<T> insertBT(Node<T> root, T value) {
    if(root == null) return new Node<T> (value);
    else if(value.compareTo(root.getKey()) < 0)
      root.left = insertBT(root.getLeft(), value);
    else
      root.right = insertBT(root.getRight(), value);

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
  
  private Node<T> findKey(Node<T> currentNode, String name) {
    if (currentNode == null) return null;
    if (currentNode.getKey().equals(name)) return currentNode;
    
    Node<T> nodeAux = new Node<T>();
    nodeAux = findKey(currentNode.getLeft(), name);
    if (nodeAux != null) return nodeAux;
    return findKey(currentNode.getRight(), name);
  }

  protected Node<T> findNode(Node<T> currentNode, T value) {
    if (currentNode == null) return null;
    if (currentNode.getKey().compareTo(value) == 0)  return currentNode;
  
    Node<T> nodeAux = new Node<T>();
    nodeAux = findNode(currentNode.getLeft(), value);
    if (nodeAux != null) return nodeAux;
    return findNode(currentNode.getRight(), value);
  }

  public boolean contains(Node<T> currentNode, T value) {
    return !(findNode(currentNode, value) == null);
  }

  public boolean containsKey(Node<T> currentNode, String value) {
    return !(findKey(currentNode, value) == null);
  }

  private boolean hasTwoChild(Node<T> currentNode) {
    return (currentNode.getLeft() != null && currentNode.getRight() != null);
  }

  private boolean hasOneChild(Node<T> currentNode) {
    return (currentNode.getLeft() != null || currentNode.getRight() != null);
  }

  private boolean isLeaf(Node<T> currentNode) {
    return (currentNode.getLeft() == null && currentNode.getRight() == null);
  }

  public int size(Node<T> currentNode) {
    if (currentNode == null) return 0;
    else 
      return 1 + size(currentNode.getLeft()) + size(currentNode.getRight());
  }

  private T valueSubstitute(Node<T> currentNode) {
    if (currentNode.getRight() != null) 
      return (valueSubstitute(currentNode.getRight()));
    
    return currentNode.getKey();
  }

  public void removeBT(T value) {
    removeNode(this.root, value);
  }

  private Node<T> removeNode(Node<T> currentNode, T value) {
    if (contains(currentNode, value)) {
      if (currentNode.getKey().compareTo(value) == 1) {
        currentNode.setLeft(removeNode(currentNode.getLeft(), value));
      } else if (currentNode.getKey().compareTo(value) == -1) {
        currentNode.setRight(removeNode(currentNode.getRight(), value));
      } else {
        if (isLeaf(currentNode)) {
          currentNode = null;
          return currentNode;
        } else if (hasTwoChild(currentNode)) {
          T substituteValue = valueSubstitute(currentNode.getLeft());
          currentNode.setKey(substituteValue);
          currentNode.setLeft(removeNode(currentNode.getLeft(), substituteValue));
        } else if (hasOneChild(currentNode)) {
          if (currentNode.getLeft() == null) {
            return currentNode.getRight();
          } else if (currentNode.getRight() == null) {
            return currentNode.getLeft();
          }
        }
      }
      return currentNode;
    }
    return null;
  }

  /*
   * private Node<T> removeNode(Node<T> currentNode, T value) {
   * if (containsKey(currentNode, value)){
   * if(currentNode.getKey().compareTo(value) == 1) {
   * currentNode.setLeft(removeNode(currentNode.getLeft(), value));
   * }else if(currentNode.getKey().compareTo(value) == -1) {
   * currentNode.setRight(removeNode(currentNode.getRight(), value));
   * }else{
   * if(isLeaf(currentNode)){
   * currentNode = null;
   * return currentNode;
   * } else if (hasTwoChild(currentNode)) {
   * T substituteValue = valueSubstitute(currentNode.getLeft());
   * currentNode.setKey(substituteValue);
   * currentNode.setLeft(removeNode(currentNode.getLeft(), substituteValue));
   * }
   * else if (hasOneChild(currentNode)) {
   * if (currentNode.getLeft() == null) {
   * return currentNode.getRight();
   * } else if (currentNode.getRight() == null) {
   * return currentNode.getLeft();
   * }
   * }
   * }
   * return currentNode;
   * }
   * return null;
   * }
   */

}
