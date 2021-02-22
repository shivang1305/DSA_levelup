/*
    DSA Level-Up - RECURSION & BACKTRACKING                                               Date: 10-Feb-2020

    Coin Change Combination - 2

1. You are given a number n, representing the count of coins.
2. You are given n numbers, representing the denominations of n coins.
3. You are given a number "amt".
4. You are required to calculate and print the combinations of the n coins (same coin can be used 
   again any number of times) using which the amount "amt" can be paid.
*/  

/**
 * number of coins of same value to be used - options
 * coin at level
 */

public static void coinChange(int i, int[] coins, int amtsf, int tamt, String asf) {
    // base case
    if(i == coins.length) {
        if(amtsf == tamt) // when the amount so far equals to the total amount 
            System.out.println(asf + ".");
        return;
    }
    
    // this loop is for the number of coins of same value to be used such that we must not exceed the total amount
    for(int j = tamt / coins[i]; j >= 1 ; j--) { 
        
        String part = "";
        for(int k = 0; k < j; k++) 
            part += coins[i] + "-"; // to add all the coins in asf
            
        coinChange(i + 1, coins, amtsf + coins[i] * j, tamt, asf + part); // recursive call 
    }
    
    coinChange(i + 1, coins, amtsf, tamt, asf); // no ki call
}