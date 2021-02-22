/*
    DSA LEVELUP - Bit Manipulation                                              Date: 22-Feb-2021

1. You are given a number n.
2. You have to count the number of on bits in the given number.
*/


import java.util.*;

public class kernighans_algorithm {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        scn.close();

        int counter = 0;
        while(n != 0) {
            int rsbm = n & -n; // obtain rsbm each time till the orignal number does not raches zero
            
            n -= rsbm; // decrease the orignal number by rsbm
            
            counter++; // increase the counter
        }

        System.out.println(counter); // print the number of on bits 
    }
}
