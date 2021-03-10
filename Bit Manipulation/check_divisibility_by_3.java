/*
    DSA LEVELUP - Bit Manipulation                                              Date: 10-Mar-2021

1. You are given a binary string which represents a number.
2. You have to check whether this number is divisible by 3 or not.
3. Print 'true' if it is divisible by 3, otherwise print 'false'.
*/

import java.util.*;

public class check_divisibility_by_3 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine(); // binary representation of a number in a string
        scn.close();

        int even = 0, odd = 0;

        for(int i = 0; i < str.length(); i++) {
            int bit = str.charAt(i) - '0'; // taking and converting the bit from char to int
            
            if(i % 2 == 0) // classifying and adding the even and odd position bits seperately
                even += bit;

            else 
                odd += bit;
        }

        int delta = even - odd; 

        if(delta % 11 == 0) // since 11 is the binary representation of 3 so, if the binary number is divisible by 11 then it must be divisble by 33 
            System.out.println("true");
        else 
            System.out.println("false");
    }
}