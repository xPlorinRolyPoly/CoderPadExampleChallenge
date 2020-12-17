import java.io.*;
import java.util.*;

class LinkedList{
  
  private class Node{
    private int value;
    private Node next;
    
    Node(int value){
      this.value = value;
    }
  }

  private Node first;
  private Node last;
  private int size;
  
  public Node getLast(){
    System.out.println("Node Last value: " + this.last.value);
    System.out.println("Node Last next: " + this.last.next);
    return this.last;
  }
  
  public Node getFirst(){
    System.out.println("Node First value: " + this.first.value);
    System.out.println("Node First next: " + this.first.next);
    return this.first;
  }
  
  public void addFirst(int item){
    var node = new Node(item);
    if(this.isEmpty())
      this.first = this.last = node;
    else{
      node.next = this.first;
      this.first = node;
    }
    this.size++;
  }
  
  public void addLast(int item){
    var node = new Node(item);
    
    if(this.isEmpty())
      this.first = this.last = node;
    else {
      this.last.next = node;
      this.last = node;
    }
    this.size++;
  }
  
  public int indexOf(int item){
    int index = 0;
    var current = first;
    while(current != null){
      if(current.value == item) return index;
      current = current.next;
      index++;
    }
    return -1;
  }
  
  public boolean contains(int item){
    return this.indexOf(item) != -1;
  }
  
  public void removeFirst(){
    // [10 -> 20 -> 30] --> [20 -> 30]
    if (this.isEmpty()) throw new NoSuchElementException();
    if(this.first == this.last){
      this.first = this.last = null;
    } else {
      var second = first.next;
      this.first.next = null;
      this.first = second;
    }
    this.size--;
  }
  
  public void removeLast(){
    // [10 -> 20 -> 30] --> [10 -> 20]
    if(this.isEmpty()) throw new NoSuchElementException();
    if(this.first == this.last){
      this.first = this.last = null;
    } else {
      var previous = this.getPrevious(this.last);
      this.last = previous;
      this.last.next = null;
    }
    this.size--;
  }
  
  private Node getPrevious(Node node){
    var current = this.first;
    while(current != null){
      if(current.next == node) return current;
      current = current.next;
    }
    return null;
  }

  public int[] toArray(){
    int[] array = new int[this.size];
    var current = this.first;
    var index = 0;
    while (current != null) {
      array[index++] = current.value;
      current = current.next;
    }
    return array;
  }

  public void reverse(){
    // [10 -> 20 -> 30] --> [10 <- 20 <- 30]
    //  p      c     n  -->   n     c     p
    var previous = this.first;
    var current = this.first.next;
    while (current != null) {
      var next = current.next;
      current.next = previous;
      previous = current;
      current = next;
    }
  }
  
  private boolean isEmpty(){
    return first == null;
  }

  public int size(){ return this.size; }
}

class Solution {
  public static void main(String[] args) {
    var list = new LinkedList();
    list.addLast(10);
    list.addLast(20); list.addLast(30); list.addFirst(5);
    System.out.println(list.size());
    list.getFirst(); list.getLast();
    System.out.println(list.indexOf(5));
    System.out.println(list.indexOf(30));
    System.out.println(list.indexOf(50));
    System.out.println(list.contains(40));
    System.out.println(list.contains(10));
    var array = list.toArray();
    System.out.println(Arrays.toString(array));
    list.removeFirst();
    list.getFirst();
    list.removeLast();
    list.getLast();
    System.out.println(list.size());
  }
}
