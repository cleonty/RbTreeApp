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
class Node<Key extends Comparable<Key>, Value> {

  public static final boolean RED = true;
  public static final boolean BLACK = false;

  Key key;
  Value val;
  Node left;
  Node right;
  boolean color;

  public Node(Key key, Value val, boolean color) {
    this.key = key;
    this.val = val;
    this.color = color;
    System.out.println("new node " + key + " color " + color);
  }

  private void printColorChange() {
    System.out.println(this.key + " color " + (this.color ? "RED - > BLACK" : "BLACK - > RED"));
  }

  public void flipColor() {
    printColorChange();
    this.color = !this.color;
    this.left.printColorChange();
    this.left.color = !this.left.color;
    this.right.printColorChange();
    this.right.color = !this.right.color;
  }

  public static boolean isRed(Node node) {
    return node != null && node.color;
  }

  public Node rotateLeft() {
    System.out.println("rotate left " + this.key);
    Node x = this.right;
    this.right = x.left;
    x.left = this;
    x.color = this.color;
    this.color = RED;
    return x;
  }

  public Node rotateRight() {
    System.out.println("rotate right " + this.key);
    Node x = this.left;
    this.left = x.right;
    x.right = this;
    x.color = this.color;
    this.color = RED;
    return x;
  }

}
