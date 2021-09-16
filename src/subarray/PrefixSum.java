package subarray;
/*
(Level: Medium) Given an array of integers,
find the contiguous subarray that sums to 0.
The array can contain both negative and positive integers.

For example: Input = [2,4,-2,1,-3,5,-3], Result = [4,-2,1,-3]
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PrefixSum {
    public static void main(String[] args) {
        int[] arr1 = {2,4,-2,1,-3,5,-3};
        int[] arr = {-1, 2, 1, -4, 2, 3, -1, 2};
        System.out.println(Arrays.toString(prefixSum(arr)));
    }

    public static int[] prefixSum(int[] arr) {
        if (arr == null || arr.length == 0) throw new IllegalArgumentException();
        int sum = 0;
        int[] sumArray = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            sumArray[i] = sum;
        }

        int isZeroIncluded = isZeroIncluded(sumArray); // -1 or index
        if (isZeroIncluded != -1) {
            return new int[]{ 0, isZeroIncluded};
        }

        int[] isDuplicateIncluded = isDuplicateIncluded(sumArray);
        if (isDuplicateIncluded[0] != -1 && isDuplicateIncluded[1] != -1) {
            return new int[] {isDuplicateIncluded[0] + 1, isDuplicateIncluded[1]};
        }

        System.out.println(Arrays.toString(sumArray));
        return null;
    }

    private static int isZeroIncluded(int[] arr) {
        for (int i = 0; i < arr.length; i++){
            if (arr[i] == 0) {
                return i;
            }
        }
        return -1;
    }

    @SuppressWarnings("Java8MapApi")
    private static int[] isDuplicateIncluded(int[] arr) {
        int[] result = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int element : arr) {
            if(map.get(element) == null) {
                map.put(element, 1);
            } else {
                map.put(element, map.get(element) + 1);
            }
        }

        final int[] index = {0};
        map.forEach((k,v) -> {
            if (v == 2) {
                index[0] = k;
            }
        });

        int[] dupIndex = new int[2];
        int i = 0, k = 0;
        while (i < arr.length) {
            if (arr[i] == index[0]) {
                dupIndex[k++] = i;
            }
            i++;
        }
//        for (int i = 0; i < arr.length; i++) {
//            if (arr[i] == index[0]) {
//                for (int j = 0; j < 2; j++) {
//                    dupIndex[j] = i;
//                }
//            }
//        }

        return dupIndex;

    }


}
