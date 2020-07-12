
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
    public static void main(String[] args) {
        System.out.println(toJadenCase("hello world"));
    }
    public static String toJadenCase(String phrase) {
        if ( phrase == null || phrase.length() <= 0 )
            return null;
        final StringBuilder resStr = new StringBuilder();

        final char firstChar = phrase.charAt(0);
        final boolean isFirstAlpha = (firstChar >= 'a' && firstChar <= 'z' );
        if (isFirstAlpha) {
            char upperFirst = Character.toUpperCase(firstChar);
            resStr.append(upperFirst);
        }else {
            resStr.append(firstChar);
        }

        for (int i = 1 ; i < phrase.length(); i++) {
            final char candidate = phrase.charAt(i);
            final char beforeCandidate = phrase.charAt(i - 1);
            final boolean isLowerAlpha =  (candidate >= 'a' && candidate <= 'z' );
            final boolean isBeforeWordChar = (beforeCandidate >= 'A' && beforeCandidate <= 'Z') || (beforeCandidate >= 'a' && beforeCandidate <= 'z' ) || beforeCandidate=='`' || beforeCandidate== '_' || beforeCandidate=='-' || (beforeCandidate >='0' && beforeCandidate<= '9');
            if ( isLowerAlpha && !isBeforeWordChar) {
                char upperCandidate = Character.toUpperCase(candidate);
                resStr.append(upperCandidate);
            } else {
                resStr.append(candidate);
            }
        }
        return resStr.toString();
    }
}
