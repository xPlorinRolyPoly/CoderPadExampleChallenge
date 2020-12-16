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
  }
  
  public void addLast(int item){
    var node = new Node(item);
    
    if(this.isEmpty())
      this.first = this.last = node;
    else {
      this.last.next = node;
      this.last = node;
    }
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
      return;
    }
    var second = first.next;
    this.first.next = null;
    this.first = second;
  }
  
  public void removeLast(){
    // [10 -> 20 -> 30] --> [10 -> 20]
    if(this.isEmpty()) throw new NoSuchElementException();
    if(this.first == this.last){
      this.first = this.last = null;
      return;
    }
    
    var previous = this.getPrevious(this.last);
    this.last = previous;
    this.last.next = null;
  }
  
  private Node getPrevious(Node node){
    var current = this.first;
    while(current != null){
      if(current.next == node) return current;
      current = current.next;
    }
    return null;
  }
  
  private boolean isEmpty(){
    return first == null;
  }
}

class Solution {
  public static void main(String[] args) {
    var list = new LinkedList();
    list.addLast(10);
    list.addLast(20); list.addLast(30); list.addFirst(5);
    list.getFirst(); list.getLast();
    System.out.println(list.indexOf(5));
    System.out.println(list.indexOf(30));
    System.out.println(list.indexOf(50));
    System.out.println(list.contains(40));
    System.out.println(list.contains(10));
    list.removeFirst();
    list.getFirst();
    list.removeLast();
    list.getLast();
  }
}
