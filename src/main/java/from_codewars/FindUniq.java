package from_codewars;

import java.util.HashMap;

public class FindUniq {

    /** my solution */
    public static double findUniqNumber(double arr[]) {

        HashMap<Double, Integer> map = new HashMap<>();

        for(int i=0; i<arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        for(Double key: map.keySet()) {
            if (map.get(key).equals(1)) {
                return key;
            }
        }
        throw new RuntimeException("уникальный элемент не найден");
    }
}
