import java.util.*;

public class count_of_subsets_sum {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = scn.nextInt();

        int sum = scn.nextInt();

        scn.close();

        int[][] dp = new int[n+1][sum+1];
        for(int i = 0; i < dp.length; i++) {
            for(int j = 0; j < dp[0].length; j++)
                dp[i][j] = -1;
        }

        System.out.println(memoizationSol(arr, sum, n, dp));
    }

    public static int recursiveSol(int[] arr, int sum, int n) {
        if(sum == 0)
            return 1;
        
        if(n == 0)
            return 0;

        if(arr[n - 1] <= sum)
            return recursiveSol(arr, sum - arr[n - 1], n - 1) + recursiveSol(arr, sum, n -1);

        else
            return recursiveSol(arr, sum, n -1);
    }

    public static int memoizationSol(int[] arr, int sum, int n, int[][] dp) {
        if(sum == 0)
            return dp[n][sum] = 1;
        
        if(n == 0)
            return dp[n][sum] = 0;

        if(dp[n][sum] != -1)
            return dp[n][sum];

        if(arr[n - 1] <= sum)
            return dp[n][sum] = memoizationSol(arr, sum - arr[n - 1], n - 1, dp) + memoizationSol(arr, sum, n -1, dp);

        else
            return dp[n][sum] = memoizationSol(arr, sum, n -1, dp);
    }

    public static int tabulationSol(int[] arr, int sum, int n, int[][] dp) {
        for(int i = 0; i < dp.length; i++) {
            for(int j = 0; j < dp[0].length; j++) {
                if(i == 0)
                    dp[i][j] = 0;
                if(j == 0)
                    dp[i][j] = 1;

                else if(arr[i - 1] <= j)
                    dp[i][j] = dp[i - 1][j - arr[i - 1]] + dp[i - 1][j];
                
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }

        return dp[n][sum];
    }
}
