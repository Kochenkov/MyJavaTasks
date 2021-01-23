package from_yandex_praktikum_algorithms.sprint_4_hash_tables.simple_tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Задача по записи не повторяющихся строк
 */
public class D {


    public static void main(String[] args) throws IOException {


        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(scan.readLine().split(" ")[0]);

        List<String> strArr = new ArrayList<>(size);

        if (size>0) {
            strArr.add(scan.readLine());

            boolean exist = false;

            for (int j=1; j<size; j++) {
                String str = scan.readLine();
                for (int i=strArr.size()-1; i>=0; i--) {
                    if (strArr.get(i).equals(str)) {
                        exist = true;
                        break;
                    } else {
                        exist = false;
                    }
                }
                if (!exist) {
                    strArr.add(str);
                }

            }
        } else {
            System.out.println();
        }

        for (String s : strArr) {
            System.out.println(s);
        }

    }
}