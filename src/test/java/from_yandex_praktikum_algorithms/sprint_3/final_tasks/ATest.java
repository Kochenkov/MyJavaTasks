package from_yandex_praktikum_algorithms.sprint_3.final_tasks;

import org.junit.Test;

import static from_yandex_praktikum_algorithms.sprint_3.final_tasks.A.binarySearch;
import static org.junit.Assert.*;

public class ATest {

    @Test
    public void test1() {
        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7};
        assertEquals(3, binarySearch(arr, 3,0,arr.length-1));
    }

    @Test
    public void test2() {
        int[] arr = {4, 5, 6, 7, 1, 2, 3};
        assertEquals(6, binarySearch(arr, 3,0,arr.length-1));
    }

    @Test
    public void test3() {
        int[] arr = {7, 1, 2, 3, 4, 5, 6};
        assertEquals(0, binarySearch(arr, 7,0,arr.length-1));
    }

    @Test
    public void test4() {
        int[] arr = {2, 3, 4, 5, 6, 7, 8, 1};
        assertEquals(7, binarySearch(arr, 1,0,arr.length-1));
    }

    @Test
    public void test5() {
        int[] arr = {2, 3, 4, 5, 6, 7, 8, 1};
        assertEquals(0, binarySearch(arr, 2,0,arr.length-1));
    }

    @Test
    public void test6() {
        int[] arr = {1,2,3,4,5,6,7,8};
        assertEquals(4, binarySearch(arr, 5,0,arr.length-1));
    }

    @Test
    public void test7() {
        int[] arr = {1,2};
        assertEquals(1, binarySearch(arr, 2,0,arr.length-1));
    }

    @Test
    public void test8() {
        int[] arr = {1,2};
        assertEquals(0, binarySearch(arr, 1,0,arr.length-1));
    }

    @Test
    public void test9() {
        int[] arr = {1,2,3};
        assertEquals(1, binarySearch(arr, 2,0,arr.length-1));
    }

    @Test
    public void test10() {
        int[] arr = {3,1,2};
        assertEquals(2, binarySearch(arr, 2,0,arr.length-1));
    }

    @Test
    public void test11() {
        int[] arr = {3,1,2};
        assertEquals(0, binarySearch(arr, 3,0,arr.length-1));
    }

    @Test
    public void test12() {
        int[] arr = {2,1};
        assertEquals(1, binarySearch(arr, 1,0,arr.length-1));
    }

    @Test
    public void test13() {
        int[] arr = {2,1};
        assertEquals(0, binarySearch(arr, 2,0,arr.length-1));
    }

    @Test
    public void test14() {
        int[] arr = {4,1,2,3};
        assertEquals(2, binarySearch(arr, 2,0,arr.length-1));
    }
    @Test
    public void test15() {
        int[] arr = {4,1,2,3};
        assertEquals(0, binarySearch(arr, 4,0,arr.length-1));
    }

    @Test
    public void test16() {
        int[] arr = {4,1,2,3};
        assertEquals(3, binarySearch(arr, 3,0,arr.length-1));
    }

    @Test
    public void test17() {
        int[] arr = {4,1,2,3};
        assertEquals(-1, binarySearch(arr, 5,0,arr.length-1));
    }

    @Test
    public void test18() {
        int[] arr = {4,1,2,3};
        assertEquals(-1, binarySearch(arr, 0,0,arr.length-1));
    }

    @Test
    public void test20() {
        int[] arr = {1};
        assertEquals(0, binarySearch(arr, 1,0,arr.length-1));
    }

    @Test
    public void test21() {
        int[] arr = {1};
        assertEquals(-1, binarySearch(arr, 2,0,arr.length-1));
    }

    @Test
    public void test22() {
        int[] arr = {};
        assertEquals(-1, binarySearch(arr, 1,0,arr.length-1));
    }

    @Test
    public void test23() {
        int[] arr = {7,8,9,1,2,3,4,5,6};
        assertEquals(3, binarySearch(arr, 1,0,arr.length-1));
    }

    @Test
    public void test24() {
        int[] arr = {7,8,9,1,2,3,4,5,6};
        assertEquals(7, binarySearch(arr, 5,0,arr.length-1));
    }

    @Test
    public void test25() {
        int[] arr = {7,8,9,1,2,3,4,5,6};
        assertEquals(1, binarySearch(arr, 8,0,arr.length-1));
    }
}