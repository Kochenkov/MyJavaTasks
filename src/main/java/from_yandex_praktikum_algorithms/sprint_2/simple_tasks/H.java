package from_yandex_praktikum_algorithms.sprint_2.simple_tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Задача со скобками

/**
1) иду по строке и проверяю скобки на единичные случаи
        2) если есть, то удаляю
        3) повторяю много раз
        4) проверяю, осталось ли что-то в строке. Если да, то false, если нет, то true
 */


//todo подумать потом
public class H {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> bracketsArray = new ArrayList<>(Arrays.asList(in.readLine().split("")));

        System.out.println(bracketsArray);


    }

    private static boolean equivalent(String firstBr, String secongBr) {
        //todo
        return true;
    }


}
