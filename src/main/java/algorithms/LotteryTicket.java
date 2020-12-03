package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class LotteryTicket {
//    1 2 3 4 5 6 7 8 9 32 3 1 2 10 11 12 13 1 2 3 10 11 12 32 1 10 20 30 3

    /**
     * [1, 2, 3, 4, 5, 6, 7, 8, 9, 32]
     * 3
     * [1, 2, 10, 11, 12, 13]
     * [1, 2, 3, 10, 11, 12]
     * [32, 1, 10, 20, 30, 3]
     * Unlucky
     * Lucky
     * Lucky
     */


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Integer[] hiddenNumbers = new Integer[10];
        for (int i = 0; i < hiddenNumbers.length; i++) {
            hiddenNumbers[i] = scan.nextInt();
        }
        System.out.println(Arrays.toString(hiddenNumbers));
        int howMany = scan.nextInt();
        System.out.println(howMany);
        List<Integer[]> list = new ArrayList<>();
        boolean hasNext = true;
        while (howMany > 0) {
            Integer[] loteryTicket = new Integer[6];
            for (int i = 0; i < loteryTicket.length; i++) {
                loteryTicket[i] = scan.nextInt();
            }
            list.add(loteryTicket);
            howMany -= 1;
            System.out.println(Arrays.toString(loteryTicket));
        }


        for (Integer[] ticket : list) {
            int comparison = 0;
            for (int i = 0; i < ticket.length; i++) {
                for (int j = 0; j < hiddenNumbers.length; j++) {
                    if (ticket[i] == hiddenNumbers[j]) {
                        comparison += 1;
                        break;
                    }
                }
                if (comparison >= 3) {
                    System.out.println("Lucky");
                    break;
                }
            }
            if (comparison < 3) {
                comparison = 0;
                System.out.println("Unlucky");
            } else {
                comparison = 0;
            }
        }
    }
}
