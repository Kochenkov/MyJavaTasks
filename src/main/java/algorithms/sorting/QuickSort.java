package algorithms.sorting;

public class QuickSort {

    public static void quickSort(int[] input, int from, int to) {
        if (from<to) {
            int divideIndex = partition(input, from, to);
            quickSort(input, from, divideIndex-1);
            quickSort(input, divideIndex, to);
        }
    }

    private static int partition(int[] input, int from, int to) {
        int rightIndex = to;
        int leftIndex = from;

        int pivot = input[from + (to-from)/2];

        while (leftIndex <= rightIndex) {

            while (input[leftIndex]<pivot) {
                leftIndex++;
            }

            while (input[rightIndex]>pivot) {
                rightIndex--;
            }

            if (leftIndex<=rightIndex) {
                swap(input, leftIndex, rightIndex);
                leftIndex++;
                rightIndex--;
            }
        }
        return leftIndex;
    }

    private static void swap(int[] input, int index1, int index2) {
        int temp = input[index1];
        input[index1] = input[index2];
        input[index2] = temp;
    }
}