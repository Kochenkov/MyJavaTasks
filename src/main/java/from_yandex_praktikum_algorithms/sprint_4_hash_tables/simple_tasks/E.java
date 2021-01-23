package from_yandex_praktikum_algorithms.sprint_4_hash_tables.simple_tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class E {

    public static void main(String[] args) throws IOException {
        final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String inArr = in.readLine();


        System.out.println(getUniqueCharacterSubstring(inArr).length());

    }

    static String getUniqueCharacterSubstring(String input) {
        Map<Character, Integer> visited = new HashMap<>();

        String output = "";

        int start = 0;

        for (int end = 0; end < input.length(); end++) {
            char currChar = input.charAt(end);

            if (visited.containsKey(currChar)) {
                start = Math.max(visited.get(currChar)+1, start);
            }
            if (output.length() < end - start + 1) {
                output = input.substring(start, end + 1);
            }
            visited.put(currChar, end);
        }
        return output;
    }

}
