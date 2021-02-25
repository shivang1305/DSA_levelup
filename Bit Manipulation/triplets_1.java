/*
    DSA LEVELUP - Bit Manipulation                                              Date: 25-Feb-2021

1. You are given an array(arr) of N numbers.
2. You have to select three indices i,j,k following this condition -> 
      0 <= i < j <= k < arr.length
3. Two numbers X and Y as defined as :
      X = arr[i] ^ arr[i+1] ^ ... ^ arr[j - 1]
      Y = arr[j] ^ arr[j+1] ^ ... ^ arr[k]
4. You have to print the number of triplets where X is equal to Y.
*/



import java.util.*;

public class triplets_1 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = scn.nextInt();
        
        scn.close();

        triplets(arr);
    }

    public static void triplets(int[] arr) {
        int tripletCount = 0;
        for(int i = 0; i < arr.length - 1; i++) {
            int val = arr[i]; 
            for(int k = i + 1; k < arr.length; k++) {
                val = val ^ arr[k]; // xor all the values from i to k

                if(val == 0) // when this xor values becomes zero then all the numbers between i & k can be taken as j 
                    tripletCount += (k - i); // so we have (k - i) number of triplets which satisfies the required conditions
            }
        }

        System.out.println(tripletCount);
    }
}
