package from_codewars;

import org.junit.Test;

import static org.junit.Assert.*;

public class FindUniqTest {
    private double precision = 0.0000000000001;

    @Test
    public void findUniq() {
        assertEquals(1.0, FindUniq.findUniqNumber(new double[]{0, 1, 0}), precision);
        assertEquals(2.0, FindUniq.findUniqNumber(new double[]{1, 1, 1, 2,3,3, 1, 1}), precision);
    }
}