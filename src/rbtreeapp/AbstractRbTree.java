/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rbtreeapp;

/**
 *
 * @author lchudinov
 */
public abstract class AbstractRbTree<Key extends Comparable<Key>, Value> {
  protected Node<Key, Value> root;

  public AbstractRbTree() {
  }

  public Value search(Key key) {
    Node<Key, Value> x = root;
    while (x != null) {
      int cmp = key.compareTo(x.key);
      if (cmp == 0) {
        return x.val;
      } else if (cmp < 0) {
        x = x.left;
      } else if (cmp > 0) {
        x = x.right;
      }
    }
    return null;
  }

  public abstract void insert(Key key, Value val);

  public void print() {
    System.out.println("digraph BST {");
    print(root);
    System.out.println("}");
  }

  protected void print(Node node) {
    if (node != null) {
      System.out.println("  " + node.key + " [color = " + (Node.isRed(node) ? "red" : "black") + "];");
      if (node.left != null) {
        System.out.println("  " + node.key + " -> " + node.left.key + ';');
        print(node.left);
      }
      if (node.right != null) {
        System.out.println("  " + node.key + " -> " + node.right.key + ';');
        print(node.right);
      }
    }
  }
  
}
