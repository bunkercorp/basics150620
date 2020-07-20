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

    public static long rotate(long n) {
        String nS = Long.toString(n);
        int l = nS.length();
        char numAr[] = new char[l];
        for (int i = 0; i < l; i++) {
            char currentChar = nS.charAt(i);
            numAr[i] = currentChar;
        }
        String[] result = new String[l + 1];
        result[0] = nS;
        long maxResult = 0;
        for (int k = 0; k < l; k++) {
            String firstPart = "";
            String secondPart = "";
            for (int j = 0; j < l; j++) {
                if (k == 0) {
                    if (j == k) {
                        firstPart = firstPart + result[k].charAt(j);
                    } else {

                        secondPart = secondPart + result[k].charAt(j);
                    }
                } else if ((k > 0 )&& (k<l-1)){
                    if (j == k) {
                        secondPart = secondPart + result[k].charAt(j);
                    } else {
                        firstPart = firstPart + result[k].charAt(j);
                    }
                }else {
                    continue;
                }
            }
            if (k == 0) {
                result[k + 1] = secondPart + firstPart;
            } else {
                result[k + 1] = firstPart + secondPart;
            }
            if( k<l-1 && Integer.parseInt(result[k + 1]) > maxResult){
                maxResult = Integer.parseInt(result[k + 1]);
            }
        }
        return maxResult;
    }

}
