package from_yandex_praktikum_algorithms.sprint_3.simple_tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.Scanner;

//todo нужно написать корректную двоичную сортировку
// падает в любом случае даже на этапе ввода данных
public class L {


//    public static void main(String[] args) throws IOException {
//        Scanner in = new Scanner(System.in);
//        int length = in.nextInt();
//        int[] inArr = new int[length];
//        for (int i=0; i<length; i++) {
//            inArr[i] = in.nextInt();
//        }
//        int value = in.nextInt();
//        in.close();
//        ArrayList<Integer> syclestArr = new ArrayList<>();
//
//
//        if (syclestArr.size()<2) {
//            for (int i=0; i<2; i++) {
//                syclestArr.add(-1);
//            }
//        }
//
//        System.out.print(syclestArr.get(0));
//        System.out.print(" ");
//        System.out.print(syclestArr.get(1));
//    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(in.readLine().split(" ")[0]);
        String[] inArr = in.readLine().split(" ");

        int[] array = new int[length];
        for (short i = 0; i < length; i++) {
            array[i] = Integer.parseInt(inArr[i]);
        }

        int value = Integer.parseInt(in.readLine().split(" ")[0]);
        in.close();

        ArrayList<Integer> syclestArr = new ArrayList<>(3);

        for (int i=0; i<length; i++) {
            if (Integer.parseInt(inArr[i])>=value) {
                syclestArr.add(i+1);
                value = value*2;
            }
        }
        if (syclestArr.size()<2) {
            for (int i=0; i<2; i++) {
                syclestArr.add(-1);
            }
        }

        System.out.print(syclestArr.get(0));
        System.out.print(" ");
        System.out.print(syclestArr.get(1));
    }
}
