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
        while(count < n) {
            len++;
            count += (1 << (len - 1) / 2);
        }

        count -= (1 << (len - 1) / 2);
        int offset = n - count - 1;

        int ans = (1 << (len - 1)); // putting the first bit as 1 and rest as zero upto len 
        ans |= (offset << (len / 2)); // setting the offset in the answer

        int revVal = (ans >> (len / 2)); // shifting the number towards right
        int rev = getRev(revVal); // obtaining the reverse of the number

        ans |= rev; // adding the ans & reverse number

        return ans;
    }

    public static int getRev(int n) {
        int rev = 0;
        
        while(n != 0) {
            int lb = (n & 1); // to get the lowest bit
            rev |= lb;

            rev <<= 1; // left shift
            n >>= 1; // right shift
        }

        rev >>= 1; // left shift
        return rev;
    }
}