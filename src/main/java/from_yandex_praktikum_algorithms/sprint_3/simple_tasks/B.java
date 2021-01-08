package from_yandex_praktikum_algorithms.sprint_3.simple_tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//todo
public class B {

//    private final static String[] b2 = new String[]{"a", "b", "c"};
//    private final static String[] b3 = new String[]{"d", "e", "f"};
//    private final static String[] b4 = new String[]{"g", "h", "i"};
//    private final static String[] b5 = new String[]{"j", "k", "l"};
//    private final static String[] b6 = new String[]{"m", "n", "o"};
//    private final static String[] b7 = new String[]{"p", "q", "r", "s"};
//    private final static String[] b8 = new String[]{"t", "u", "v"};
//    private final static String[] b9 = new String[]{"w", "x", "y", "z"};


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
