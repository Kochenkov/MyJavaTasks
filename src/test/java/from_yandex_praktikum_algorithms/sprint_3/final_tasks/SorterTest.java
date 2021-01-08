package from_yandex_praktikum_algorithms.sprint_3.final_tasks;

import org.junit.Test;

public class SorterTest {

    ScholarSorter sorter = new ScholarSorter();

    @Test
    public void test() {
        Scholar[] arr = new Scholar[5];
        arr[0] = new Scholar("alla",4, 100);
        arr[1] = new Scholar("gena",6, 100);
        arr[2] = new Scholar("gosha",2, 90);
        arr[3] = new Scholar("rita",2, 90);
        arr[4] = new Scholar("tim",4, 80);

        sorter.quickSort(arr, 0, arr.length-1);

        for (int i=0; i<arr.length; i++) {
            System.out.println(arr[i].nick);
        }
    }
}