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


import java.security.SecureRandom;

public class NumberRotator {

    public static long rotate (long n) {
       // не совсем согласен. ротация не имеет смысла не только при n=0, в принципе все одноразрядные значения так можно обработать
        if (n==0L)
        return 0;
        long max=n;
        long maxTemp;
        int sing = n<0 ? -1 :1;
        String strTemp=Long.toString(n*sing);

        char charToMoveEnd=strTemp.charAt(0);
        for (int i=0;i<strTemp.length();i++){
            StringBuilder sbRot=new StringBuilder();
            for (int j=0; j<strTemp.length();j++) {
                if (j != i) {
                    sbRot.append(strTemp.charAt(j));
                } else {
                    charToMoveEnd = strTemp.charAt(j); //if i==j this is char to move end
                }
            }
            sbRot.append(charToMoveEnd); //add char to end
            strTemp=sbRot.toString();
            maxTemp=Long.parseLong(strTemp)*sing;
            if (maxTemp>max)
                max = maxTemp;
        }
        return max;
    }

}
