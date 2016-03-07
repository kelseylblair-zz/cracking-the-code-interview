import java.util.LinkedList;

public class LinkedListPivot {

    public static LinkedList<Character> pivot(LinkedList<Character> l, char c) {
        if (!l.contains(c)) {
            throw new IllegalArgumentException("that's not in the list");
        }

        LinkedList<Character> front = new LinkedList<Character>();
        LinkedList<Character> back = new LinkedList<Character>();

        for (int i = 0; i < l.size(); i++) {
            if (l.get(i) < l.get(l.indexOf(c)))
                front.add(l.get(i));
            else if (l.get(i) > l.get(l.lastIndexOf(c)))
                back.add(l.get(i));
        }

        for (int i = l.indexOf(c); i <= l.lastIndexOf(c); i++) {
            front.add(l.get(i));
        }
        front.addAll(back);
        return front;
    }

    public static void main(String args[]) {
        char[] test = {'k', 'j', 'i', 'h', 'g', 'f', 'e', 'd', 'c', 'b', 'a'};
        LinkedList<Character> testList = new LinkedList<Character>();
        for (int i = 0; i < test.length; i++)
            testList.add(test[i]);

        LinkedList<Character> list = new LinkedList<Character>(testList);

        System.out.println("pivoting on h...");
        System.out.println(pivot(list, 'h'));


        System.out.println("pivoting on c...");
        System.out.println(pivot(list, 'c'));
    }
}