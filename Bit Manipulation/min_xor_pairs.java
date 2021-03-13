/*
    DSA LEVELUP - Bit Manipulation                                              Date: 13-Mar-2021

1. You are given an array of distinct integers.
2. You have to print all pairs of integers in the array whose XOR value is minimum.
*/

import java.util.*;

public class min_xor_pairs {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt(); 

        int[] arr = new int[n];
        for(int i = 0; i < n; i++) 
            arr[i] = scn.nextInt();

        scn.close();
        solution(arr);
    }

    public static void solution(int[] arr) {
        Arrays.sort(arr); // sort the array

        int minXor = Integer.MAX_VALUE;
        ArrayList<String> res = new ArrayList<>(); 

        for(int i = 0; i < arr.length - 1; i++) {
            int xor = arr[i] ^ arr[i+1]; // only take the xor of the adjacent pairs not all possible pairs of the array
            if(xor < minXor) {
                minXor = xor;
                res = new ArrayList<>(); // refresh the whole arraylist in case of a new min xor
                res.add(arr[i] + ", " + arr[i+1]);
            }
            else if(xor == minXor)
                res.add(arr[i] + ", " + arr[i+1]); // add to the same arraylist in case of other pairs having equal xor value as of min xor value
        }

        for(String val: res)
            System.out.println(val);
    }
}

// a b c d e f such that a < b < c < d < e < f then, in that case (a ^ c) > (a ^ b) or (b ^ c) this condition will always hold in case of sorted array (ascending order)