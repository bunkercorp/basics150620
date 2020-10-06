package Homeworks.HW6;
/*

Polycarpus works as a DJ in the best Berland nightclub, and he often uses dubstep music in his performance.
Recently, he has decided to take a couple of old songs and make dubstep remixes from them.

Let's assume that a song consists of some number of words. To make the dubstep remix of this song,
Polycarpus inserts a certain number of words "WUB" before the first word of the song (the number may be zero),
after the last word (the number may be zero), and between words (at least one between any pair of neighbouring words),
and then the boy glues together all the words, including "WUB", in one string and plays the song at the club.

For example, a song with words "I AM X" can transform into a dubstep remix as "WUBWUBIWUBAMWUBWUBX"
and cannot transform into "WUBWUBIAMWUBX".

Recently, Jonny has heard Polycarpus's new dubstep track, but since he isn't into modern music,
he decided to find out what was the initial song that Polycarpus remixed. Help Jonny restore the original song.

Input
The input consists of a single non-empty string, consisting only of uppercase English letters, the string's length
doesn't exceed 200 characters

Output
Return the words of the initial song that Polycarpus used to make a dubsteb remix. Separate the words with a space.


*/

public class Dubster {
    public static void main(String[] args) {
        System.out.println(songDecoder("WUBWUBIWUBAMWUBWUBX"));
        System.out.println(songDecoder("WUBWUBABCWUB"));
        System.out.println(songDecoder("RWUBWUBWUBLWUB"));
        System.out.println(songDecoder("WUBWUBWUB"));
    }

    public static String songDecoder(String song) {
        String str = "WUB";
        int length = song.length();
        int beginIndex1 = 0;
        int beginIndex2 = 0;
        int beginWord = 0;
        int endWord = 0;
        boolean flag = false;
        String[] songW = new String[length];
        int currentLength = 0;
        int counter = 0;

        for (int i = 0; i < length; i++) {
            if (song.regionMatches(beginIndex1, str, beginIndex2, str.length())) {
                if (flag == true) {
                    endWord = beginIndex1;
                    songW[currentLength] = song.substring(beginWord, endWord);
                    currentLength++;
                    flag = false;
                    counter = 0;
                }
                beginIndex1 = beginIndex1 + 3;
            } else {
                if (counter == 0) {
                    beginWord = beginIndex1;
                }
                beginIndex1++;
                counter++;

                if (beginIndex1 == length) {
                    songW[currentLength] = song.substring(beginWord, beginIndex1);
                    currentLength++;
                }
                flag = true;
            }
        }
        StringBuilder songNew = new StringBuilder();
        for (int i = 0; i < songW.length; i++) {
            if ((songW[i] != null)) {
                if (songNew.length() == 0) {
                    songNew.append(songW[i]);
                } else {
                    songNew.append(' ').append(songW[i]);
                }
            }
        }
        String result = songNew.toString();
        return result;
    }
}