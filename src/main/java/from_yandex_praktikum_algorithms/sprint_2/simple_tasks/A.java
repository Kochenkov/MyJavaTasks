package from_yandex_praktikum_algorithms.sprint_2.simple_tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//todo превышен лемит по-памяти
public class A {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        short lines = Short.parseShort(in.readLine()
                                         .split(" ")[0]);
        short columns = Short.parseShort(in.readLine()
                                           .split(" ")[0]);
        short[][] matrix = new short[lines][columns];
        for (short i = 0; i < lines; i++) {
            String[] inStr = in.readLine()
                               .split(" ");
            for (short j = 0; j < columns; j++) {
                matrix[j][i] = Short.parseShort(inStr[j]);
                //log
                System.out.print(matrix[j][i] + " ");
            }
            System.out.println();
        }
        in.close();

    }
}