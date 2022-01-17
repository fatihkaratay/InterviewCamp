package C00_utils;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class InBalanceSum {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(2);
        list.add(2);

        System.out.println(list);

        int sum = inBalancedSum(list);
        System.out.println(sum);
    }

    public static int inBalancedSum(List<Integer> list) {
        // find all subsets excluding the empty list.
        List<List<Integer>> subsets = findSubSets(list);
        System.out.println(subsets);
        // loop all of them and find min, max and balance = max - min
        // get the sum of those and return.
        return 0;
    }

    private static List<List<Integer>> findSubSets(List<Integer> list) {
        List<List<Integer>> result = new ArrayList<>();
        list.sort((a, b) -> a - b);
        backtrack(list, result, new ArrayList(), new boolean[list.size()], 0);

        return result;
    }

    private static void backtrack2(List<Integer> list, List<List<Integer>> result, ArrayList<Integer> memo, boolean[] used, int start) {
        result.add(new ArrayList<>(memo));

        for (int i = start; i < list.size(); i++) {
            if (used[i] || i > 0 && list.get(i) == list.get(i - 1) && !used[i - 1]) continue;
            memo.add(list.get(i));
            used[i] = true;
            backtrack(list, result, memo, used, i + 1);
            used[i] = false;
            memo.remove(memo.size() - 1);
        }
    }

    private static void backtrack(List<Integer> list, List<List<Integer>> result, ArrayList<Integer> memo, boolean[] used, int start) {
        result.add(new ArrayList<>(memo));

        for (int i = start; i < result.size(); i++) {
            if (used[i] || i > 0 && list.get(i) == list.get(i - 1) && !used[i-1]) continue;
            memo.add(list.get(i));
            used[i] = true;
            backtrack(list, result, memo, used, i + 1);
            used[i] = false;
            memo.remove(memo.size() - 1);
        }
    }

    private static int findMax (List<Integer> list) {
        int max = 0;
        for (int num : list)
            max = Math.max(max, num);

        return max;
    }

    private static int findMin(List<Integer> list) {
        int min = list.size() > 0 ? list.get(0) : 0;
        for (int num : list)
            min = Math.min(min, num);

        return min;
    }
}
