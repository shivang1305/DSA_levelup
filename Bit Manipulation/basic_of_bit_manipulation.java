/*
    DSA LEVELUP - Bit Manipulation                                              Date: 22-Feb-2021

1. You are given a number n.
2. Print the number produced on setting its i-th bit.
3. Print the number produced on unsetting its j-th bit.
4. Print the number produced on toggling its k-th bit.
5. Also, Check if its m-th bit is on or off. Print 'true' if it is on, otherwise print 'false'.
*/


import java.util.*;

public class basic_of_bit_manipulation {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int i = scn.nextInt();
        int j = scn.nextInt();
        int k = scn.nextInt();
        int m = scn.nextInt();

        scn.close();

        int onMask = (1 << i); 
        int offMask = ~(1 << j);
        int toggleMask = (1 << k);
        int checkMask = (1 << m);

        System.out.println(n | onMask);
        System.out.println(n & offMask);
        System.out.println(n ^ toggleMask);
        System.out.println((n & checkMask) == 0 ? false : true);
    }
}