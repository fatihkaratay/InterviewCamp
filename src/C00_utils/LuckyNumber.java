package C00_utils;

public class LuckyNumber {
    public static void main(String[] args) {
        int num = 1221;

        System.out.println(isLuckyNumber(num));
    }

    public static boolean isLuckyNumber(int num) {
        String str =Integer.toString(num);

        if (str.length() % 2 == 1) {
            return false;
        }

        int left = 0, right = str.length() - 1, sum = 0;
        while (left < right) {
            sum += str.charAt(left) - str.charAt(right);
            left++;
            right--;
        }

        return sum == 0 ? true : false;
    }
}
