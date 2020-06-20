package from_codewars;

import java.util.Arrays;

public class Bowling {

    /** my solution */
    public String bowlingPins(int[] arr) {
        String str = "";
        String str4 = "I I I I";
        String str3 = " I I I ";
        String str2 = "  I I  ";
        String str1 = "   I   ";
        String[] strArr4 = str4.split("");
        String[] strArr3 = str3.split("");
        String[] strArr2 = str2.split("");
        String[] strArr1 = str1.split("");

        int count = 0;

        for (int i = 0; i < strArr1.length; i++) {
            if (strArr1[i].contains("I")) {
                count += 1;
                for (int j : arr) {
                    if (j == count) {
                        strArr1[i] = " ";
                    }
                }
            }
        }

        for (int i = 0; i < strArr2.length; i++) {
            if (strArr2[i].contains("I")) {
                count += 1;
                for (int j : arr) {
                    if (j == count) {
                        strArr2[i] = " ";
                    }
                }
            }
        }

        for (int i = 0; i < strArr3.length; i++) {
            if (strArr3[i].contains("I")) {
                count += 1;
                for (int j : arr) {
                    if (j == count) {
                        strArr3[i] = " ";
                    }
                }
            }
        }

        for (int i = 0; i < strArr4.length; i++) {
            if (strArr4[i].contains("I")) {
                count += 1;
                for (int j : arr) {
                    if (j == count) {
                        strArr4[i] = " ";
                    }
                }
            }
        }

        str = Arrays.toString(strArr4) + "\n" +
                Arrays.toString(strArr3) + "\n" +
                Arrays.toString(strArr2) + "\n" +
                Arrays.toString(strArr1);
        return str.replace(", ", "")
                  .replace("[", "")
                  .replace("]", "");
    }

    /** best practice
    public String bowlingPins(int[] arr) {
        String s = "7 8 9 0\n 4 5 6 \n  2 3  \n   1   ";
        for (int n : arr) s = s.replace(""+n%10," ");
        return s.replaceAll("\\d","I");
    }
    */
}