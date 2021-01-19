package from_yandex_praktikum_algorithms.sprint_3_sortings.simple_tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//Два велосипеда - рекурсивная задача на поиск элементов близких к заданному в отсортированном массиве
public class L {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(in.readLine()
                                        .split(" ")[0]);

        StringTokenizer stT = new StringTokenizer(in.readLine());
        int[] inArr = new int[length];

        for (int i=0; i<length; i++) {
            inArr[i] = Integer.parseInt(stT.nextToken());
        }


        int value = Integer.parseInt(in.readLine()
                                       .split(" ")[0]);
        in.close();

        int a1 = search(inArr, value, 0, inArr.length - 1);
        int a2;
        if (inArr.length>1) {
            a2 = search(inArr, value * 2, a1 + 1, inArr.length - 1);
        } else {
            a2 = -2;
        }

        System.out.println(String.format("%d %d", a1 + 1, a2 + 1));

    }

    private static int search(int[] arr, int value, int left, int right) {
        int mid = (left + right) / 2;
        int midElem = arr[mid];

        if (value > midElem) {
            if (right-left>5) {
                return search(arr, value, mid+1, right);
            } else {
                for (int i = mid; i < right+1; i++) {
                    if (arr[i] >= value) {
                        return i;
                    }
                }
            }
        } else {
            if (right-left>5) {
                return search(arr, value, left, mid-1);
            } else {
                for (int i = left; i < mid+1; i++) {
                    if (arr[i] >= value) {
                        return i;
                    }
                }
            }
        }
        return -2;
    }
}