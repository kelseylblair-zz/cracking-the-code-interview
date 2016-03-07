// cracking the coding interview, problem 3.5

import edu.princeton.cs.algs4.Stack;

public class MyQueue<Item> {
    
    private Stack<Item> left;
    private Stack<Item> right;

    public MyQueue() {
        left = new Stack<Item>();
        right = new Stack<Item>();
    }

    public void enqueue(Item item) {
            left.push(item);
    }

    public Item dequeue() {
        if (right.isEmpty())
            shift();
        return right.pop();
    }

    public boolean isEmpty(){
        if (left.isEmpty() && right.isEmpty())
            return true;
        return false;
    }
    
    // shifts the stack such that everything currently in left goes to right
    private void shift() {
        while(!left.isEmpty())
            right.push(left.pop());
    }

    public static void main(String args[]) {
        MyQueue<Integer> myqueue = new MyQueue<Integer>();

        for (int i = 0; i < 10; i++) 
            myqueue.enqueue(i);

        while(!myqueue.isEmpty()) 
            System.out.println(myqueue.dequeue());
    }

}