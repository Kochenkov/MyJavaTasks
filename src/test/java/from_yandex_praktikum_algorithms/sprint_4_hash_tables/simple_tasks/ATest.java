package from_yandex_praktikum_algorithms.sprint_4_hash_tables.simple_tasks;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static from_yandex_praktikum_algorithms.sprint_4_hash_tables.simple_tasks.A.calculateHash;
import static from_yandex_praktikum_algorithms.sprint_4_hash_tables.simple_tasks.C.findHash;
import static org.junit.Assert.*;

public class ATest {

    private char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};


    private char[] generateCharArray() {
        int randomSize = (int)(Math.random()*22)+4;
        char[] arr = new char[randomSize];
        for (int i=0; i<randomSize; i++) {
            arr[i] = alphabet[(int)(Math.random()*22)+4];
        }
        return arr;
    }

    /**
    * В рамках задачи B по поиску коллизий (4 cпринт)
    */
    @Test
    public void findCollusion() {
        int count = 100000;

        long[] hashArr = new long[count];
        String[] stringArr = new String[count];

        for (int i = 0; i<count; i++) {

            char[] arr = generateCharArray();
            String str = new String(arr);
            long hash = calculateHash(1000,123987123, arr);

            hashArr[i] = hash;
            stringArr[i] = str;

            System.out.println(Arrays.toString(arr));
            System.out.println(hash);
        }

        System.out.println("=======================================================");
        System.out.println("Найдены совпадения: ");

        Arrays.sort(hashArr);

        for (int i=1; i<hashArr.length; i++) {
            if (hashArr[i-1]==hashArr[i]) {
                System.out.println(hashArr[i]);
            }
        }
    }

}