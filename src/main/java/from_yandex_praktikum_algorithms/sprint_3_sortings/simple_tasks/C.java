package from_yandex_praktikum_algorithms.sprint_3_sortings.simple_tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class C {

    public static void main(String[] args) throws IOException {
        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
        char[] findStrArr = scan.readLine().toCharArray();
        char[] initialStrArr = scan.readLine().toCharArray();
        //scan.close();
        // System.out.print(findStrArr);
        int pos = 0;
        boolean isEquals = false;
        if (findStrArr.length==0){
            isEquals=true;
        } else if (findStrArr.length>initialStrArr.length) {
            isEquals = false;
        } else {
            for (int i = 0; i < initialStrArr.length; i++) {
                if (initialStrArr[i]==findStrArr[pos]) {
                    isEquals = true;
                    pos++;
                    if (pos==findStrArr.length) {
                        break;
                    }
                }
            }
            if (pos!=findStrArr.length) {
                isEquals = false;
            }
        }


        if (isEquals) {
            System.out.print("True");
        } else {
            System.out.print("False");
        }
    }

//    public static void main(String[] args) throws IOException {
//        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
//        String[] findStrArr = scan.readLine().split("");
//        String[] initialStrArr = scan.readLine().split("");
//        scan.close();
//        // System.out.print(findStrArr);
//        int pos = 0;
//        boolean isEquals = false;
//        if (findStrArr[0]
//                .equals("")) {
//            isEquals = true;
//        } else if (findStrArr.length>initialStrArr.length) {
//            isEquals = false;
//        } else {
//            for (int i = 0; i < initialStrArr.length; i++) {
//                if (initialStrArr[i].equals(findStrArr[pos])) {
//                    isEquals = true;
//                    pos++;
//                    if (pos==findStrArr.length) {
//                        break;
//                    }
//                }
//            }
//            if (pos!=findStrArr.length) {
//                isEquals = false;
//            }
//        }
//
//
//        if (isEquals) {
//            System.out.print("True");
//        } else {
//            System.out.print("False");
//        }
//    }


}
