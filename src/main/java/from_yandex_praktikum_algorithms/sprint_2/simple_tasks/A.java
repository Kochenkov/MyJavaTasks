package from_yandex_praktikum_algorithms.sprint_2.simple_tasks;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class A {

    public static void main(String[] args) throws IOException {
        final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        final StringBuilder sb = new StringBuilder();
        final short lines = Short.parseShort(in.readLine()
                                               .split(" ")[0]);
        final short columns = Short.parseShort(in.readLine()
                                                 .split(" ")[0]);
        String[][] matrix = new String[lines][];
        for (short i = 0; i < lines; i++) {
            matrix[i] = in.readLine().split(" ");
        }
        in.close();

        for (short i = 0; i < columns; i++) {
            for (short j = 0; j < lines; j++) {
                sb.append(matrix[j][i])
                  .append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }
}