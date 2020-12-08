package from_yandex_praktikum_algorithms.sprint_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Выполнил Коченков Владислав
 * ID 43482784
 */

public class Task1old {

    public static void main(String[] args) throws IOException {
        //ввод
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(in.readLine());
        String[] houseNumbers = in.readLine()
                                  .split(" ");

        //создаем список с позициями всех нулей
        List<Integer> zeroPositionsList = new ArrayList<>();
        for (int i = 0; i < houseNumbers.length; i++) {
            if (houseNumbers[i].equals("0")) {
                zeroPositionsList.add(i);
            }
        }

        //создаем список с позициями, по которым будем делить входной массив на подмассивы
        List<Integer> cuttingPositionsList = new ArrayList<>();
        if (zeroPositionsList.size() > 1) {
            for (int i = 0; i < zeroPositionsList.size() - 1; i++) {
                int a = zeroPositionsList.get(i);
                int b = zeroPositionsList.get(i + 1);
                int c = (b - a) / 2 + a;
                cuttingPositionsList.add(c);
            }
        }

        //делим входной массив на подмассивы
        String[][] cuttingArrays = new String[cuttingPositionsList.size() + 1][];
        if (cuttingPositionsList.size() == 0) {
            cuttingArrays[0] = houseNumbers;
        } else if (cuttingPositionsList.size() == 1) {
            cuttingArrays[0] = Arrays.copyOfRange(houseNumbers, 0, cuttingPositionsList.get(0) + 1);
            cuttingArrays[1] = Arrays.copyOfRange(houseNumbers, cuttingPositionsList.get(0) + 1, houseNumbers.length);
        } else {
            cuttingArrays[0] = Arrays.copyOfRange(houseNumbers, 0, cuttingPositionsList.get(0) + 1);
            for (int i = 0; i < cuttingPositionsList.size() - 1; i++) {
                cuttingArrays[i + 1] = Arrays.copyOfRange(houseNumbers,
                                                          cuttingPositionsList.get(i) + 1,
                                                          cuttingPositionsList.get(i + 1) + 1);
            }
            cuttingArrays[cuttingPositionsList.size()] = Arrays.copyOfRange(houseNumbers,
                                                                            cuttingPositionsList.get(cuttingPositionsList.size() - 1) + 1,
                                                                            houseNumbers.length);
        }

        //находим расстояния в раздробленных массивах и выводим результат
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cuttingArrays.length; i++) {
            sb.append(Arrays.toString(findDistanceForZero(cuttingArrays[i])));
        }
        String answer = sb.toString()
                          .replace("]", " ")
                          .replace("[", "")
                          .replace(",", "");
        System.out.println(answer);

    }

    //функция нахождения расстояния каждого элемента до нуля
    private static int[] findDistanceForZero(String[] arrayWithOneZero) {
        int[] positions = new int[arrayWithOneZero.length];
        int zeroPosition = 0;
        for (int i = 0; i < arrayWithOneZero.length; i++) {
            if (arrayWithOneZero[i].equals("0")) {
                zeroPosition = i;
                break;
            }
        }
        for (int i = 0; i < arrayWithOneZero.length; i++) {
            positions[i] = Math.abs(zeroPosition - i);
        }
        return positions;
    }

    //таже самая ф-ция что и выше, только с использованием стримов (ID 43482944)
    /**
     * Для сравнения, прогнал задачу с разной реализацией этих функций, не меняя остального кода.
     * Решение с использованием верхней ф-ции:         1.433s  361.88Mb
     * Решение с использованием нижней (этой) ф-ции:   1.603s  407.22Mb
     * Как видно, решение на стримах получилось медленее, и более требовательным по-памяти. Но возможно просто я что-то не так написал
     * Интересно услышать ваше мнение на этот счёт, на сколько целесообразно использовать стримы в подобных задачах

    private static int[] findDistanceForZero(String[] arrayWithOneZeroPlace) {
        int zeroPosition = IntStream.range(0, arrayWithOneZeroPlace.length)
                                    .filter(i -> arrayWithOneZeroPlace[i].equals("0"))
                                    .findFirst()
                                    .orElse(0);
        return IntStream.range(0, arrayWithOneZeroPlace.length)
                        .map(i -> Math.abs(zeroPosition - i))
                        .toArray();

    }
     */
}