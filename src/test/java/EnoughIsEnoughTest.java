import org.junit.Test;

import static org.junit.Assert.*;

public class EnoughIsEnoughTest {

    @Test
    public void test1() throws Exception {
        assertArrayEquals(
                new int[]{20, 37, 21},
                EnoughIsEnough.deleteNth(new int[]{20, 37, 20, 21}, 1)
        );
    }

    @Test
    public void test2() throws Exception {
        assertArrayEquals(
                new int[]{1, 2, 2, 2},
                EnoughIsEnough.deleteNth(new int[]{1, 2, 2, 2, 2}, 3)

        );
    }
    @Test
    public void test3() throws Exception {
        assertArrayEquals(
                new int[]{1, 2, 3, 1, 1, 2, 2, 3, 3, 4, 5},
                EnoughIsEnough.deleteNth(new int[]{1, 2, 3, 1, 1, 2, 1, 2, 3, 3, 2, 4, 5, 3, 1}, 3)
        );
        assertArrayEquals(
                new int[] { 1, 1, 1, 1, 1 },
                EnoughIsEnough.deleteNth( new int[] { 1, 1, 1, 1, 1 }, 5 )
        );
        assertArrayEquals(
                new int[] { },
                EnoughIsEnough.deleteNth( new int[] { }, 5 )
        );

    }
}