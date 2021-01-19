package from_yandex_praktikum_algorithms.sprint_2_simple_data_structures.final_tasks;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Посылка: 45650769
 * Выполнил: Коченков Владислав
 *
 * Переписал задачу, используя самописные элементы двусвязного списка для реализации дэка.
 *
 * -- ПРИНЦИП РАБОТЫ --
 * Реализованный дэк, по-мимо требуемых методов, имеет поля со ссылками на первый и последний элементы, а так-же текущее колличество
 * элементов, которое изменяется после добавления или удаления с одного из концов.
 *
 * -- КОРРЕКТНОСТЬ РАБОТЫ --
 * Дэк это контейнер, который является двунаправленной очередью и позволяет как класть, так и получать значения с обоих концов очереди.
 * Представленная реализация дэка, основанная на связном списке, позволяет выполнять все требуемые операции за константное время.
 *
 * -- ВРЕМЕННАЯ СЛОЖНОСТЬ --
 * Все операции добавления и удаления из конца и начала списка работают за О(1), тк не зависят от кол-ва элементов в списке.
 */
public class DequeTaskV2 {

    private static final String ERROR_STRING = "error";
    private static final String PUSH_BACK = "push_back";
    private static final String PUSH_FRONT = "push_front";
    private static final String POP_FRONT = "pop_front";
    private static final String POP_BACK = "pop_back";

    public static void main(String[] args) throws IOException {
        final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        final BufferedWriter out = new BufferedWriter(new FileWriter("output.txt"));

        final int commandsSize = Integer.parseInt(in.readLine().split(" ")[0]);
        final int maxSize = Integer.parseInt(in.readLine().split(" ")[0]);

        final Deque deque = new Deque(maxSize);

        for (int i = 0; i < commandsSize; i++) {
            String[] command = in.readLine().split(" ");
            Integer n;
            switch (command[0]) {
                case (PUSH_BACK):
                    n = Integer.parseInt(command[1]);
                    if (!deque.pushBack(n)) {
                        out.write(ERROR_STRING + "\n");
                    }
                    break;
                case (PUSH_FRONT):
                    n = Integer.parseInt(command[1]);
                    if (!deque.pushFront(n)) {
                        out.write(ERROR_STRING + "\n");
                    }
                    break;
                case (POP_FRONT):
                    out.write(deque.popFront() + "\n");
                    break;
                case (POP_BACK):
                    out.write(deque.popBack() + "\n");
                    break;
                default:
                    throw new IllegalArgumentException();
            }
        }
        in.close();
        out.close();
    }

    static class Deque {

        private Node first;
        private Node last;
        private int maxSize;
        private int currentSize;

        public Deque(int maxSize) {
            this.maxSize = maxSize;
            this.currentSize = 0;
        }

        public boolean pushBack(Integer value) {
            if (currentSize < maxSize) {
                if (last == null) {
                    last = new Node(value, null, null);
                    first = last;
                } else {
                    Node intern = last;
                    last = new Node(value, intern, null);
                    intern.previous = last;
                }
                currentSize++;
                return true;
            } else {
                return false;
            }
        }

        public boolean pushFront(Integer value) {
            if (currentSize < maxSize) {
                if (first == null) {
                    first = new Node(value, null, null);
                    last = first;
                } else {
                    Node intern = first;
                    first = new Node(value, null, intern);
                    intern.next = first;
                }
                currentSize++;
                return true;
            } else {
                return false;
            }
        }

        public String popBack() {
            if (currentSize > 1) {
                Integer value = last.value;
                Node preLast = last.next;
                preLast.previous = null;
                last = preLast;
                currentSize--;
                return value.toString();
            } else if (currentSize > 0) {
                Integer value = last.value;
                last = null;
                first = null;
                currentSize--;
                return value.toString();
            } else {
                return ERROR_STRING;
            }
        }

        public String popFront() {
            if (currentSize > 1) {
                Integer value = first.value;
                Node preFirst = first.previous;
                preFirst.next = null;
                first = preFirst;
                currentSize--;
                return value.toString();
            } else if (currentSize > 0) {
                Integer value = first.value;
                first = null;
                last = null;
                currentSize--;
                return value.toString();
            } else {
                return ERROR_STRING;
            }
        }
    }

    static class Node {

        public Integer value;
        public Node next;
        public Node previous;

        public Node(Integer value, Node next, Node previous) {
            this.value = value;
            this.next = next;
            this.previous = previous;
        }
    }
}