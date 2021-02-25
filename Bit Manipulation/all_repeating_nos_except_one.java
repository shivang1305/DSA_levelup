/*
    DSA LEVELUP - Bit Manipulation                                              Date: 24-Feb-2021

1. You are given an array of numbers.
2. All numbers occur twice in the array except one.
3. You have to find that number by traversing only once in the array and without using any extra 
   space.
*/

import java.util.*;

public class all_repeating_nos_except_one {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt(); // getting the size of the array

        int[] arr = new int[n];
        for(int i = 0; i < n ; i++) {
            arr[i] = scn.nextInt(); // taking the elements of the array
        }

        scn.close();

        /**
         * XOR has 3 unique properties which helps us in solving this property
         * x ^ x = 0 (it gives zero with the same or duplicate numbers)
         * x ^ 0 = x 
         * x ^ y ^ z = (x ^ y) ^ z = x ^ (y ^ z) Associative property
         */

        int unique = 0;
        for(int val : arr) {
            unique = (unique ^ val); // xor with each value of the array 
        }

        System.out.println(unique); // getting the unique number
    }
}
