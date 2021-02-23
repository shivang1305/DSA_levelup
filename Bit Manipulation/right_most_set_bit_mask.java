/*
    DSA LEVELUP - Bit Manipulation                                              Date: 22-Feb-2021

1. You are given a number n.
2. You have to print the right-most set bit mask.
*/

// Rightmost set bit mask is the rightmost on bit i.e. 1 in in the binary form of any number

import java.util.*;

public class right_most_set_bit_mask {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        scn.close();

        // to obtain the right most set bit mask we have to obtain the 2's complement of n and then apply & operator b/w n and 2's complement of n
        int rsbm = (n & -n);

        // int rsbm = n & (~n + 1);  can also be written as this

        System.out.println(Integer.toBinaryString(rsbm));

    }
}

