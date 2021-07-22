package reversetraverse;

public class Problem02 {
    public static void main(String[] args) {
        String str1 = "I live in a house";
        String str2 = "hello";
        String str3 = "a";
        String str4 = "";
        String str5 = null;
        String str6 = "     this is test    ";
        String str7 = "I live in a house     ";

        System.out.println(reverseWords(str1));
        System.out.println(reverseWords(str2));
        System.out.println(reverseWords(str3));
        System.out.println(reverseWords(str4));
        System.out.println(reverseWords(str5));
        System.out.println(reverseWords(str6));
        System.out.println(reverseWords(str7));
    }

    public static String reverseWords(String str) {
        if (str == null || str.length() == 0)
            return "";

        StringBuilder sb = new StringBuilder();
        String[] strArr = str.split(" ");

        for (int i = strArr.length - 1; i>= 0; i--) {
            sb.append(strArr[i] + " ");
        }

        return "|" + sb.toString().trim() + "|";
    }
}
