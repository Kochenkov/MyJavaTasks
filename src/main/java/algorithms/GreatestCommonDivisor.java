package algorithms;

public class GreatestCommonDivisor {

    public static int findDivisor(int[] arr) {
        int a = arr[0];
        int b = arr[1];
        if (a==0) {
            return b;
        } else if (b==0) {
            return a;
        } else if (a>b) {
            int del = a%b;
            int[] arr1 = {del, b};
            return findDivisor(arr1);
        } else {
            int del = b%a;
            int[] arr2 = {a, del};
            return findDivisor(arr2);
        }
    }
}
