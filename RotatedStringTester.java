//cracking the coding interview, problem 1.8

public class RotatedStringTester {

    // tests whether s1 is a substring of s2
    private static boolean isSubString(String s1, String s2){
        return s2.contains(s1);
    } 

    public static boolean isRotation(String s1, String s2) {
        if (s1.length() == s2.length()) {
            String sCopy = s1 + s1;
            return isSubString(s2, sCopy);
        }
        else 
            return false;
    } 

    public static void main(String args[]) {
        String waterbottle = "waterbottle";
        String terbottlewa = "terbottlewa";
        String terbottleaw = "terbottleaw";
        String nothing = "nothing";


        System.out.println(isRotation(waterbottle, terbottlewa));
        System.out.println(isRotation(terbottlewa, waterbottle));
        System.out.println(isRotation(terbottlewa, terbottleaw));
        System.out.println(isRotation(waterbottle, nothing));
        System.out.println(isRotation(waterbottle, waterbottle));

    }
}