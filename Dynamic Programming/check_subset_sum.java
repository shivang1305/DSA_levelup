import java.util.*;

public class check_subset_sum {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = scn.nextInt();

        int sum = scn.nextInt();
        scn.close();

        Boolean[][] dp = new Boolean[n + 1][sum + 1];

        System.out.println(memoizationSol(arr, sum, n, dp));
    }

    public static boolean recursiveSol(int[] arr, int sum, int n) {
        if(sum == 0) // base case
            return true;

        if(n == 0) // base case
            return false;

        if(arr[n - 1] <= sum)
            return (recursiveSol(arr, sum - arr[n - 1], n-1) || recursiveSol(arr, sum, n- 1)); // max is replaced by OR in case of boolean variables
        
        else
            return recursiveSol(arr, sum, n-1); // no ki call
    }

    // same as recursive solution just a question bank is added as dp matrix
    public static boolean memoizationSol(int[] arr, int sum, int n, Boolean[][] dp) {
        if(sum == 0)
            return dp[n][sum] = true;

        if(n == 0)
            return dp[n][sum] = false;

        if(dp[n][sum] != null)
            return dp[n][sum];

        if(arr[n - 1] <= sum)
            return dp[n][sum] = (memoizationSol(arr, sum - arr[n - 1], n-1, dp) || memoizationSol(arr, sum, n- 1, dp));
        
        else
            return dp[n][sum] = memoizationSol(arr, sum, n-1, dp);
    }

    public static boolean tabulationSol(int[] arr, int sum, int n, Boolean[][] dp) {
        // initialization of the matrix
        for(int i = 0; i < dp.length; i++) {
            for(int j = 0; j < dp[0].length; j++) {
                if(i == 0) // when the sum is 0
                    dp[i][j] = false;
                if(j == 0) // when the size of the array is 0
                    dp[i][j] = true;

                // choice daigram
                else if(arr[i - 1] <= j) // when the given element in the array is less than the given sum for a subproblem
                    dp[i][j] = (dp[i - 1][j - arr[i - 1]]) || (dp[i - 1][j]); // TRUE || FALSE = TRUE
                
                else
                    dp[i][j] = dp[i -1][j];

                // but for sum = 0 and size = 0, the answer will be true because for 0 sum and 0 elements in the array there can be one possible subset i.e. {} empty subset as its sum is zero and it does not contain any element
            }
        }
        
        return dp[n][sum];
    }

}