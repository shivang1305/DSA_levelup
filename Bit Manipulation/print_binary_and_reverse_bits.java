/*
    DSA LEVELUP - Bit Manipulation                                              Date: 13-Mar-2021

1. You are given a number.
2. You have to print its binary representation.
3. You also have to reverse the bits of n and print the number obtained after reversing the bits.
*/

import java.util.*;

public class print_binary_and_reverse_bits {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        scn.close();

        boolean flag = false; // to check that whether we got the first set bit or not
        int rev = 0, j = 0;

        for(int i = 31; i >= 0; i--) {
            
            int mask = (1 << i);
            
            if(flag) { // when we got our first set bit then from that instance we will print all the incoming bits till the end of the number
                if((n & mask) == 0)
                    System.out.print("0");
                
                else {
                    System.out.print("1");

                    int setMask = (1 << j); //set the current bit in the reverse number
                    rev |= setMask;
                }
                j++; 
            }

            else {
                if((n & mask) != 0) {
                    System.out.print("1");
                    flag = true;

                    int setMask = (1 << j); // start increasing the reverse bit number only when you found the first set bit in the representation
                    rev |= setMask;
                    j++;
                }
            }
        }
        System.out.println();
        System.out.println(rev);
    }
}
