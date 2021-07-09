import java.util.*;

public class coin_change_1 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        int[] coins = new int[n];
        for(int i = 0; i < n; i++)
            coins[i] = scn.nextInt();

        int sum = scn.nextInt();

        scn.close();

        int[][] dp = new int[n+1][sum+1];

        System.out.println(tabulationSol(coins, sum, n, dp));
    }

    public static int tabulationSol(int[] arr, int sum, int n, int[][] dp) {
        for(int i = 0; i < dp.length; i++) {
            for(int j = 0; j < dp[0].length; j++) {
                if(i == 0)
                    dp[i][j] = 0;
                if(j == 0)
                    dp[i][j] = 1;

                else if(arr[i - 1] <= j)
                    dp[i][j] = dp[i][j - arr[i - 1]] + dp[i - 1][j];
                
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }

        return dp[n][sum];
    }
}
