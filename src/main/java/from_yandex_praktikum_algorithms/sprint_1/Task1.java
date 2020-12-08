package from_yandex_praktikum_algorithms.sprint_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Выполнил Коченков Владислав
 * ID 44092760
 *
 * Большое спасибо за замечания. Полностью переписал реализацию и делаю два прохода. Тест стал работать гораздо быстрее и занимать меньше памяти
 */

public class Task1 {

    public static void main(String[] args) throws IOException {

        //ввод
        final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        final int size = Integer.parseInt(in.readLine());
        final String[] houseNumbers = in.readLine()
                                        .split(" ");
        in.close();

        //идем справа на лево и сохраняем расстояния до известных нулей в список
        final int[] leftDirectionList = new int[size];
        int worstPossibleZeroPosition = 0;
        for (int i = size - 1; i >= 0; i--) {
            if (houseNumbers[i].equals("0")) {
                worstPossibleZeroPosition = i;
            }
            leftDirectionList[i] = Math.abs(i - worstPossibleZeroPosition);
        }

        //идем слева на право и сразу сравниваем значения с предыдущим проходом, выбираем минимальное, сохраняем его в строку для последующего вывода
        final StringBuilder result = new StringBuilder();
        worstPossibleZeroPosition = size - 1;
        for (int i = 0; i < size; i++) {
            if (houseNumbers[i].equals("0")) {
                worstPossibleZeroPosition = i;
            }
            int currentPos = Math.abs(i - worstPossibleZeroPosition);
            if (currentPos > leftDirectionList[i]) {
                result.append(leftDirectionList[i])
                      .append(" ");
            } else {
                result.append(currentPos)
                      .append(" ");
            }
        }

        System.out.print(result.toString());
    }
}