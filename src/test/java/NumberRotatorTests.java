import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NumberRotatorTests {
    private static void testing(long actual, long expected) {
        assertEquals(expected, actual);
    }
    @Test
    public void test() {
        testing(NumberRotator.rotate(38458215L), 85821534L);
        testing(NumberRotator.rotate(195881031L), 988103115L);
        testing(NumberRotator.rotate(9896219342L), 9896219342L);
        testing(NumberRotator.rotate(69418307L), 94183076L);
        testing(NumberRotator.rotate(56789L), 68957L);
        testing(NumberRotator.rotate(-56789L), -56789L);
        testing(NumberRotator.rotate(-1123456L), -1123456L);
      //  testing(NumberRotator.rotate(null), null);

    }
}
