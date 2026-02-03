package javaCollection;
import java.util.*;
public class stackDemo {
    public static void main(String[] args) {
        Stack<Integer> myStack = new Stack<>();
        myStack.push(10);
        myStack.push(20);
        myStack.push(40);
        System.out.println("The size is: " +myStack.size());
        System.out.println("The top element: "+myStack.peek());
    }
}