/*
    DSA LEVELUP - Bit Manipulation                                              Date: 07-Mar-2021

1. You are given a number n.
2. You have to calculate the value of 7n/8 without using division and multiplication.
*/

import java.util.*;

public class solve_7n_by_8 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        scn.close();

        // n << x = n * 2^x
        // n >> x = n / 2^x

        int val = ((n << 3) - n) >> 3;
        System.out.println(val);        
    } 
}
