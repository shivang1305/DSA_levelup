/*
    DSA LEVELUP - Bit Manipulation                                              Date: 07-Mar-2021

1. You are given a number n.
2. You have to check whether it is a power of 2 or not.
*/

/* Bit representation of any number which is a power of 2 is in the form of ..00001000... 
i.e. it contains only 1 set bit.
*/

import java.util.*;

public class check_power_of_2 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        scn.close();

        /* Approach 1 - using Kernighan's algorithm */
        int count = 0; // counting the number of set bits using kernighan's alogorithm
        while(n > 0) {
            int rsb = n & -n;
            n -= rsb;
            count++;
        }

        if(count == 1)
            System.out.println("true");
        else
            System.out.println("false");

        /*Approach 2 */
        if((n & (n-1)) == 0)
            System.out.println("true");
        else
            System.out.println("false");
    }
}
