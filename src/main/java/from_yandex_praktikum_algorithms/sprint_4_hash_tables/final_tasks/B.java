package from_yandex_praktikum_algorithms.sprint_4_hash_tables.final_tasks;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

/**
 * Реализация своей Map-ы
 */
public class B {

    private static final String GET = "get";
    private static final String PUT = "put";
    private static final String DELETE = "delete";

    public static void main(String[] args) throws IOException {
        final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        final BufferedWriter out = new BufferedWriter(new FileWriter("output.txt"));

        final int commandsSize = Integer.parseInt(in.readLine().split(" ")[0]);

        final HashTable hashTable = new HashTable();

        for (int i = 0; i < commandsSize; i++) {
            String[] command = in.readLine().split(" ");
            Integer key;
            Integer value;
            switch (command[0]) {
                case (GET):
                    key = Integer.parseInt(command[1]);
                    out.write(hashTable.get(key));
                    out.newLine();
                    break;
                case (PUT):
                    key = Integer.parseInt(command[1]);
                    value = Integer.parseInt(command[2]);
                    hashTable.put(key, value);
                    break;
                case (DELETE):
                    key = Integer.parseInt(command[1]);
                    out.write(hashTable.delete(key));
                    out.newLine();
                    break;
                default:
                    throw new IllegalArgumentException();
            }
        }
        in.close();
        out.close();
    }

}

class HashTable {

    class Element {

        Integer key;
        Integer value;

        Element(Integer key, Integer value) {
            this.value = value;
            this.key = key;
        }
    }

    private static final String NONE = "None";
    
    private int capacity;
    private List<Element>[] bucket;
    
    HashTable() {
        this.capacity = 100000;
        this.bucket = new LinkedList[capacity];
    }


    public void put(Integer key, Integer value) {
        Integer bucketNumber = selectBucketNumber(key);
        if (bucket[bucketNumber] == null) {
            bucket[bucketNumber] = new LinkedList<>();
            bucket[bucketNumber].add(new Element(key, value));
        } else {
            boolean keyIsPresent = false;
            for (int i = 0; i < bucket[bucketNumber].size(); i++) {
                if (bucket[bucketNumber].get(i).key.equals(key)) {
                    keyIsPresent = true;
                    //заменяем значение, если нашли по ключу
                    bucket[bucketNumber].get(i).value = value;
                }
            }
            //добавляем значение, если не нашли по ключу
            if (!keyIsPresent) {
                bucket[bucketNumber].add(new Element(key, value));
            }
        }

    }

    public String get(Integer key) {
        Integer bucketNumber = selectBucketNumber(key);
        if (bucket[bucketNumber] != null) {
            for (int i = 0; i < bucket[bucketNumber].size(); i++) {
                if (bucket[bucketNumber].get(i).key.equals(key)) {
                    return bucket[bucketNumber].get(i).value.toString();
                }
            }
        }
        return NONE;
    }

    public String delete(Integer key) {
        Integer bucketNumber = selectBucketNumber(key);
        if (bucket[bucketNumber] != null) {
            for (int i = 0; i < bucket[bucketNumber].size(); i++) {
                if (bucket[bucketNumber].get(i).key.equals(key)) {
                    String value = bucket[bucketNumber].get(i).value.toString();
                    bucket[bucketNumber].remove(i);
                    return value;
                }
            }
        }
        return NONE;
    }

    private Integer selectBucketNumber(Integer key) {
        return key % capacity;
    }
}
