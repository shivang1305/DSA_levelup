/*
    DSA Level-Up - RECURSION & BACKTRACKING                                               Date: 10-Feb-2020

    Coin Change Combination - 1

1. You are given a number n, representing the count of coins.
2. You are given n numbers, representing the denominations of n coins.
3. You are given a number "amt".
4. You are required to calculate and print the combinations of the n coins (non-duplicate) using 
   which the amount "amt" can be paid.
*/  


/**
 * coins at levels
 * yes and no as options whether to place or not to place the particular coin
 */

public static void coinChange(int i, int[] coins, int amtsf, int tamt, String asf){
    // base case
    if(i == coins.length) {
        if(amtsf == tamt) {
            System.out.println(asf + ".");
        }
        return;
    }
    
    // yes ki call
    coinChange(i + 1, coins, amtsf + coins[i], tamt, asf + coins[i] + "-");
    
    // no ki call
    coinChange(i + 1, coins, amtsf, tamt, asf);
}

/**
 * coins as options
 * amount at level
 * to avoid the duplicacy we used "after me" rule for that we have used last coin used variable(lcu)
 */

public static void coinChange(int[] coins, int amtsf, int tamt, String asf, int lcu) {
    // base case
    if(amtsf == tamt) { // when the amount so far equals to the total amount
        
        System.out.println(asf + ".");
        
        return;
    }
    
    for(int i = lcu + 1; i < coins.length; i++) { // traversing all the coins (options)
        
        if(coins[i] != 0) { // only if the coin is not used
            
            int cost = coins[i]; // getting the value of the coin
            
            coins[i] = 0; // marking the coin as used
            
            coinChange(coins, amtsf + cost, tamt, asf + cost + "-", i); // recursive call 
            
            coins[i] = cost; // unmark the coin (undo while backtracking)
        }
    }
}
