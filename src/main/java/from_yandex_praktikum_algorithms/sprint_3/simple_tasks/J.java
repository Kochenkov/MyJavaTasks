package from_yandex_praktikum_algorithms.sprint_3.simple_tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class J {

    public static void main(String[] args) throws IOException {
        //input
        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        short length = Short.parseShort(scan.readLine().split(" ")[0]);
        short[] array = new short[length];
        String[] inArr = scan.readLine().split(" ");
        for (short i = 0; i < length; i++) {
            array[i] = Short.parseShort(inArr[i]);
        }
        scan.close();

        //algorithm
        boolean isSoreted = false;
        boolean withoutSorting = true;
        if (array.length == 0) {
            isSoreted = true;
        }
        while (!isSoreted) {
            isSoreted = true;
            for (short i = 0; i < length - 1; i++) {
                short first = array[i];
                short second = array[i + 1];
                if (first > second) {
                    isSoreted = false;
                    array[i + 1] = first;
                    array[i] = second;
                }
            }
            if (!isSoreted) {
                withoutSorting = false;
                for (short i = 0; i < length; i++) {
                    sb.append(array[i])
                      .append(" ");
                }
                sb.append("\n");
            }
            if (withoutSorting) {
                for (short i = 0; i < length; i++) {
                    sb.append(array[i])
                      .append(" ");
                }
                sb.append("\n");
            }
        }
        System.out.print(sb.toString());
    }
}
