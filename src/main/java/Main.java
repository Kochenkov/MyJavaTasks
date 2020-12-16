import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<Integer> arr = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        //long time1 = System.currentTimeMillis();
        arr.add(1);
        arr.add(1);
        Scanner scan = new Scanner(System.in);
        int unit = scan.nextInt();
        scan.close();
        System.out.println(find(unit));
        //long time2 = System.currentTimeMillis();
        //long time3 = time2 - time1;
        //System.out.println(time3/1000);
    }

    public static int find(int number) {
        int[] array = new int[number+1];
        for (int j=0; j<=number; j++) {
            if (j<=1) {
                array[j] = 1;
                //System.out.println(array[j]);
            } else {
                array[j] = array[j-1] + array[j-2];
                //System.out.println(array[j]);
            }
        }
        return array[number];
    }


//    Спринт 2. Задача: K.Рекурсивные числа Фибоначчи
//    Компилятор: Oracle Java 8
//    Вердикт: Превышен лимит времени исполнения
//    Статус: Частичное решение
//    Посылка 45543909
//
//    Написал простейшую рекурсивную функцию по поиску чисел фибоначчи, но падаю на последнем тесте по времени исполнения. Не могу представить, что там может зависнуть. Подскажите, с компилятором точно все в порядке?
}