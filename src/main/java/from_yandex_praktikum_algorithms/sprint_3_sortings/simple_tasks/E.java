package from_yandex_praktikum_algorithms.sprint_3_sortings.simple_tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class E {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] inFirstLine = in.readLine().split(" ");
        int arrSize = Integer.parseInt(inFirstLine[0]);
        int amount = Integer.parseInt(inFirstLine[1]);
        String[] buildingsStrArr = in.readLine().split(" ");
        int[] buildingsCoasts = new int[arrSize];
        for (int i=0; i<arrSize; i++) {
            buildingsCoasts[i] = Integer.parseInt(buildingsStrArr[i]);
        }

        Arrays.sort(buildingsCoasts);
        //System.out.println(Arrays.toString(buildingsCoasts));
        int count = 0;
        for (int i=0; i<arrSize; i++) {
            amount = amount-buildingsCoasts[i];
            if (amount>=0) {
                count++;
            } else {
                break;
            }
        }
        System.out.println(count);
    }

}
