package from_yandex_praktikum_algorithms.sprint_4_hash_tables.final_tasks;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Задача на построение поискового индекса
 */

public class A {

    public static void main(String[] args) throws IOException {
        final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        final BufferedWriter out = new BufferedWriter(new FileWriter("output.txt"));

        //размер массива с документами
        final int documentsSize = Integer.parseInt(in.readLine().split(" ")[0]);

        //создаем массив документов со словами (ключ) и их колличеством (значение) в каждом документе
        Map<String, Integer>[] documentMapsArray = new HashMap[documentsSize];

        //наполняем documentMapsArray из ввода
        for (int i = 0; i < documentsSize; i++) {
            String[] str = in.readLine().split(" ");
            documentMapsArray[i] = new HashMap<>();
            for (String key : str) {
                Integer value;
                if (documentMapsArray[i].get(key) != null) {
                    value = documentMapsArray[i].get(key);
                    value++;
                    documentMapsArray[i].put(key, value);
                } else {
                    value = 1;
                    documentMapsArray[i].put(key, value);
                }
            }
        }

        //размер массива с поисковыми запросами
        final int requestsSize = Integer.parseInt(in.readLine().split(" ")[0]);

        //создаем массив запросов со словами для поиска
        String[][] wordRequestsArray = new String[documentsSize][];

        //создаем массив массивов вхождений куда будем класть ответ
        Element[][] resultArr = new Element[requestsSize][documentsSize];

        //ввод неповторяющихся слов, с помощью мапы
        for (int i = 0; i < requestsSize; i++) {
            String[] str = in.readLine().split(" ");
            Map<String, String> map = new HashMap<>();
            // wordRequestsMapArray[i] = new HashMap<>();
            for (String key : str) {
                map.put(key, key);
            }
            wordRequestsArray[i] = map.keySet().toArray(new String[0]);

            //==================
            //|| сам алгоритм ||
            //==================

            //иду по всем документам
            for (int k = 0; k < documentMapsArray.length; k++) {
                Integer numberOfOccurrencesInDocument = 0;
                //итерируюсь по массиву со словами из запроса
                for (int j = 0; j < wordRequestsArray[i].length; j++) {

                    if (documentMapsArray[k].get(wordRequestsArray[i][j]) != null) {
                        numberOfOccurrencesInDocument += documentMapsArray[k].get(wordRequestsArray[i][j]);
                    }
                }
                resultArr[i][k] = new Element(k, numberOfOccurrencesInDocument);
            }
            Arrays.sort(resultArr[i]);
        }

        in.close();

        //вывод результатов
        for (int i=0; i<resultArr.length; i++) {
            int count = 0;
            for (int j=0; j<resultArr[i].length; j++) {
                if (count<5) {
                    count++;
                    if (resultArr[i][j].value!=0) {
                       out.write(resultArr[i][j].position+1 + " ");
                    }
                } else {
                    break;
                }
            }
            out.write("\n");
        }

    }
}

class Element implements Comparable {

    Integer position;
    Integer value;

    Element(Integer position, Integer value) {
        this.position = position;
        this.value = value;
    }

    @Override
    public int compareTo(Object o) {
        Element inElement = (Element) o;
        if (this.value > inElement.value) {
            return -1;
        } else if ((this.value.equals(inElement.value))) {
            return 0;
        } else {
            return 1;
        }
    }

    //для дебага
    @Override
    public String toString() {
        return this.position + 1 + " " + this.value + "; ";
    }
}