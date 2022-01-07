package C00_utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortByHeight {
    public static void main(String[] args) {
        int[] a = {-1, 150, 190, 170, -1, -1, 160, 180};
        // solution(a) = [-1, 150, 160, 170, -1, -1, 180, 190]
        System.out.println(Arrays.toString(sortByHeight(a)));
    }

    public static int[] sortByHeight(int[] a) {
        List<Integer> treeList = new ArrayList<>();
        List<Integer> humanList = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            if (a[i] == -1) {
                treeList.add(i);
            } else {
                humanList.add(a[i]);
            }
        }

        Collections.sort(humanList);
        int[] result = new int[a.length];
        for (int num : treeList) {
            result[num] = -1;
        }

        int tree = 0, human = 0;
        while (tree < result.length && human < humanList.size()) {
            if (result[tree] == -1) {
                tree++;
            } else {
                result[tree] = humanList.get(human);
                tree++;
                human++;
            }
        }
        return result;
    }
}
