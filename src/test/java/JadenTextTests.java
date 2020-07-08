import org.junit.Test;

import static org.junit.Assert.*;

public class JadenTextTests {

    @Test
    public void test() {
        assertEquals("Try again", JadenCase.toJadenCase("most trees are blue"), "Most Trees Are Blue");
    }

    @Test
    public void testNullArg() {
        assertNull("Must return null when the arg is null", JadenCase.toJadenCase(null));
    }

    @Test
    public void testEmptyArg() {
        assertNull("Must return null when the arg is null", JadenCase.toJadenCase(""));
    }

    @Test
    public void test1() {
        assertEquals("Try again", JadenCase.toJadenCase(" most trees are blue"), " Most Trees Are Blue");
    }
    @Test
    public void test2() {
        assertEquals("Try again", JadenCase.toJadenCase("most,trees are blue"), "Most,Trees Are Blue");
    }
    @Test
    public void test3() {
        assertEquals("Try again", JadenCase.toJadenCase("most  trees are blue"), "Most  Trees Are Blue");
    }
    @Test
    public void test4() {
        assertEquals("Try again", JadenCase.toJadenCase("most trees-are blue"), "Most Trees-are Blue");
    }
    @Test
    public void test5() {
        assertEquals("Try again", JadenCase.toJadenCase("most_trees_are_blue"), "Most_trees_are_blue");
    }
    @Test
    public void test6() {
        assertEquals("Try again", JadenCase.toJadenCase("most tree`s are blue"), "Most Tree`s Are Blue");
    }
    @Test
    public void test7() {
        assertEquals("Try again", JadenCase.toJadenCase("';;'//"), "';;'//");
    }
    @Test
    public void test8() {
        assertEquals("Try again", JadenCase.toJadenCase("1a e';-_; 11  11  awer2'//"), "1a E';-_; 11  11  Awer2'//");
    }
    @Test
    public void test9() {
        assertEquals("Try again", JadenCase.toJadenCase("1a e';-_; 11  11  awer2'//  23mo1s2t t3ree`s are blue"), "1a E';-_; 11  11  Awer2'//  23mo1s2t T3ree`s Are Blue");
    }



}
