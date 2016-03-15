// cracking the coding interview problem 2.5

import java.util.LinkedList;

public class LinkedListAdder {

    private int total;

    public LinkedListAdder(LinkedList<Integer> a, LinkedList<Integer> b) {
        total = 0;
        int numDigits = 0;
        int sum = 0;
        for (int i = 0; i < a.size() && i < b.size(); i++) {
            sum = a.get(i) + b.get(i);
            total += sum * power(10, i);
            numDigits++;
        }
        if (a.size() != b.size())
            if(a.size() < b.size()) {
                for (int i = numDigits; i < b.size(); i++) {
                    sum = b.get(i);
                    total += sum * power(10, i);
                }
            } else {
                for (int i = numDigits; i < a.size(); i++) {
                    sum = a.get(i);
                    total += sum * power(10, i);
                }
            }
    }

    public int sum() {
        return total;
    }

    // helper method to perform a raised to the power of b
    private static int power(int a, int b) {
        int answer = 1;
        for (int i = 0; i < b; i++)
            answer *= a;
        return answer;
    }

    public static void main(String args[]) {
        LinkedList<Integer> x = new LinkedList<Integer>();
        for(int i = 0; i < 6; i++) 
            x.add(i);

        LinkedList<Integer> y = new LinkedList<Integer>();
        for(int i = 1; i < 7; i++)
            y.add(i);

        LinkedListAdder add = new LinkedListAdder(x, y);
        System.out.println(add.sum());
    }
}