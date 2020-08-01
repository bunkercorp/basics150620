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


      private static boolean readableCharacter(char ch) {
          return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z');
      }

      private static boolean unreadableCharacter(char ch) {
          return ch == ' ' || ch == ',' || ch == '.' || ch == ';' || ch == ':' || ch == '/';
      }

      public static String[] splitToWords(String str) {
          char ch;
          char nextch;
          int begIndex = 0;
          int wordCount = 0;
          if (str == null) {
              System.out.println("String = null");
              return new String[0];
          } else {
              int length = str.length();
              String[] word = new String[length];

              if (length == 0) {
                  System.out.println("Length is 0");
                  return new String[0];
              }
              ch = str.charAt(0);
              if ((length == 1) && (readableCharacter(ch))) {
                  word[wordCount] = String.valueOf(ch);
                  wordCount++;
                  return word;
              }

              for (int j = 0; j < length - 1; j++) {
                  ch = str.charAt(j);
                  nextch = str.charAt(j + 1);

                  if ((j + 2 == length) && readableCharacter(nextch)) {
                      word[wordCount] = str.substring(begIndex, j + 2);
                      wordCount++;

                  }
                  if (readableCharacter(ch) && unreadableCharacter(nextch)) {
                      word[wordCount] = str.substring(begIndex, j + 1);
                      wordCount++;
                      begIndex = j + 2;
                  }
                  if (unreadableCharacter(ch) && readableCharacter(nextch)) {
                      begIndex = j + 1;
                  }
              }

              String [] result = new String[wordCount];
              for (int i=0; i<wordCount; i++){
                  result[i] = word[i];
              }
              return result;
          }
      }
      public static String wordsUp (String str){
          String [] words = splitToWords(str);
          String[] upword = new String[words.length];
          for (int i = 0; i < words.length; i++){
              upword[i] = words[i].substring(0,1).toUpperCase() + words[i].substring(1);
          }
          StringBuilder stringBuilder = new StringBuilder();
          for (int i = 0; i < upword.length; i++) {
              stringBuilder.append(upword[i]).append(' ');
          }
          String result = stringBuilder.toString();
          return result ;
      }

      public static String toJadenCase(String phrase) {
      String result = " ";
      if((phrase == null) || (phrase.length() == 0)) {
          return null;
      }
      else {
          result = wordsUp(phrase);
      }
        return result;
    }

    public static void main (String[] args) {
      System.out.println(toJadenCase("toJadenCase doesn't return a valide JadenCase String! try again please :)"));
      System.out.println(toJadenCase(""));
      System.out.println(toJadenCase( null));
        // твой код добавляет пробел в конец фразы. Его там быть не должно.
      System.out.printf("\"%s\"", toJadenCase("most trees are blue"));
    }


}
