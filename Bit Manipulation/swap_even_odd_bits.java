/*
    DSA LEVELUP - Bit Manipulation                                              Date: 09-Mar-2021

1. You are given a number n.
2. You have to swap all odd position bits with even position bits.
3. Every odd position bit is swapped with adjacent bit on left side.
4. Every even position bit is swapped with adjacent bit on right side.
5. Print the number formed after swapping.
*/

import java.util.*;

public class swap_even_odd_bits {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        scn.close();

        // hexadecimal numbers
        int oddMask = 0x55555555; // 0101010101....32 times
        int evenMask = 0xAAAAAAAA; // 1010101010....32 times

        int odd = (n & oddMask); // off all the even bits in n
        int even = (n & evenMask); // off all the odd bits in n

        odd <<= 1; // left shift
        even >>= 1; // right shift

        n = (odd | even); 

        System.out.println(n);
    }
}
