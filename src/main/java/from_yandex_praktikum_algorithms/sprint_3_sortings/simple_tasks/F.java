package from_yandex_praktikum_algorithms.sprint_3_sortings.simple_tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class F {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(in.readLine()
                                      .split(" ")[0]);
        String[] arr = in.readLine()
                         .split(" ");
        in.close();
        int[] intArr = new int[size];
        for (int i = 0; i < size; i++) {
            intArr[i] = Integer.parseInt(arr[i]);
        }

        Arrays.sort(intArr);
        //log
        //System.out.println(Arrays.toString(intArr));

        for (int i = intArr.length - 1; i >= 2; i--) {
            int a = intArr[i];
            int b = intArr[i - 1];
            int c = intArr[i - 2];

            if ((a < (b + c)) && (b < (a + c)) && (c < (a + b))) {
                System.out.println(a + b + c);
                break;
            }
        }
    }

}
