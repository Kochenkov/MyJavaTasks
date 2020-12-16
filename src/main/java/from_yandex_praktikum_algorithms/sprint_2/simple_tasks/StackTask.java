package from_yandex_praktikum_algorithms.sprint_2.simple_tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

//todo падаю либо по-памяти, либо по времени
public class StackTask {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Stack stack = new Stack();
        int commandsSize = Integer.parseInt(in.readLine()
                                              .split(" ")[0]);
        String[] command;
        for (int i = 0; i < commandsSize; i++) {
            command = in.readLine()
                        .split(" ");
            switch (command[0]) {
                case ("get_max"):
                    System.out.println(stack.getMax());
                    break;
                case ("push"):
                    Integer n = Integer.parseInt(command[1]);
                    stack.push(n);
                    break;
                case ("pop"):
                    boolean b = stack.pop();
                    if (!b) {
                        System.out.println("error");
                    }
                    break;
                default:
                    throw new IllegalStateException();
            }
        }
        in.close();
    }


    static class Stack {

        private ArrayList<Integer> stack;
        private Integer max;
        private Integer maxPosition;

        Stack() {
            this.stack = new ArrayList<>(100000);
        }

        public void push(Integer x) {
            if (max != null && x > max) {
                max = x;
                maxPosition = stack.size();
            }
            stack.add(x);
        }

        public boolean pop() {
            if (stack.size() > 0) {
                int pos = stack.size() - 1;
                if (max != null && maxPosition != null && maxPosition == pos) {
                    max = null;
                    maxPosition = null;
                }
                stack.remove(pos);
                return true;
            } else {
                return false;
            }
        }

        public String getMax() {
            if (max == null) {
                if (stack.size() > 0) {
                    findMax();
                    return max.toString();
                } else {
                    return "None";
                }
            } else {
                return max.toString();
            }
        }

        private void findMax() {
            max = stack.get(0);
            maxPosition = 0;
            for (int i = 1; i < stack.size(); i++) {
                int el = stack.get(i);
                if (max < el) {
                    max = el;
                    maxPosition = i;
                }
            }
        }
    }
}