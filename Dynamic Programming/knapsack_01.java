import java.util.*;

public class knapsack_01 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int W = scn.nextInt();
        int n = scn.nextInt();
        int[] wt = new int[n];
        for(int i = 0; i < n; i++)
            wt[i] = scn.nextInt();
        int[] val = new int[n];
        for(int i = 0; i < n; i++)
            val[i] = scn.nextInt();

        scn.close();

        int[][] dp = new int[n + 1][W + 1];
        for(int i = 0; i < dp.length; i++) {
            for(int j = 0; j < dp[0].length; j++)
                dp[i][j] = -1;
        }

        System.out.println(knapsackMemoization(W, wt, val, n, dp));
    }

    public static int knapsackRecursive(int W, int[] wt, int[] val, int n) {
        if(n == 0 || W == 0) // base condition (when the weight of the bag is zero or the number of items is zero)
            return 0; // zero profit in that case
        
        if(wt[n - 1] <= W) // we can only put an item in the bag if the left over capacity of the bag is less more than equal to weight of the item in the array
            return Math.max(val[n - 1] + knapsackRecursive(W - wt[n - 1], wt, val, n - 1), knapsackRecursive(W, wt, val, n - 1)); // return the max of both cases (if we put the element in the bag or not)
        
        else
            return knapsackRecursive(W, wt, val, n - 1); // no ki call
    }

    // same as recursive solution just a question bank array is passed as dp in this, and everytime the result is stored in the dp array for future reference so that we don't need to call recursion func again for same values
    public static int knapsackMemoization(int W, int[] wt, int[] val, int n, int[][] dp) {
        if(n == 0 || W == 0)
            return 0;
        
        if(dp[n][W] != -1)
            return dp[n][W];
        
        if(wt[n - 1] <= W) 
            return dp[n][W] = Math.max(val[n - 1] + knapsackMemoization(W - wt[n - 1], wt, val, n - 1, dp), knapsackMemoization(W, wt, val, n - 1, dp));
        
        else
            return dp[n][W] = knapsackMemoization(W, wt, val, n - 1, dp);
    }

    public static int knapsackTabulation(int W, int[] wt, int[] val, int n, int[][] dp) {
        // setp 1 --> Initialization of the dp matrix (this is the replacement for base condition of recursive solution)
        for(int i = 0; i < dp.length; i++) {
            for(int j = 0; j < dp[0].length; j++) 
                if(i == 0 || j == 0) // same as base condition just i <---> n & j <---> W (replacements)
                    dp[i][j] = 0;

                else if(wt[i - 1] <= j) // step 2 --> Filling of the remaining indices in the dp matrix with the help of choice daigram            
                    dp[i][j] = Math.max(val[i - 1] + dp[i - 1][j - wt[i - 1]], dp[i - 1][j]);

                else
                    dp[i][j] = dp[i - 1][j];
        }

        return dp[n][W];
    }
}