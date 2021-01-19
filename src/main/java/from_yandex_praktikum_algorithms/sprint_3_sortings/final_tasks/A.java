package from_yandex_praktikum_algorithms.sprint_3_sortings.final_tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Посылка: 46319992
 * Выполнил: Коченков Владислав
 *
 * -- ПРИНЦИП РАБОТЫ --
 * Для решения данной задачи (поиск в отсортированном массиве со сдвигом) использую модификацию бинарного поиска.
 * В функцию binarySearch() передается значение исходного массива, значение когорое необходимо найти, и ганицы поиска.
 * Далее, функция проверяет на каком участке массива находится искомый элемент и рекурсивно вызывает саму себя с новыми значениями границ.
 * Базовый случай рекурсии - когда левая граница равна правой.
 *
 * -- КОРРЕКТНОСТЬ РАБОТЫ --
 * Основная сложность данной задачи в том, что беря какую-то центральную точку, одна часть массива может быть не отсортирована (имеет точку перегиба).
 * Достаточно много времени ушло на понимание того, в каких именно частях массива нужно искать значение при рахных условиях.
 * На всех заданных тестах функция работает корректно.
 *
 * -- ВРЕМЕННАЯ СЛОЖНОСТЬ --
 * Алгоритм работает за O (log n), тк используется модификация бинарного поиска.
 */
public class A {

    public static void main(String[] args) throws IOException {
        final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        final int size = Integer.parseInt(in.readLine().split(" ")[0]);
        final int findValue = Integer.parseInt(in.readLine().split(" ")[0]);
        final String[] arr = in.readLine().split(" ");
        in.close();

        final int[] intArr = new int[size];
        for (int i = 0; i < size; i++) {
            intArr[i] = Integer.parseInt(arr[i]);
        }

        final int answer = binarySearch(intArr, findValue, 0, intArr.length-1);

        System.out.println(answer);
    }

    private static int binarySearch(int arr[], int x, int left, int right) {
        final int mid = (left + right) / 2;

        if (x == arr[mid]) {
            return mid;
        }

        if (left==right) {
            if (arr[left]==x) {
                return left;
            } else {
                return -1;
            }
        }

        if (arr[left] <= arr[mid]) {
            if (x >= arr[left] && x < arr[mid]) {
                return binarySearch(arr, x, left, mid - 1);
            } else {
                return binarySearch(arr, x,mid + 1, right);
            }
        } else  {
            if (x > arr[mid] && x <= arr[right]) {
                return binarySearch(arr, x,mid + 1, right);
            } else {
                return binarySearch(arr, x, left, mid - 1);
            }
        }
    }
}