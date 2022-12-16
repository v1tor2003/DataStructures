public class Tree<T> {
  public static class Node<T>{
    T info;
    Node<T> right;
    Node<T> left;

    Node(T info){
      this.info = info;
      this.right = null;
      this.left = null;
    }

    public boolean hasLeftChild(){
      return this.left != null;
    }

    public boolean hasRightChild(){
      return this.right != null;
    }

    public boolean isFather(){
      return hasLeftChild() || hasRightChild();
    }

    public boolean isLeaf(){
      return !hasLeftChild && !hasRightChild;
    }

    public boolean hasChildren(){
      return hasLeftChild() || hasRightChild();
    }

    public T getData(){
      return this.info;
    }
    
    public String toString(){
      return info;
    }
  }

  private Node<T> root;

  public Tree(){
    this.root = null;
  }

  public Node<T> createNode(T data){
    return new Node(T data);
  }

  public void insertNode(Node<T> newNode){
    if(this.root == null)
      this.root = newNode;
    
  }

  public void insertNode(T data){
    this.insertNode(createNode(data));
  }
}