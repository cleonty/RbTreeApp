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
public class RbTreeApp {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    AbstractRbTree<String, String> tree1 = new LeftRbTree();
    AbstractRbTree<String, String> tree2 = new RbTree();
    String data[] = {"A", "S", "E", "A", "R", "C", "H", "I", "N", "G", "X", "L", "M", "N", "O", "P", "Q"};
//    for (String s : data) {
//      tree1.insert(s, s);
//      tree1.print();
//    }
    for (String s : data) {
      tree2.insert(s, s);
      tree2.print();
    }
  }

}
