/*
    DSA LEVELUP - Bit Manipulation                                              Date: 04-Mar-2021

1. You are given an array of integers.
2. You have to find the XOR of sum of all pairs in the array.
*/

import java.util.*;

public class xor_sum_of_pairs {

    public static int solution(int[] arr){
       int ans = 0;
       
       for(int val : arr)
        ans = ans ^ (2 * val); // since only 2a, 2b, 2c, 2d are left and rest all other pairs are cancelled in the xor as xor of same numbers are 0
       
       return ans;
    }
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n; i++){
            arr[i] = scn.nextInt();
        }
        scn.close();
        System.out.println(solution(arr));
    }
    
    
}