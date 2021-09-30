package C05_binary_search;

public class Problem01 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5, 7, 8, 11};
        int target1 = 2;
        int target2 = 11;
        int target3 = 25;

        System.out.println(binarySearch(arr, target1));
        System.out.println(binarySearch(arr, target2));
        System.out.println(binarySearch(arr, target3));
    }

    public static int binarySearch(int[] arr, int target) {
        int start = 0, end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target > arr[mid]) start = mid + 1;
            else if (target < arr[mid]) end = mid - 1;
            else return mid;
        }

        return -1;
    }
}
