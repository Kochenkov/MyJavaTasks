package from_yandex_praktikum_algorithms.sprint_2.simple_tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

// падает один из тестов
public class H {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> bracketsArray = new ArrayList<>(Arrays.asList(in.readLine().split("")));

        boolean answer = check(bracketsArray);
        if (answer) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }

    private static boolean check(ArrayList<String> bracketsArray) {
        if (bracketsArray.size()==0) {
            return true;
        } else if (bracketsArray.size()==1) {
            return false;
        } else {
            String first;
            String second;
            int counterPosition = 2;
            while (bracketsArray.size()>0) {
                if (counterPosition>bracketsArray.size()) {
                    return false;
                }
                first = bracketsArray.get(counterPosition-1);
                second = bracketsArray.get(counterPosition-2);
                try {
                    if (first.equals(invert(second))) {
                        bracketsArray.remove(counterPosition-2);
                        bracketsArray.remove(counterPosition-2);
                        counterPosition = 2;
                    } else {
                        counterPosition++;
                    }
                } catch (IllegalArgumentException ex) {
                    return false;
                }
            }
            return true;
        }
    }

    private static String invert(String bracket) {
        switch (bracket) {
            case "(": return ")";
            case "[": return "]";
            case "{": return "}";
        }
        throw new IllegalArgumentException();
    }
}
