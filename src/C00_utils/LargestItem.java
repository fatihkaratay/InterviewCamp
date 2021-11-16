package C00_utils;

import java.util.Arrays;
import java.util.PriorityQueue;

public class LargestItem {
    public static void main(String[] args) {
        int[] numbers = {7, 2, 6, 3};
        int res = largestItem(numbers);
        long res2 = largestItem2(numbers);

        System.out.println(res);
        System.out.println(res2);
    }

    public static int largestItem(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return 0;
        }

        Arrays.sort(numbers);

        return numbers[numbers.length - 1];
    }

    public static long largestItem2(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return 0;
        }

        PriorityQueue<Long> pq =new PriorityQueue<>((x, y) -> Long.compare(y, x));

        for (long num : numbers) {
            pq.add(num);
        }

        return pq.peek();
    }
}
