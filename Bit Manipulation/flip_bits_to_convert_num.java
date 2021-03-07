/*
    DSA LEVELUP - Bit Manipulation                                              Date: 07-Mar-2021

1. You are given two numbers A and B.
2. You have to print the count of bits needed to be flipped to convert 'A' to 'B'.
*/

import java.util.*;

public class flip_bits_to_convert_num {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int A = scn.nextInt();
        int B = scn.nextInt();
        scn.close();

        System.out.println(flipBitsCount(A, B));
    }

    public static int flipBitsCount(int A, int B) {
        int xor = A ^ B; // xor both the given numbers
        int count = 0;
        
        while(xor > 0) { // count the number of set bits in the obtained xor
            int rsb = xor & -xor;
            xor -= rsb;
            count++;
        }

        return count;
    }
}
