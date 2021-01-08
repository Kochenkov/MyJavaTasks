package from_yandex_praktikum_algorithms.sprint_3.final_tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//решил!!
public class B {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int arraySize = Integer.parseInt(in.readLine().split(" ")[0]);

        Scholar[] scholars = new Scholar[arraySize];

        for (int i=0; i<arraySize; i++) {
            String[] str = in.readLine().split(" ");
            scholars[i] = new Scholar(str[0], Integer.parseInt(str[1]), Integer.parseInt(str[2]));
        }
        in.close();

        ScholarSorter sorter = new ScholarSorter();
        sorter.quickSort(scholars, 0, scholars.length-1);

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<scholars.length; i++) {
            sb.append(scholars[i].nick)
              .append("\n");
        }
        System.out.println(sb.toString());
    }
}

class Scholar {
    String nick;
    int score;
    int penalty;

    Scholar(String nick, int score, int penalty) {
        this.nick = nick;
        this.score = score;
        this.penalty = penalty;
    }

    int compare(Scholar otherScholar) {
        if (this.score > otherScholar.score) {
            return 1;
        } else if (this.score==otherScholar.score) {
            if (this.penalty < otherScholar.penalty) {
                return 1;
            } else if (this.penalty==otherScholar.penalty) {
                int compare = this.nick.compareTo(otherScholar.nick);
                if (compare==0) {
                    return 0;
                } else if (compare<0) {
                    return 1;
                } else {
                    return -1;
                }
            } else {
                return -1;
            }
        } else {
            return -1;
        }
    }
}

class ScholarSorter {

    public void quickSort(Scholar[] inputArr, int from, int to) {
        if (from<to) {
            int divideIndex = partition(inputArr, from, to);
            quickSort(inputArr, from, divideIndex-1);
            quickSort(inputArr, divideIndex, to);
        }
    }

    private static int partition(Scholar[] arr, int from, int to) {
        int rightIndex = to;
        int leftIndex = from;

        Scholar pivot = arr[from + (to-from)/2];

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

    private static void swap(Scholar[] arr, int index1, int index2) {
        Scholar temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
