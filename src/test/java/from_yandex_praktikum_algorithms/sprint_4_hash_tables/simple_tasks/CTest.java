package from_yandex_praktikum_algorithms.sprint_4_hash_tables.simple_tasks;

import org.junit.Test;

import static from_yandex_praktikum_algorithms.sprint_4_hash_tables.simple_tasks.C.findHash;
import static org.junit.Assert.*;

public class CTest {

    @Test
    public void test() {
        char[] chArr = "abcdefgh".toCharArray();
        int[] intArr = {1, 5};
        assertEquals(98226219, findHash(1000, 1000000009, chArr, intArr));
    }

    @Test
    public void test2() {
        char[] chArr = "abcdefgh".toCharArray();
        int[] intArr = {5, 8};
        assertEquals(102102195, findHash(1000, 1000000009, chArr, intArr));
    }

    @Test
    public void test3() {
        char[] chArr = "a".toCharArray();
        int[] intArr = {1, 1};
        assertEquals(7, findHash(100, 10, chArr, intArr));
    }
}