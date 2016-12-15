// includes a static method reverse() that reverses the order of the bits in 
// a long (32-bit unsigned int) such that the result is a mirror of the original
// (i.e. 00000000000000000000000000000111 becomes 11100000000000000000000000000000)
// and returns the long (numerical) representation of the bitwise result

public class BitReverser {
    public static long reverse(long a) {
        long b = 0;
        long right = 1;
        long left = 1;
        left <<= 31;

        while (left != right) {
            if ((a & right) == right) {
                b = b ^ left;
            }
            right <<= 1;
            left >>= 1;
        }
        return b;
    }   

    public static void main(String[] args){
        long b = 18000000;
        System.out.println(reverse(b));
        System.out.println(reverse(reverse(b)));
    }
}