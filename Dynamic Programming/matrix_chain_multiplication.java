// Obtain the min possible cost to multiply the chain of matrices whose dimensions are given in the array.

import java.util.*;

public class matrix_chain_multiplication {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] arr = new int[n];
        for(int i = 0; i < n; i++) 
            arr[i] = scn.nextInt();

        scn.close();

        int[][] dp = new int[n + 1][n + 1];
        for(int i = 0; i < dp.length; i++) {
            for(int j = 0; j < dp[0].length; j++)
                dp[i][j] = -1;
        }

        System.out.println(MCM_memoized(arr, 1, n - 1, dp));
    }

    public static int MCM_recursive(int[] arr, int i, int j) {
        if(i >= j) // base condition
            return 0;
        
        int ans = Integer.MAX_VALUE;
        for(int k = i; k <= j - 1; k++) { // k-loop schema
            
            // temp ans (cost for each valid pattern)
            int tempAns = MCM_recursive(arr, i, k) + MCM_recursive(arr, k + 1, j) + arr[i - 1] * arr[k] * arr[j];

            ans = Math.min(tempAns, ans); // final ans (min cost out of all obtained costs)
        }

        return ans;
    }

    public static int MCM_memoized(int[] arr, int i, int j, int[][] dp) {
        if(i >= j)
            return 0;

        if(dp[i][j] != -1)
            return dp[i][j];

        int ans = Integer.MAX_VALUE;
        
        for(int k = i; k <= j - 1; k++) {
            int tempAns = MCM_memoized(arr, i, k, dp) + MCM_memoized(arr, k + 1, j, dp) + arr[i - 1] * arr[k] * arr[j];

            ans = Math.min(ans, tempAns);
        }

        return dp[i][j] = ans;
    }
}