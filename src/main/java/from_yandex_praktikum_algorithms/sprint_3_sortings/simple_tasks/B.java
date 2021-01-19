package from_yandex_praktikum_algorithms.sprint_3_sortings.simple_tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//todo
public class B {


    public static void main(String[] args) throws IOException {
        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
        String[] inArr = scan.readLine()
                             .split("");
        scan.close();

        String[][] lettersArr = new String[inArr.length][];

        for (int i=0; i<inArr.length; i++) {
            switch (inArr[i]){
                case "2":
                    lettersArr[i] = new String[]{"a", "b", "c"};
                    break;
                case "3":
                    lettersArr[i] = new String[]{"d", "e", "f"};
                    break;
                case "4":
                    lettersArr[i] = new String[]{"g", "h", "i"};
                    break;
                case "5":
                    lettersArr[i] = new String[]{"j", "k", "l"};
                    break;
                case "6":
                    lettersArr[i] = new String[]{"m", "n", "o"};
                    break;
                case "7":
                    lettersArr[i] = new String[]{"p", "q", "r", "s"};
                    break;
                case "8":
                    lettersArr[i] = new String[]{"t", "u", "v"};
                    break;
                case "9":
                    lettersArr[i] = new String[]{"w", "x", "y", "z"};
                    break;
            }
        }




    }

}
