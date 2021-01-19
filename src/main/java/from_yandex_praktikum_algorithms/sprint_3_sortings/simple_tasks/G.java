package from_yandex_praktikum_algorithms.sprint_3_sortings.simple_tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//гардероб
public class G {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int arraySize = Integer.parseInt(in.readLine().split(" ")[0]);

        //int[] dresses = new int[arraySize];

//        List<Integer> pink = new ArrayList<>(100000);
//        List<Integer> yellow = new ArrayList<>(100000);
//        List<Integer> red = new ArrayList<>(100000);

        if (arraySize!=0) {
            String[] str = in.readLine().split(" ");

            in.close();

            Arrays.sort(str);
            StringBuilder sb = new StringBuilder();
            for (int i=0; i<arraySize; i++) {
                sb.append(str[i]).append(" ");
            }

            System.out.println(sb.toString());
        } else {
            System.out.println();
        }
    }

}
