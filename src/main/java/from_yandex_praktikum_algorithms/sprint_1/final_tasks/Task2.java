package from_yandex_praktikum_algorithms.sprint_1.final_tasks;

import java.util.Scanner;

/**
 * Выполнил Коченков Владислав
 * ID 44190477
 *
 * Обновил эту задачу тоже. Добавил модификаторы final и scan.close().
 * Хотел сказать спасибо за комментарий по поводу default в switch/case, но кажется что в конкретно этой задаче он не нужен
 */

public class Task2 {

    public static void main(String[] args) {

        final int KEYBOARD_SIZE = 4;

        //ввод
        final Scanner scan = new Scanner(System.in);
        final int k = scan.nextInt();
        final String[][] keyboardArray = new String[KEYBOARD_SIZE][KEYBOARD_SIZE];
        for (int i = 0; i < KEYBOARD_SIZE; i++) {
            String inputStr = scan.next();
            keyboardArray[i] = inputStr.split("");
        }
        scan.close();

        //реализация алгоритма
        int boysScore = 0;
        int[] valuesAmountArray = {0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0; i < KEYBOARD_SIZE; i++) {
            for (int j = 0; j < KEYBOARD_SIZE; j++) {
                switch (keyboardArray[i][j]) {
                    case "1":
                        valuesAmountArray[0]++;
                        break;
                    case "2":
                        valuesAmountArray[1]++;
                        break;
                    case "3":
                        valuesAmountArray[2]++;
                        break;
                    case "4":
                        valuesAmountArray[3]++;
                        break;
                    case "5":
                        valuesAmountArray[4]++;
                        break;
                    case "6":
                        valuesAmountArray[5]++;
                        break;
                    case "7":
                        valuesAmountArray[6]++;
                        break;
                    case "8":
                        valuesAmountArray[7]++;
                        break;
                    case "9":
                        valuesAmountArray[8]++;
                        break;
                    default:
                        throw new UnsupportedOperationException();
                }
            }
        }

        for (int i = 0; i < valuesAmountArray.length; i++) {
            if (valuesAmountArray[i] > 0) {
                if (k * 2 >= valuesAmountArray[i]) {
                    boysScore++;
                }
            }
        }

        System.out.println(boysScore);
    }
}