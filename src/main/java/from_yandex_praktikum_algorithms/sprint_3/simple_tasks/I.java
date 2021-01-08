package from_yandex_praktikum_algorithms.sprint_3.simple_tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//Любители конференций - поиск и сортировка по наиболее часто встречающимся элементам
public class I {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int arraySize = Integer.parseInt(in.readLine().split(" ")[0]);
        String[] strArr = in.readLine().split(" ");
        int k = Integer.parseInt(in.readLine().split(" ")[0]);
        in.close();

        Id[] idsArr = new Id[arraySize];
        idsArr[0] = new Id(Integer.parseInt(strArr[0]));

        int counter = 1;

        for (int i=1; i<arraySize; i++) {
            int x = Integer.parseInt(strArr[i]);
            for (int j=0; j<idsArr.length; j++) {
                if (idsArr[j]!=null) {
                    if (x==idsArr[j].value) {
                        idsArr[j].amount++;
                        break;
                    }
                } else {
                    idsArr[j] = new Id(x);
                    counter++;
                    break;
                }
            }
        }

        Sorter sorter = new Sorter();
        sorter.quickSort(idsArr, 0, counter-1);

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<k; i++) {
            sb.append(idsArr[i].value).append(" ");
        }

        System.out.println(sb.toString());

    }

}

class Id {
    public int value;
    public int amount;

    Id(int value) {
        this.value = value;
        this.amount = 1;
    }

    int compare(Id otherId) {
        if (this.amount > otherId.amount) {
            return 1;
        } else if (this.amount==otherId.amount) {
            if (this.value<otherId.value) {
                return 1;
            } else if (this.value==otherId.value){
                return 0;
            }else {
                return -1;
            }
        } else {
            return -1;
        }
    }

    public String toString() {
        return this.value + " value amount is: " + this.amount + "|";
    }
}

class Sorter {

    public void quickSort(Id[] inputArr, int from, int to) {
        if (from<to) {
            int divideIndex = partition(inputArr, from, to);
            quickSort(inputArr, from, divideIndex-1);
            quickSort(inputArr, divideIndex, to);
        }
    }

    private static int partition(Id[] arr, int from, int to) {
        int rightIndex = to;
        int leftIndex = from;

        Id pivot = arr[from + (to-from)/2];

        while (leftIndex <= rightIndex) {

            while (arr[leftIndex].compare(pivot)>0) {
                leftIndex++;
            }

            while (arr[rightIndex].compare(pivot)<0) {
                rightIndex--;
            }

            if (leftIndex<=rightIndex) {
                swap(arr, leftIndex, rightIndex);
                leftIndex++;
                rightIndex--;
            }
        }
        return leftIndex;
    }

    private static void swap(Id[] arr, int index1, int index2) {
        Id temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}

