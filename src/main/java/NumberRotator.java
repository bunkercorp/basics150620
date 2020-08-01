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

     private static char[] shift(char[] ch, int begIndex,int endIndex) {
         for (int i = begIndex; i < endIndex; i++) {
// напомню ,что массивы - это ссылочные сущности. В таких условиях, изменять входной агрумент может быть очень плохой идеей, так как он может использоваться где-нибудь еще.
             ch[i] = ch[i+1];
         }
         return ch;
     }
      private static String toString(char[] ch){
         StringBuilder sb = new StringBuilder();

         for (int i = 0; i < ch.length; i++) {
             sb.append(ch[i]);
         }
         String str = sb.toString();
         return str;
     }

   public static long rotate (long n) {
       long max = 0;
       String number = String.valueOf(n);
       // магические числа вижу я
       long [] value = new long[4];
       char[] ch = new char[number.length()];
       for (int i = 0; i < number.length(); i++) {
           ch[i] = number.charAt(i);
       }
    // вижу копипаст. почему не циклом?
       char prom = ch[0];
       shift(ch,0,ch.length -1);
       ch[ch.length -1] = prom;
       value[0] = Long.valueOf(toString(ch));
       System.out.println(value[0]);

       prom = ch[1];
       shift(ch,1,ch.length -1);
       ch[ch.length -1] = prom;
       value[1] = Long.valueOf(toString(ch));
       System.out.println(value[1]);

       prom = ch[2];
       shift(ch,2,ch.length -1);
       ch[ch.length -1] = prom;
       value[2] = Long.valueOf(toString(ch));
       System.out.println(value[2]);

       prom = ch[3];
       shift(ch,3,ch.length -1);
       ch[ch.length -1] = prom;
       value[3] = Long.valueOf(toString(ch));
       System.out.println(value[3]);

       for(int i =0; i < 4; i++){
           if(value[i]> max)
               max = value[i];
       }

       return max;
    }

    public static void main (String[] args) {
       System.out.println("Max value = " + rotate(45679L));
    }
}
