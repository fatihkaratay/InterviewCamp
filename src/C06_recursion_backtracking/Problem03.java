package C06_recursion_backtracking;

/*
Level: Medium
Phone Number Mnemonics: Given an N digit phone number, print all the strings that can
be made from that phone number. Since 1 and 0 don't correspond to any characters, ignore
them.

For example:
213 => AD, AE, AF, BD, BE, BF, CE, CE, CF
456 => GJM, GJN, GJO, GKM, GKN, GKO,.. etc
 */

import java.util.HashMap;
import java.util.Map;

public class Problem03 {
    public static void main(String[] args) {


        int[] phoneNumbers = {2, 1, 3};

        printPhone(phoneNumbers);
    }

    public static void printPhone(int[] phoneNumber) {
        if (phoneNumber == null || phoneNumber.length == 0)
            return;
        char[] buffer = new char[phoneNumber.length];
        backtrack(phoneNumber, buffer, 0, 0);
    }

    private static void backtrack(int[] arr, char[] buffer, int startIndex, int bufferIndex) {
        if (bufferIndex >= buffer.length || startIndex >= arr.length) {
            printArray(buffer);
            return;
        }

        // find the candidates
        char[] letters = getLetters(arr[startIndex]);
        if (letters.length == 0) {
            backtrack(arr, buffer, startIndex + 1, bufferIndex);
        }

        for (char letter : letters) {
            buffer[bufferIndex] = letter;
            backtrack(arr, buffer, startIndex + 1, bufferIndex + 1);
        }
    }

    private static char[] getLetters(int index) {
        Map<Integer, String> phone = new HashMap<>();
        phone.put(0, "");
        phone.put(1, "");
        phone.put(2, "ABC");
        phone.put(3, "DEF");
        phone.put(4, "GHI");
        phone.put(5, "JKL");
        phone.put(6, "MNO");
        phone.put(7, "PQRS");
        phone.put(8, "TUV");
        phone.put(9, "WXYZ");

        char[] result = phone.get(index).toCharArray();

        return result;
    }

    private static void printArray(char[] arr) {
        for (char item : arr)
            System.out.print(item + " ");
        System.out.println();
    }
}
