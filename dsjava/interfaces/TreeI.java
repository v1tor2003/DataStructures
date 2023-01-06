package dsjava.interfaces;

import dsjava.tree.TreeBS.Node;

public interface TreeI<T extends Comparable<T>> {
  @Override
  String toString();
  boolean isEmpty();
  boolean search(T data);
  void insert(T data);
  void traverse();
  void inOrder(Node<T> root);
  void postOrder(Node<T> root);
  void preOrder(Node<T> root);
  T remove();
}
