package C00_utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommonCharacterCount {
    public static void main(String[] args) {
        String s1 = "aabcc";
        String s2 = "adcaa"; // solution(s1, s2) = 3.

        System.out.println(commonCharacterCount(s1, s2));
    }

    public static int commonCharacterCount(String s1, String s2) {
        if (s1 == null || s2 == null) {
            return 0;
        }

        int count = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s2.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        for (char c : s1.toCharArray()) {
            if (map.containsKey(c) && map.get(c) > 0) {
                count++;
                map.put(c, map.get(c) - 1);
            }
        }

        return count;
    }

}
