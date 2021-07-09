import java.util.*;

public class longest_palindromic_substring {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        scn.close();

        System.out.print(longestPalindromicSubstring(str));
    }

    static int resultStart;
    static int resultLength;

    public static String longestPalindromicSubstring(String s) {
        int strLength = s.length();
        if(strLength < 2)   
            return s;

        for(int i = 0; i < strLength - 1; i++) {
            expandRange(s, i, i);
            expandRange(s, i, i+1);
        }

        return s.substring(resultStart, resultStart + resultLength);
    }

    private static void expandRange(String str, int begin, int end) {
        while(begin >= 0 && end < str.length() && str.charAt(begin) == str.charAt(end)) {
            begin--;
            end++;
        }

        if(resultLength < end - begin - 1) {
            resultStart = begin + 1;
            resultLength = end - begin - 1;
        }
    }
}
