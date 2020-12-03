package from_yandex_praktikum_algorithms.sprint_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task1 {

    public static void main(String[] args) throws IOException {
        //ввод
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(in.readLine());
        String[] street = in.readLine()
                            .split(" ");

        //находим позиции всех нулей во входящем массиве
        List<Integer> zeroPositionsList = new ArrayList<>();
        System.out.println("массив с нулями: ");
        for (int i = 0; i < street.length; i++) {
            if (street[i].equals("0")) {
                zeroPositionsList.add(i);
                //логи
                System.out.print(i + " ");
            }
        }
        //логи
        System.out.println("");

        //находим позиции, по которым будем делить входной массив
        List<Integer> cuttingPositionsList = new ArrayList<>();
        System.out.println("массив с позициями для разрезания: ");
        if (zeroPositionsList.size() > 1) {
            for (int i = 0; i < zeroPositionsList.size() - 1; i++) {
                int a = zeroPositionsList.get(i);
                int b = zeroPositionsList.get(i + 1);
                int c = (b - a) / 2 + a;
                cuttingPositionsList.add(c);
                //логи
                System.out.print(c + " ");
            }
        }
        //логи
        System.out.println("");

        //делим входной массив на суб-массивы
        String[][] cuttingArrays = new String[cuttingPositionsList.size()+1][];
        if (cuttingPositionsList.size()==0) {
            cuttingArrays[0] = street;
        } else if (cuttingPositionsList.size()==1) {
            cuttingArrays[0] = Arrays.copyOfRange(street, 0, cuttingPositionsList.get(0));
            cuttingArrays[1] = Arrays.copyOfRange(street, cuttingPositionsList.get(0), street.length);
        } else {
            cuttingArrays[0] = Arrays.copyOfRange(street, 0, cuttingPositionsList.get(0)+1);
            for (int i=0; i<cuttingPositionsList.size()-1; i++) {
                cuttingArrays[i+1] = Arrays.copyOfRange(street, cuttingPositionsList.get(i)+1, cuttingPositionsList.get(i+1)+1);
            }
            cuttingArrays[cuttingPositionsList.size()] = Arrays.copyOfRange(street, cuttingPositionsList.get(cuttingPositionsList.size()-1)+1, street.length);
        }

       //логи
        for (int i=0; i<cuttingArrays.length; i++) {
            System.out.println(Arrays.toString(cuttingArrays[i]));
        }

        //todo написать одну функцию под все массивы - определение расстояния до нуля

    }

}
