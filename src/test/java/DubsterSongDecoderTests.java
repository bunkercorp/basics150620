import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DubsterSongDecoderTests {
    @Test
    public void test1() {
        assertEquals("ABC TT", Dubster.songDecoder("WUBWUBABCWUBWUBTTWUBWUBWUB"));
    }

    @Test
    public void test2() {
        assertEquals("R L", Dubster.songDecoder("RWUBWUBWUBLWUB"));
    }
    @Test
    public void test21() {
        assertEquals("RADIO LITE", Dubster.songDecoder("RADIOWUBWUBWUBLITEWUB"));
    }

    @Test
    public void test3() {
        assertEquals("", Dubster.songDecoder("WUBWUBWUB"));
    }

    @Test
    public void test31() {
        assertEquals("", Dubster.songDecoder(""));
    }

    @Test
    public void test4() {
        assertEquals("", Dubster.songDecoder(""));
    }

    @Test
    public void test5() {assertEquals("", Dubster.songDecoder("aWUBWUBWUB"));}

    @Test
    public void test6() {assertEquals("", Dubster.songDecoder("WWWWKJKNKJDSFKJVDSWUBWUBWUBFVSDFKVDSJFVSNFKJDSFVSFDVNJFDSKVDSNVJFDSNVDSKFJVNDSFWUDFSNVJFDSNVDSKFJVNDSFWUDFSNVJFDSNVDSKFJVNDSFWUDFSNVJFDSNVDSKFJVNDSFWUDFGGGERGWREGWREGWREGIYUITYEBWUBWUBGERWRGWREGWREGYHYE"));}

    @Test
    public void test7() {assertEquals("", Dubster.songDecoder("aWUBWUBWUB"));}
    @Test
    public void test8() {assertEquals("", Dubster.songDecoder(null));}
}
