package from_yandex_praktikum_algorithms.sprint_3.simple_tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

//большее число
//todo
//10 1
//1 10
//57 575 576
//831 828 82
//88 86 8 83 82 3
public class H {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(in.readLine().split(" ")[0]);
        String[] arr = in.readLine().split(" ");
        ArrayList<String> arrayList= new ArrayList<String>(Arrays.asList(arr));
        in.close();

        ComparatorString comparatorString = new ComparatorString();

        Collections.sort(arrayList, comparatorString);

        StringBuilder sb = new StringBuilder();
        for (int i=arr.length-1; i>=0; i--) {
            sb.append(arr[i]);
        }

        System.out.println(10%10);


    }

}

class ComparatorString implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        return -1;
    }
}
