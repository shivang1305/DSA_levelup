/*
    DSA LEVELUP - Bit Manipulation                                              Date: 10-Mar-2021

1. You are given an array of n numbers.
2. You have to find the sum of bit differences in all pairs that can be formed from n numbers.
3. Bit difference of two numbers is defined as the count of different bits at same positions in binary representations of two numbers.

*/

import java.util.*;

public class sum_of_bit_diff_among_all_pairs {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++)
            arr[i] = scn.nextInt();
        
        scn.close();

        solution(arr);
    }

    public static long solution(int[] arr) {
        long ans = 0;

        for(int i = 0; i < 32; i++) { // for 32 bits in an integer (traversing through every bit) 
            
            long countOn = 0; // numbers which have on bit in the current bit bucket
            
            for(int val : arr) { // traversing through all the numbers of the array
                
                if((val & (1 << i)) != 0) // if the current bit of the number is on 
                    countOn++;
            }

            long countOff = arr.length - countOn; // all the numbers except whose current bit is on

            long diff = countOn * countOff * 2; // *2 for duplicate pairs

            ans += diff;
        }

        return ans;
    }
}
