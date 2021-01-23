package from_yandex_praktikum_algorithms.sprint_4_hash_tables.simple_tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Задача по вычеслению хеша методом Горнера
 */
public class A {

    public static void main(String[] args) throws IOException {
        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(scan.readLine().split(" ")[0]);
        int m = Integer.parseInt(scan.readLine().split(" ")[0]);
        char[] charArr = scan.readLine().toCharArray();
        scan.close();



        System.out.println(calculateHash(a, m, charArr));
    }

    public  static long calculateHash(int a, int m, char[] charArr) {
        long hash = 0;

        if (charArr.length==1) {

            hash = charArr[0];

        } else if (charArr.length>1) {

            hash = (charArr[0]*a+charArr[1])%m;

            for (int i=2; i<charArr.length; i++) {
                hash = (hash*a + charArr[i])%m;
            }
        }
        return hash;
    }
}