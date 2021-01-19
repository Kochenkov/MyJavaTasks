package from_yandex_praktikum_algorithms.sprint_3_sortings.simple_tasks;

import java.util.Arrays;
import java.util.Scanner;

public class D {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int childrenArrSize = scan.nextInt();
        int[] greedArr = new int[childrenArrSize];
        for (int i=0; i<childrenArrSize; i++) {
            greedArr[i] = scan.nextInt();
            //System.out.print(greedArr[i]);
        }
        //System.out.println();
        int cookiesArrSize = scan.nextInt();
        int[] cookiesArr = new int[cookiesArrSize];
        for (int i=0; i<cookiesArrSize; i++) {
            cookiesArr[i] = scan.nextInt();
            //System.out.print(cookiesArr[i]);
        }
        scan.close();

        Arrays.sort(greedArr);
        //System.out.println(Arrays.toString(greedArr));
        Arrays.sort(cookiesArr);
        //System.out.println(Arrays.toString(cookiesArr));


        int pos = 0;
        int count = 0;
        for (int i=0; i<greedArr.length; i++) {
            for (int j=pos; j<cookiesArr.length; j++) {
                if (greedArr[i]<=cookiesArr[j]) {
                    count++;
                    pos++;
                    break;
                } else {
                    pos++;
                }
            }
        }
        System.out.println(count);
    }

}
