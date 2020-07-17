/*
Jaden Smith, the son of Will Smith, is the star of films such as The Karate Kid (2010) and After Earth (2013).
Jaden is also known for some of his philosophy that he delivers via Twitter.
When writing on Twitter, he is known for almost always capitalizing every word.

Your task is to convert strings to how they would be written by Jaden Smith.
The strings are actual quotes from Jaden Smith, but they are not capitalized in the same way he originally typed them.

Example:

Not Jaden-Cased: "How can mirrors be real if our eyes aren't real"
Jaden-Cased:     "How Can Mirrors Be Real If Our Eyes Aren't Real"

Note that the Java version expects a return value of null for an empty string or null.

*/
public class JadenCase {

    public static String toJadenCase(String phrase) {
        if (phrase == null || phrase == "") {
            return null;
        }
        String result = "";
        int l = phrase.length();
        char arrayOfChars[] = new char[l];
        char space = ' ';
        for (int i = 0; i < l; i++) {
            char currentChar = phrase.charAt(i);
            arrayOfChars[i] = currentChar;
            System.out.print(arrayOfChars[i]);
        }
        System.out.println();
        for (int i = 0; i < l; i++) {
            if (i == 0) {
                arrayOfChars[i] = Character.toUpperCase(arrayOfChars[i]);
            }
            if ((int) arrayOfChars[i] == (int) space) {
                arrayOfChars[i + 1] = Character.toUpperCase(arrayOfChars[i + 1]);
            }
            result += arrayOfChars[i];
        }
        return result;
    }
}
/*Капиталайз*/