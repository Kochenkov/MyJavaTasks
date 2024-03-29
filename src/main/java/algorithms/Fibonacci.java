package algorithms;

public class Fibonacci {

    /**
     * оптимизированный алгоритм на основе массива
     */
    public static int findFibGood(int number) {
        int[] array = new int[number];
        for (int j = 0; j < number; j++) {
            if (j <= 1) {
                array[j] = j;
            } else {
                array[j] = array[j - 1] + array[j - 2];
            }
        }
        return array[number - 1];
    }

    /**
     * неоптимизированный рекурсивный алгоритм
     */
    public static int findFibBad(int number) {
        if (number == 0) {
            return 0;
        } else if (number == 1) {
            return 1;
        } else {
            return (findFibBad(number - 1) + findFibBad(number - 2));
        }
    }

    /**
     * поиск последней цифры n-го числа фибоначи
     */
    public static int findFibLastDigit(int number) {
        int[] array = new int[number];
        for (int j = 0; j < number; j++) {
            if (j <= 1) {
                array[j] = j;
            } else {
                array[j] = array[j - 1] % 10 + array[j - 2] % 10;
                array[j] = array[j] % 10;
            }
        }
        return array[number - 1];
    }
}
