package algorithms.sorting;

import java.util.Arrays;

public class MergeSort {

    public static void mergeSort(int[] input) {
        //условие не базового случая рекурсии
        if (input.length>1) {

            int leftSize = input.length/2;

            int[] leftArr = Arrays.copyOfRange(input, 0, leftSize);
            int[] rightArr = Arrays.copyOfRange(input, leftSize, input.length);

            //log
            //System.out.println(Arrays.toString(leftArr));
            //System.out.println(Arrays.toString(rightArr));

            mergeSort(leftArr);
            mergeSort(rightArr);

            merge(input, leftArr, rightArr);
        }
    }

    private static void merge(int[] input, int[] firstArr, int[] secondArr) {
        int firstIndex = 0;
        int secondIndex = 0;
        int targetIndex = 0;

        while (targetIndex<input.length) {
            //если первый индекс больше, чем массив, то копируем все оставшиеся элементы из второго массива
            if (firstIndex >= firstArr.length) {
                input[targetIndex] = secondArr[secondIndex];
                secondIndex++;
            }
            //если второй индекс больше, чем массив, то копируем все оставшиеся элементы из первого массива
            else if (secondIndex >=secondArr.length) {
                input[targetIndex] = firstArr[firstIndex];
                firstIndex++;
            }
            //если элемент в первом массиве больше чем во втором, то копиируем элемент из второго массива
            else if (firstArr[firstIndex] >= secondArr[secondIndex]) {
                input[targetIndex] = secondArr[secondIndex];
                secondIndex++;
            }
            //если элемент во втором массиве больше чем в первом, то копиируем элемент из первого массива
            else {
                input[targetIndex] = firstArr[firstIndex];
                firstIndex++;
            }
            targetIndex++;
        }
    }
}
