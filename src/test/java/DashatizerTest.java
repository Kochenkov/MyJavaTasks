import org.junit.Test;

import static org.junit.Assert.*;

public class DashatizerTest {

    @Test
    public void testBasic() {
        assertEquals("2-7-4", Dashatizer.dashatize(274));
        assertEquals("5-3-1-1", Dashatizer.dashatize(5311));
        assertEquals("86-3-20", Dashatizer.dashatize(86320));
        assertEquals("9-7-4-3-02", Dashatizer.dashatize(974302));
    }

    @Test
    public void testWeird() {
        assertEquals("0", Dashatizer.dashatize(0));
        assertEquals("1", Dashatizer.dashatize(-1));
        assertEquals("28-3-6-9", Dashatizer.dashatize(-28369));
    }

    @Test
    public void testEdgeCases() {
        assertEquals("2-1-4-7-48-3-64-7", Dashatizer.dashatize(Integer.MAX_VALUE));
        assertEquals("2-1-4-7-48-3-648", Dashatizer.dashatize(Integer.MIN_VALUE));
        assertEquals("1-1-1-1-1-1-1-1-1-1", Dashatizer.dashatize(-1111111111));
    }

}