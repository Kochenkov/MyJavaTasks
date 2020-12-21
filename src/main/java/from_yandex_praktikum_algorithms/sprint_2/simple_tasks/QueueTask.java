package from_yandex_praktikum_algorithms.sprint_2.simple_tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class QueueTask {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int commandsSize = Integer.parseInt(in.readLine()
                                              .split(" ")[0]);
        int capacity = Integer.parseInt(in.readLine()
                                          .split(" ")[0]);
        Queue queue = new Queue(capacity);

        for (int i = 0; i < commandsSize; i++) {
            String[] command = in.readLine()
                                 .split(" ");
            switch (command[0]) {
                case ("push"):
                    Integer n = Integer.parseInt(command[1]);
                    if (!queue.push(n)) {
                        System.out.println("error");
                    }
                    break;
                case ("pop"):
                    System.out.println(queue.pop());
                    break;
                case ("peek"):
                    System.out.println(queue.peek());
                    break;
                case ("size"):
                    System.out.println(queue.size());
                    break;
                default:
                    throw new IllegalStateException();
            }
        }
        in.close();
    }


    static class Queue {

        private List<Integer> queue;
        private int capacity;

        Queue(int capacity) {
            this.queue = new LinkedList<>();
            this.capacity = capacity;
        }

        public boolean push(int x) {
            if (queue.size()<capacity) {
                queue.add(0, x);
                return true;
            } else {
                return false;
            }
        }

        public String pop() {
            if (queue.size()>0) {
                Integer element = queue.get(queue.size()-1);
                queue.remove(queue.size()-1);
                return Integer.toString(element);
            } else {
                return "None";
            }
        }

        public String peek() {
            if (queue.size()>0) {
                return Integer.toString(queue.get(queue.size()-1));
            } else {
                return "None";
            }
        }

        public String size() {
            return Integer.toString(queue.size());
        }
    }
}