package from_yandex_praktikum_algorithms.sprint_2.final_tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Посылка: 45648433
 * Выполнил: Коченков Владислав
 *
 * Переписал задачу с использованием самописного стэка, без использования java-коллекций. Для реализации стэка использовал принцип работы
 * динамического массива.
 *
 * -- ПРИНЦИП РАБОТЫ --
 * Принцип работы алгоритма заключается в том, что я считываю входные данные и помещаю их в строковый массив.
 * Далее, итерируюсь по массиву и кладу найденные операнды в стэк. Если натыкаюсь на операцию, то выполняю ее с последними двумя операндами в стэке.
 *
 * -- КОРРЕКТНОСТЬ РАБОТЫ --
 * Само условие польской нотации гарантирует, что перед оператором будет минимум два операнда, значит алгоритм будет работать корректно.
 *
 * -- ВРЕМЕННАЯ СЛОЖНОСТЬ --
 * Сам алгоритм в целом, выполняется за О(n), тк количество итераций напрямую зависит от размера входных данных.
 * Функции pop и push, которые используется для работы со стэком, работают в среднем за О(1), не считая моментов, когда требуется пересоздать массив
 * внутри стэка
 */

public class CalculatorTaskV2 {

    public static void main(String[] args) throws IOException {
        final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        final String[] inputArray = in.readLine().split(" ");
        in.close();

        final Stack operandsStack = new Stack();

        String inputElement;
        for (int i = 0; i < inputArray.length; i++) {
            inputElement = inputArray[i];
            switch (inputElement) {
                case ("*"):
                    operandsStack.push(doMultiplication(operandsStack.pop(), operandsStack.pop()));
                    break;
                case ("/"):
                    operandsStack.push(doDivision(operandsStack.pop(), operandsStack.pop()));
                    break;
                case ("+"):
                    operandsStack.push(doAddition(operandsStack.pop(), operandsStack.pop()));
                    break;
                case ("-"):
                    operandsStack.push(doSubtraction(operandsStack.pop(), operandsStack.pop()));
                    break;
                default:
                    operandsStack.push(Integer.parseInt(inputElement));
            }
        }
        System.out.println(operandsStack.pop());
    }

    private static Integer doAddition(Integer b, Integer a) {
        return a + b;
    }

    private static Integer doMultiplication(Integer b, Integer a) {
        return a * b;
    }

    private static Integer doSubtraction(Integer b, Integer a) {
        return a - b;
    }

    private static Integer doDivision(Integer b, Integer a) {
        if (b != 0) {
            Integer c = a / b;
            if (c == 0) {
                if (a < 0 || b < 0) {
                    c = -1;
                } else {
                    c = a % b;
                }
            }
            return c;
        } else {
            throw new IllegalArgumentException();
        }
    }

    static class Stack {

        private Integer[] stack;
        private int newHeadIndex;
        private int capacity;
        private int multiplicationIndex;

        Stack() {
            this.capacity = 10;
            this.stack = new Integer[this.capacity];
            this.newHeadIndex = 0;
            this.multiplicationIndex = 2;
        }

        public void push(Integer x) {
            try {
                stack[newHeadIndex] = x;
                newHeadIndex++;
            } catch (Exception e) {
                Integer[] newStack = new Integer[capacity * multiplicationIndex];
                for (int i = 0; i < newStack.length; i++) {
                    newStack[i] = stack[i];
                }
                stack = newStack;
            }
        }

        public Integer pop() {
            if (stack.length > 0) {
                Integer element = stack[newHeadIndex - 1];
                stack[newHeadIndex - 1] = null;
                newHeadIndex--;
                return element;
            } else {
                throw new IndexOutOfBoundsException();
            }
        }
    }
}