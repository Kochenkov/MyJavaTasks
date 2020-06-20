package from_codewars;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EnoughIsEnough {

    /** my solution */
    public static int[] deleteNth(int[] elements, int maxOccurrences) {

        List<Integer> list = new ArrayList<>();
        for (int i=0; i<elements.length; i++) {
            list.add(elements[i]);
        }

        for (int i=0; i<list.size(); i++) {
            int count = 0;
            Iterator<Integer> iterator = list.iterator();
            while (iterator.hasNext()) {
                Integer n = iterator.next();
                try {
                    if (list.get(i).equals(n)) {
                        count++;
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("выход за пределы массива");
                } finally {
                    if (count>maxOccurrences) {
                        iterator.remove();
                        count--;
                    }
                }
            }
        }

        int[] answer = new int[list.size()];
        for (int i=0; i<list.size(); i++) {
            answer[i]=list.get(i);
        }

        return answer;
    }

    /** best practice
    public static int[] deleteNth(int[] elements, int max) {

        if (max < 1) return new int[0];

        final HashMap<Integer,Integer> map = new HashMap<>();
        final List<Integer> list = new ArrayList<>();

        for (final Integer i : elements) {
            final Integer v = map.put(i, map.getOrDefault(i, 0) + 1);
            if (v == null || v < max) list.add(i);
        }

        return list.stream().mapToInt(i->i).toArray();
    }
     */
}