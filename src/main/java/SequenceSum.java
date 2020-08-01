/*

Description:
We want to generate a function that computes the series starting from 0 and ending until the given number following the sequence:
0 1 3 6 10 15 21 28 36 45 55 ....
which is created by
0, 0+1, 0+1+2, 0+1+2+3, 0+1+2+3+4, 0+1+2+3+4+5, 0+1+2+3+4+5+6, 0+1+2+3+4+5+6+7 etc..

Input: LastNumber
Output: series and result

Example:

Input: 6
Output: 0+1+2+3+4+5+6 = 21

Input: -15
Output: -15 < 0

Input: > 0
Output: 0 = 0

*/

public class SequenceSum {
    //static String?
    public void showSequence(int value) {
        if (value == 0) {
            // эта ситуация обрабатывается в твоем цикле
            System.out.print("0 = 0");
        } else if (value < 0) {
            // "" лишнее
            System.out.print("" + value + " < 0");
        } else {
            int result = 0;
            String resultS = "";
            for (int i = 0; i <= value; i++) {
                if (i==0){
                    resultS += ""+i;
                }else{
                    resultS += "+" + i;
                    result += i;
                }
            }
            System.out.print(resultS + " = " + result);
        }
    }
}
