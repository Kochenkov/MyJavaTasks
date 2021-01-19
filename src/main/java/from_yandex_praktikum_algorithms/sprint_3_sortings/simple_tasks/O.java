package from_yandex_praktikum_algorithms.sprint_3_sortings.simple_tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//разность треш-индексов
//падает по памяти
public class O {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int lengthArr = Integer.parseInt(in.readLine().split(" ")[0]);
        String[] strArr = in.readLine().split(" ");
        int k = Integer.parseInt(in.readLine().split(" ")[0]);
        in.close();

        int[] intArr = new int[lengthArr];
        for (int i = 0; i < lengthArr; i++) {
            intArr[i] = Integer.parseInt(strArr[i]);
        }

        int n = lengthArr * (lengthArr - 1) / 2;

        int[] indicesArr = new int[n];
        int addedIndex = 0;
        for (int i = 0; i < lengthArr - 1; i++) {
            for (int j = i + 1; j < lengthArr; j++) {
                indicesArr[addedIndex] = (Math.abs(intArr[i] - intArr[j]));
                addedIndex++;
            }
        }

        Arrays.sort(indicesArr);

        System.out.println(indicesArr[k - 1]);
    }

//    public static void main(String[] args) throws IOException {
//        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//        int lengthArr = Integer.parseInt(in.readLine().split(" ")[0]);
//        String[] strArr = in.readLine().split(" ");
//        int k = Integer.parseInt(in.readLine().split(" ")[0]);
//        in.close();
//
//        int[] intArr = new int[lengthArr];
//        for (int i = 0; i < lengthArr; i++) {
//            intArr[i] = Integer.parseInt(strArr[i]);
//        }
//
//        int n = lengthArr * (lengthArr - 1) / 2;
//
//        int[] indicesArr = new int[n];
//        int addedIndex = 0;
//        for (int i = 0; i < lengthArr - 1; i++) {
//            for (int j = i + 1; j < lengthArr; j++) {
//                indicesArr[addedIndex] = (Math.abs(intArr[i] - intArr[j]));
//                addedIndex++;
//            }
//        }
//
//        Arrays.sort(indicesArr);
//
//        System.out.println(indicesArr[k - 1]);
//    }
}
