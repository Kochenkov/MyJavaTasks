import java.io.IOException;
import java.util.Arrays;

import static algorithms.sorting.MergeSort.mergeSort;
import static algorithms.sorting.QuickSort.quickSort;

public class Main {

    public static void main(String[] args) throws IOException {

        int[] rr = new int[]{3,2,3,5,6,45,34,67,12,34,56,7,45,34,12,0};
//       badSort(rr);
//       selectionSort(rr);
       mergeSort(rr);
        System.out.println(Arrays.toString(rr));

    }
}
