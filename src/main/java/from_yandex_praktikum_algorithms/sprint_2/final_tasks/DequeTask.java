package from_yandex_praktikum_algorithms.sprint_2.final_tasks;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Посылка: 45568587
 * Выполнил: Коченков Владислав
 *
 * -- ПРИНЦИП РАБОТЫ --
 * Дэк - это интерфейс, методы которого позволяют извлекать и добавлять элементы с обоих концов списка.
 * Для реализации задачи, сначала был создан интерфейс дэка, где были описаны все публичные методы. Далее, реализована имплиментация интерфейса, используя
 * стандартную джава-коллекцию динамического массива.
 *
 * -- КОРРЕКТНОСТЬ РАБОТЫ --
 * Подумал, что для тех условий (до 1000 элементов), которые были описаны в задаче, динамического массива будет достаточно.
 * Если бы дэк требовался большего размера, то стоило-бы применить двусвязный список (чего по условию задачи делать было нельзя), тк он эффективнее
 * для удаления и добавления элементов в начало списка - не нужно сдвигать все последующие элементы.
 *
 * -- ВРЕМЕННАЯ СЛОЖНОСТЬ --
 * Операции добавления и удаления из конца списка в среднем работают за О(1) - если не считать переодическое расширение динамического массива.
 * Операции добавления и удаления в начало работают за О(n), тк требуется сдвинуть все последующие элементы.
 */
public class DequeTask {

    public static void main(String[] args) throws IOException {
        final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        final BufferedWriter out = new BufferedWriter(new FileWriter("output.txt"));

        final int commandsSize = Integer.parseInt(in.readLine().split(" ")[0]);
        final int maxSize = Integer.parseInt(in.readLine().split(" ")[0]);

        final DequeImpl<Integer> queue = new DequeImpl<>(maxSize);

        for (int i = 0; i < commandsSize; i++) {
            String[] command = in.readLine()
                                 .split(" ");
            Integer n;
            switch (command[0]) {
                case ("push_back"):
                    n = Integer.parseInt(command[1]);
                    if (!queue.pushBack(n)) {
                        out.write("error\n");
                    }
                    break;
                case ("push_front"):
                    n = Integer.parseInt(command[1]);
                    if (!queue.pushFront(n)) {
                        out.write("error\n");
                    }
                    break;
                case ("pop_front"):
                    out.write(queue.popFront()+ "\n");
                    break;
                case ("pop_back"):
                    out.write(queue.popBack() + "\n");
                    break;
                default:
                    throw new IllegalArgumentException();
            }
        }
        in.close();
        out.close();
    }

    static class DequeImpl<V> implements Deque<V> {

        private static final String ERROR_STRING = "error";

        private List<V> deque;
        private int maxSize;

        public DequeImpl(int maxSize) {
            this.deque = new ArrayList<>();
            this.maxSize = maxSize;
        }

        public boolean pushBack(V value) {
            return push(-1, value);
        }

        public boolean pushFront(V value) {
            return push(0, value);
        }

        public String popBack() {
            return pop(deque.size() - 1);
        }

        public String popFront() {
            return pop(0);
        }

        private String pop(int position) {
            if (deque.size() > 0) {
                V value = deque.get(position);
                deque.remove(position);
                return value.toString();
            } else {
                return ERROR_STRING;
            }
        }

        private boolean push(int position, V value) {
            if (deque.size() < maxSize) {
                if (position == -1) {
                    deque.add(value);
                } else {
                    deque.add(position, value);
                }
                return true;
            } else {
                return false;
            }
        }
    }

    interface Deque<V> {

        String popFront();

        String popBack();

        boolean pushFront(V value);

        boolean pushBack(V value);
    }
}