package from_yandex_praktikum_algorithms.sprint_3.final_tasks;

import org.junit.Test;

import java.util.Scanner;

import static org.junit.Assert.*;

public class ScholarTest {

    @Test
    public void test1() {
        Scholar sch1 = new Scholar("alla", 4, 100);
        Scholar sch2 = new Scholar("gena", 6, 1000);

        assertEquals(-1, sch1.compare(sch2));
        assertEquals(1, sch2.compare(sch1));
    }

    @Test
    public void test2() {
        Scholar sch1 = new Scholar("gosha", 2, 90);
        Scholar sch2 = new Scholar("rita", 2, 90);

        assertEquals(1, sch1.compare(sch2));
        assertEquals(-1, sch2.compare(sch1));
    }

    @Test
    public void test3() {
        Scholar sch1 = new Scholar("gosha", 2, 90);
        Scholar sch2 = new Scholar("goshb", 2, 90);

        assertEquals(1, sch1.compare(sch2));
        assertEquals(-1, sch2.compare(sch1));
    }

    @Test
    public void test4() {
        //предположим что так и должно быть
        Scholar sch1 = new Scholar("gosha", 2, 90);
        Scholar sch2 = new Scholar("gosha", 2, 90);

        assertEquals(1, sch1.compare(sch2));
        assertEquals(1, sch2.compare(sch1));
    }
}