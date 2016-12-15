// creates a static method findCycle() that identifies the Node in a linked list
// that is the pivot of a loop (i.e. 1 -> 2 -> 3 -> 4 -> 2 -> 3 -> 4 yields 2).

import java.util.HashSet;

public class ListCycle {
    private static class Node {
        private Node next;
        private int value;

        public Node(Node node, int val) {
            next = node;
            value = val;
        }

        public String toString() {
            return "" + value;
        }

        public Node next(){
            return next;
        }

        public int value() {
            return value;
        }
    }   

    public static Node findCycle(Node a) {
        Node current = a;
        HashSet<Node> set = new HashSet<Node>();
        while(current.next() != null) {
            // if we have already seen and added to the set the next Node to which
            // this node points, then the next node is the pivot in the cycle
            if (set.contains(current.next())){
                return current.next();
            }
            // otherwise, add the next node and continue iterating through the list
            else {
                set.add(current.next());
                current = current.next();
            }
        }
        return null; //if there is no cycle in the list, returns null
    }

    public static void main(String[] args) {
        Node loop = new Node(null, 10);
        Node previous = loop;
        Node current;
        for (int i = 9; i > 5; i--) {
            current = new Node(previous, i);
            previous = current;
        }
        loop.next = previous;
        System.out.println(loop.next);
        for (int i = 5; i > 0; i--) {
            current = new Node(previous, i);
            previous = current;
        }
        System.out.println(findCycle(previous));
    }
}