package from_yandex_praktikum_algorithms.sprint_2_simple_data_structures.final_tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Посылка: 45596475
 Выполнил: Коченков Владислав
 *
 * -- ПРИНЦИП РАБОТЫ --
 * Решил реализовать эту задачу на связном списке, а не на стэке. Тк стэк, все-равно использовал бы связный список в своей реализации.
 * Принцип работы алгоритма заключается в том, что я считываю сразу всю строку и храню ее в связном списке.
 * Далее, пока в списке есть хотя бы один оператор, выполняю функцию выполнения операции.
 * Для этого, иду по списку, до первого встречного оператора, и выполняю операцию с этим оператором, для двух предыдущих элементов.
 *
 * -- КОРРЕКТНОСТЬ РАБОТЫ --
 * Само условие польской нотации гарантирует, что перед оператором будет минимум два операнда, значит алгоритм будет работать корректно.
 * Столкнулся со сложностью при реализации деления, долго не мог понять, как именно оно должно работать.
 *
 * -- ВРЕМЕННАЯ СЛОЖНОСТЬ --
 * Сам алгоритм в целом, выполняется за О(n), тк количество итераций напрямую зависит от размера входных данных
 * Функция обработки конкретного участка списка с двумя операндами и оператором работает за O(1), тк при реализации используется связный список,
 * и не приходится перезаписывать весь массив оставшихся данных целиком.
 */
public class CalculatorTask {

    static List<String> inputList;

    public static void main(String[] args) throws IOException {
        final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        inputList = new LinkedList<>(Arrays.asList(in.readLine().split(" ")));
        in.close();

        while (inputList.get(inputList.size() - 1).equals("/") ||
                inputList.get(inputList.size() - 1).equals("*") ||
                inputList.get(inputList.size() - 1).equals("+") ||
                inputList.get(inputList.size() - 1).equals("-")
        ) {
            inputList = findAndDoOperation(inputList);
        }

        String answer;
        if (inputList.size() > 1) {
            answer = inputList.get(inputList.size() - 1);
        } else {
            answer = inputList.get(0);
        }
        System.out.println(answer);
    }

    private static List<String> findAndDoOperation(List<String> inputList) {
        String firstItem = inputList.get(0);
        String secondItem = inputList.get(1);
        for (int i = 2; i < inputList.size(); i++) {
            if (inputList.get(i).equals("*")) {
                Integer a = Integer.parseInt(firstItem);
                Integer b = Integer.parseInt(secondItem);
                Integer c = a * b;
                replace(i, c.toString());
                break;
            } else if (inputList.get(i).equals("/")) {
                Integer a = Integer.parseInt(firstItem);
                Integer b = Integer.parseInt(secondItem);
                Integer c;
                if (b != 0) {
                    c = a / b;
                    if (c == 0) {
                        if (a < 0 || b < 0) {
                            c = -1;
                        } else {
                            c = a % b;
                        }
                    }
                } else {
                    throw new IllegalArgumentException();
                }
                replace(i, c.toString());
                break;
            } else if (inputList.get(i).equals("+")) {
                Integer a = Integer.parseInt(firstItem);
                Integer b = Integer.parseInt(secondItem);
                Integer c = a + b;
                replace(i, c.toString());
                break;
            } else if (inputList.get(i).equals("-")) {
                Integer a = Integer.parseInt(firstItem);
                Integer b = Integer.parseInt(secondItem);
                Integer c = a - b;
                replace(i, c.toString());
                break;
            } else {
                firstItem = inputList.get(i - 1);
                secondItem = inputList.get(i);
            }
        }
        return inputList;
    }

    private static void replace(int index, String item) {
        inputList.set(index, item);
        inputList.remove(index - 2);
        inputList.remove(index - 2);
    }
}