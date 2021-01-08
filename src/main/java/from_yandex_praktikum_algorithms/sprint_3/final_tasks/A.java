package from_yandex_praktikum_algorithms.sprint_3.final_tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//решил!!!
//https://tproger.ru/problems/searching-element-in-array/
public class A {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(in.readLine()
                                      .split(" ")[0]);
        int findValue = Integer.parseInt(in.readLine()
                                           .split(" ")[0]);
        String[] arr = in.readLine()
                         .split(" ");
        in.close();
        int[] intArr = new int[size];
        for (int i = 0; i < size; i++) {
            intArr[i] = Integer.parseInt(arr[i]);
        }

        int answer = binarySearch(intArr, findValue, 0, intArr.length-1);

        System.out.println(answer);
    }

    public static int binarySearch(int arr[], int x, int left, int right) {
        int mid = (left + right) / 2;

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
