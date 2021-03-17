/*
    DSA LEVELUP - Bit Manipulation                                              Date: 16-Mar-2021

1. You are given an integer N.
2. You have to find the N-th number whose binary representation is a palindrome.

Note -> First binary number whose representation is a palindrome is 1.
*/

import java.util.*;

public class nth_palindromic_array {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int N = scn.nextInt();

        scn.close();

        System.out.println(nthPalindromicBinary(N));
    }

    public static int nthPalindromicBinary(int n) {
        int count = 0, len = 0;
        while(count <= n) {
            len++;
            count += (1 << (len - 1) / 2);
        }

        count -= (1 << (len - 1) / 2);
        int offset = n - count - 1;

        int ans = (1 << (len - 1));
        ans |= (offset << (len / 2));

        int revVal = (ans >> (len / 2));
        int rev = getRev(revVal);

        ans |= rev;

        return ans;
    }

    public static int getRev(int n) {
        int rev = 0;
        
        while(n != 0) {
            int lb = (n & 1);
            rev |= lb;

            rev <<= 1;
            n >>= 1;
        }

        rev >>= 1;
        return rev;
    }
}