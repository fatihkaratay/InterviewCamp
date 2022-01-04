package C00_utils;

import java.util.*;

public class AllLongestString {
    public static void main(String[] args) {
        String[] strArr = {"aba", "aa", "ad", "vcd", "aba"}; // returns ["aba", "vcd", "aba"]

        String[] result = allLongestStrings(strArr);

        System.out.println(Arrays.toString(result));
    }

    public static String[] allLongestStrings(String[] inputArray) {
        if (inputArray.length == 0 || inputArray == null) {
            return new String[]{};
        }

        Map<Integer, List<String>> map = new HashMap<>();
        int max = 0;
        for (String str : inputArray) {
            int key = str.length();
            if (map.get(key) == null) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);

            max = Math.max(max, key);
        }
        String[] array = map.get(max).toArray(new String[0]);

        return array;
    }
}
