package algorithms.sorting;

import java.util.Arrays;

public class OtherSortings {

    public static void badSort(int[] input) {
        int counter = 0;
        long start = System.nanoTime();
        for (int i = 0; i < input.length; i++) {
            for (int j = i; j < input.length; j++) {
                counter++;
                if (input[j] < input[i]) {
                    int container = input[i];
                    input[i] = input[j];
                    input[j] = container;
                }
            }
        }
        long end = System.nanoTime();
        long result = end - start;
        System.out.println(Arrays.toString(input));
        System.out.println(" --- BAD SORT --- ");
        System.out.println(String.format("Time-performance is: %d millis", result));
        System.out.println(String.format("Number of running cycles is: %d", counter));
    }

    public static void bubbleSort(int[] input) {
        int counter = 0;
        long start = System.nanoTime();
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 1; i < input.length; i++) {
                counter++;
                if (input[i] < input[i - 1]) {
                    isSorted = false;
                    int container = input[i - 1];
                    input[i - 1] = input[i];
                    input[i] = container;
                }
            }
        }
        long end = System.nanoTime();
        long result = end - start;
        System.out.println(Arrays.toString(input));
        System.out.println(" --- BUBBLE SORT --- ");
        System.out.println(String.format("Time-performance is: %d millis", result));
        System.out.println(String.format("Number of running cycles is: %d", counter));
    }

    public static void selectionSort(int[] input) {
        int counter = 0;
        long start = System.nanoTime();
        boolean isSorted = false;
        int minValue = input[0];
        int minPosition = 0;
        int sortPos = 0;
        while (!isSorted) {
            isSorted = true;
            for (int i = sortPos; i < input.length; i++) {
                counter++;
                if (minValue>input[i]) {
                    minValue = input[i];
                    minPosition = i;
                }
            }
            sortPos+=1;
            input[minPosition] = input[sortPos];
            input[sortPos] = minValue;
        }
        long end = System.nanoTime();
        long result = end - start;
        System.out.println(Arrays.toString(input));
        System.out.println(" --- SELECTION SORT --- ");
        System.out.println(String.format("Time-performance is: %d millis", result));
        System.out.println(String.format("Number of running cycles is: %d", counter));
    }
}