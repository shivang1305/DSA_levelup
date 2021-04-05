import java.util.*;

public class coin_change_2 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] coins = new int[n];
        for(int i = 0; i < n; i++)
            coins[i] = scn.nextInt();

        int sum = scn.nextInt();

        scn.close();

        int[][] dp = new int[n + 1][sum + 1];

        System.out.println(tabulationSol(coins, sum, dp));
    }

    public static int tabulationSol(int[] coins, int sum, int[][] dp) {
        //initialization
        for(int i = 0; i < dp.length; i++) {
            for(int j = 0; j < dp[0].length; j++) {
                if(i == 0) // for the first row 
                    dp[i][j] = Integer.MAX_VALUE - 1;
                if(j == 0) // for the first column
                    dp[i][j] = 0;
            }
        }

        for(int i = 1, j = 1; j < dp[0].length; j++) {
            // for the second row initialization
                if(j % coins[0] == 0)
                    dp[i][j] = j / coins[0];
                else
                    dp[i][j] = Integer.MAX_VALUE - 1;
        }

        for(int i = 1; i < dp.length; i++) {
            for(int j = 1; j < dp[0].length; j++) {
                
                if(coins[i - 1] <= j) 
                    dp[i][j] = Math.min(1 + dp[i][j - coins[i - 1]], dp[i - 1][j]); // 1 + old ans is done to increase the number of coins and that's why we did Integer.MAX_VALUE - 1 so that both the ones are cancelled
                
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }

        return dp[coins.length][sum];
    }
}