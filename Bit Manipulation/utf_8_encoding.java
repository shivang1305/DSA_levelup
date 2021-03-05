/*
    DSA LEVELUP - Bit Manipulation                                              Date: 05-Mar-2021

1. You are given an array of integers.
2. You are required to test whether the array represents a valid sequence of UTF-8 characters or 
     not.
3. A character in UTF-8 can be from 1 to 4 bytes long and follows some rules - 
       (i)  For 1-byte long character, first bit will be 0 and rest represents its unicode code.
       (ii) For n-bytes long character, first n-bits will be 1's, the n+1th bit is 0, followed by n-1 bytes 
             with most significant 2 bits being 10.

Note -> Only the least significant 8 bits of each element in array is used for data.
*/

import java.util.*;

public class utf_8_encoding {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] arr = new int[n];
        for(int i = 0; i < n ; i++)
            arr[i] = scn.nextInt();

        scn.close();

        System.out.println(solution(arr));
    }

    public static boolean solution(int[] arr) {
        int rbytes = 0; // number of remaining bytes

        for(int val : arr) {
            
            if(rbytes == 0) { // when number of remaining bytes is zero i.e. we are checking for the starting of the bumber (1st byte)
                
                if((val >> 7) == 0b0) // 1st bytes of 1 byte number in UTF
                    rbytes = 0;
                
                else if((val >> 5) == 0b110) // 1st bytes of 2 bytes number in UTF
                    rbytes = 1;
                
                else if((val >> 4) == 0b1110) // 1st bytes of 3 bytes number in UTF
                    rbytes = 2;
                
                else if((val >> 3) == 0b11110) // 1st byte of 4 bytes number in UTF
                    rbytes = 3;
                
                else // if the given number's 1st byte does not satify any of the above mentioned condition
                    return false;
            }
            else { // when the number of remaining bytes is non zero i.e. we are checking for the 2nd, 3rd or 4th byte in the sequence of numbers 
                
                if((val >> 6) == 0b10) // rest numbers should start from 10
                    rbytes--;
                
                else 
                    return false;
            }
        }

        if(rbytes == 0) // if in the end there are no remaining bytes and the compiler reaches here then return true
            return true;
        else    
            return false;
    }
}
