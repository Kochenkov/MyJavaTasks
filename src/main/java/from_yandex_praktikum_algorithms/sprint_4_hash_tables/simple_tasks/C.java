package from_yandex_praktikum_algorithms.sprint_4_hash_tables.simple_tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Префиксные хеши - нужно найти хеши всех подстрок, которые поступают на вход
 */
//падает по-времени
public class C {

    public static void main(String[] args) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        //ввод
        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(scan.readLine()
                                     .split(" ")[0]);
        int m = Integer.parseInt(scan.readLine()
                                     .split(" ")[0]);
        char[] charArr = scan.readLine()
                             .toCharArray();
        int requestsCount = Integer.parseInt(scan.readLine()
                                                 .split(" ")[0]);

        //ввод промежутков и вызов расчета хеша
        for (int i = 0; i < requestsCount; i++) {
            String[] arrIn = scan.readLine()
                                 .split(" ");
            int[] arrOut = new int[2];
            for (int j = 0; j < arrIn.length; j++) {
                arrOut[j] = Integer.parseInt(arrIn[j]);
            }
            stringBuilder.append(findHash(a, m, charArr, arrOut))
                         .append("\n");
        }
        scan.close();

        System.out.println(stringBuilder.toString());

    }

    static long findHash(int a, int m, char[] charArr, int[] interval) {
        int currentNumber = interval[0] - 1;
        long hash = charArr[currentNumber] % m;

        if (interval[1] - interval[0] > 0) {

            for (int i = interval[0]; i < interval[1]; i++) {
                currentNumber++;
                hash = (hash * a + charArr[currentNumber]) % m;
            }
        }
        return hash;
    }
}