/*
    DSA Level-Up - RECURSION & BACKTRACKING                                               Date: 13-Jan-2020

    Lexicographical Numbers

1. You are given a number.
2. You have to print all the numbers from 1 to n in lexicographical order.

*/

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        // DFS approach
        for(int i = 1; i <= 9; i++) {
            lexcioDfs(i, n);
        }
    }
    
    public static void lexcioDfs(int i, int n) {
        // base case
        if(i > n)
            return;
            
        System.out.prinltn(i); // first print the current number
        
        for(int j = 0; j < 10; j++) 
            lexcioDfs(10 * i + j, n); // call the family of i 
    }

}