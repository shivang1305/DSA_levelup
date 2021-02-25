/*
    DSA LEVELUP - Bit Manipulation                                              Date: 25-Feb-2021

1. You are given an array of numbers.
2. You have to find 2 non-repeating numbers in an array.
3. All repeating numbers are repeating even number of times.
*/

import java.util.*;

public class all_repeating_except_two {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt(); // size of the array

        int[] arr = new int[n]; // array
        for(int i = 0; i < n; i++)
            arr[i] = scn.nextInt();

        scn.close();

        solution(arr);
    }

    public static void solution(int[] arr) {
        int xXORy = 0;
        for(int val : arr) 
            xXORy = xXORy ^ val; // xor all the numbers so that all the duplicates are cancelled and only single occurence numbers are left i.e. 'x' & 'y' 

        int rsbm = xXORy & -xXORy; // obtaining the right most set bit mask

        int x = 0, y = 0;
        for(int val : arr) {
            if((val & rsbm) == 0) { // if the rightmost set bit mask is off
                x = x ^ val; // xor the off bit numbers 
            }
            else { // if the rightmost set bit mask is on
                y = y ^ val; // xor the on bits numbers seperately
            }
        }

        // printing the single frequency numbers in ascending order
        if(x > y) {
            System.out.println(y);
            System.out.println(x);
        }
        else{
            System.out.println(x);
            System.out.println(y);
        }
    }
}
