/*
    DSA LEVELUP - Bit Manipulation                                              Date: 25-Feb-2021

1. You are given an array of length n containing numbers from 1 to n.
2. One number is present twice in array and one is missing.
3. You have to find these two numbers.
*/


import java.util.*;

public class one_repeating_one_missing {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt(); // size of the array

        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = scn.nextInt();

        scn.close();

        solution(arr);
    }

    public static void solution(int[] arr) {
        int xor = 0;
        for(int val : arr) 
            xor = xor ^ val; // take the xor of all the numbers of the array
        
        for(int i = 1; i <= arr.length; i++)
            xor = xor ^ i; // create a ideal array from the 1 to n (size of the array), so that all single occurence elements are being duplicated and cancelled and only repeating number and missing number are left with the final ans
        
        // extract the missing and repeating nos from the xor val as prev que
        int rsb = xor & -xor; 
        int x = 0, y = 0;

        for(int val : arr) {
            if((val & rsb) == 0) 
                x = x ^ val;
            else
                y = y ^ val;
        }

        for(int i = 1; i <= arr.length; i++) {
            if((i & rsb) == 0)
                x = x ^ i;
            else    
                y = y ^ i;
        }

        for(int val : arr) {
            if(val == x) { // when x is present in the array
                System.out.println("Missing Number -> " + y); // y is missing no 
                System.out.println("Repeating Number -> " + x); // x is repeating no
                break;
            }
            else if(val == y) { // when y is present in the array
                System.out.println("Missing Number -> " + x); // x is missing no
                System.out.println("Repeating Number -> " + y); // y is repeating no
                break;
            }
        }
    }
}
