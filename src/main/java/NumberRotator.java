/*

Take a number: 56789. Rotate left, you get 67895.
Keep the first digit in place and rotate left the other digits: 68957.
Keep the first two digits in place and rotate the other ones: 68579.
Keep the first three digits and rotate left the rest: 68597. Now it is over since keeping the first four it remains only one digit which rotated is itself.

You have the following sequence of numbers:
56789 -> 67895 -> 68957 -> 68579 -> 68597
and you must return the greatest: 68957.

Calling this function max_rot (or maxRot or ... depending on the language)
max_rot(56789) should return 68957

*/


public class NumberRotator {
    public static void main(String[] args) {
        System.out.println(rotate(56789));
    }

    public static long rotate(long n) {
        String s = Long.toString(n);
        for (int g = 0; g < s.length()-1; g++) {
           s = s.substring(0,g) + s.substring(g+1) + s.charAt(g) ;
           long b = Long.parseLong(s);
            if (b > n)  n = b;
            }return n;
    }
}
