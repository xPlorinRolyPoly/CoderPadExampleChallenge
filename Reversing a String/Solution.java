import java.io.*;
import java.util.*;

class StringReverser{
  public String reverse(String input){
    if(input == null)
      throw new IllegalArgumentException();
    Stack<Character> stack = new Stack<>();
    for(Character c:input.toCharArray())
      stack.push(c);
    StringBuffer reverse = new StringBuffer();
    while(!stack.isEmpty())
      reverse.append(stack.pop());
    return reverse.toString();
  }
}

class Solution {
  public static void main(String[] args) {
    String str = null;
    StringReverser r = new StringReverser();
    System.out.println(r.reverse(str));
  }
}
