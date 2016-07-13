/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rbtreeapp;

/**
 *
 * @author lchudinov
 * @param <Key>
 * @param <Value>
 */
public class RbTree<Key extends Comparable<Key>, Value> extends AbstractRbTree<Key, Value> {

  @Override
  public void insert(Key key, Value val) {
    root = insert(root, key, val, false);
    root.color = Node.BLACK;
  }

  private Node insert(Node<Key, Value> h, Key key, Value val, boolean right) {
    if (h == null) {
      return new Node(key, val, Node.RED);
    }
    if (Node.isRed(h.left) && Node.isRed(h.right)) {
      h.flipColor();
    }
    int cmp = key.compareTo(h.key);
    if (cmp == 0) {
      h.val = val;
    } else if (cmp < 0) {
      h.left = insert(h.left, key, val, LEFT);
      if (Node.isRed(h) && Node.isRed(h.left) && right) {
        h = h.rotateRight();
      }
      if (Node.isRed(h.left) && Node.isRed(h.left.left)) {
        h = h.rotateRight();
      }
    } else if (cmp > 0) {
      h.right = insert(h.right, key, val, RIGHT);
      if (Node.isRed(h) && Node.isRed(h.right) && !right) {
        h = h.rotateLeft();
      }
      if (Node.isRed(h.right) && Node.isRed(h.right.right)) {
        h = h.rotateLeft();
      }
    }
    return h;
  }
  
  private static final boolean LEFT = false;
  private static final boolean RIGHT = true;
}
