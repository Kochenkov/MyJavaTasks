package from_yandex_praktikum_algorithms.sprint_3.simple_tasks;

import java.util.Arrays;

//Гоше дали задание написать красивую сортировку слиянием. Поэтому Гоше обязательно надо реализовать отдельно функцию merge и функцию merge_sort.
//        Функция merge принимает два отсортированных массива, сливает их в один отсортированный массив и возвращает его.
//        Функция merge_sort принимает некоторый подмассив, который нужно отсортировать. Подмассив задаётся полуинтервалом —
//        его началом и концом. Функция должна отсортировать передаваемый в неё подмассив, она ничего не возвращает.
//        Функция merge_sort разбивает полуинтервал на две половинки и рекурсивно вызывает сортировку отдельно для каждой.
//        Затем два отсортированных массива сливаются в один с помощью merge.
//        Заметьте, что в функции передаются именно полуинтервалы


public class Solution {
    public static int[] merge(int[] arr, int left, int mid, int right) {
       return new int[0];
    }

    public static void merge_sort(int[] arr, int left, int right) {

    }
}

//    public static void mergeSort(int[] input) {
//        //условие не базового случая рекурсии
//        if (input.length>1) {
//
//            int leftSize = input.length/2;
//
//            int[] leftArr = Arrays.copyOfRange(input, 0, leftSize);
//            int[] rightArr = Arrays.copyOfRange(input, leftSize, input.length);
//
//            //log
//            //System.out.println(Arrays.toString(leftArr));
//            //System.out.println(Arrays.toString(rightArr));
//
//            mergeSort(leftArr);
//            mergeSort(rightArr);
//
//            merge(input, leftArr, rightArr);
//        }
//    }
//
//    private static void merge(int[] input, int[] firstArr, int[] secondArr) {
//        int firstIndex = 0;
//        int secondIndex = 0;
//        int targetIndex = 0;
//
//        while (targetIndex<input.length) {
//            //если первый индекс больше, чем массив, то копируем все оставшиеся элементы из второго массива
//            if (firstIndex >= firstArr.length) {
//                input[targetIndex] = secondArr[secondIndex];
//                secondIndex++;
//            }
//            //если второй индекс больше, чем массив, то копируем все оставшиеся элементы из первого массива
//            else if (secondIndex >=secondArr.length) {
//                input[targetIndex] = firstArr[firstIndex];
//                firstIndex++;
//            }
//            //если элемент в первом массиве больше чем во втором, то копиируем элемент из второго массива
//            else if (firstArr[firstIndex] >= secondArr[secondIndex]) {
//                input[targetIndex] = secondArr[secondIndex];
//                secondIndex++;
//            }
//            //если элемент во втором массиве больше чем в первом, то копиируем элемент из первого массива
//            else {
//                input[targetIndex] = firstArr[firstIndex];
//                firstIndex++;
//            }
//            targetIndex++;
//        }
//    }

