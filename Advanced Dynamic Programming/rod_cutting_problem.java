import java.util.*;

public class rod_cutting_problem {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int L = scn.nextInt();
        int n = scn.nextInt();
        int[] length = new int[n];
        for(int i = 0; i < n; i++)
            length[i] = scn.nextInt();
        int[] price = new int[n];
        for(int i = 0; i < n; i++)
            price[i] = scn.nextInt();

        scn.close();

        int[][] dp = new int[n + 1][L + 1];
        for(int i = 0; i < dp.length; i++) {
            for(int j = 0; j < dp[0].length; j++)
                dp[i][j] = -1;
        }

        System.out.println(tabulationSol(L, length, price, n, dp));
    }


    public static int tabulationSol(int L, int[] length, int[] price, int n, int[][] dp) {
        // setp 1 --> Initialization of the dp matrix (this is the replacement for base condition of recursive solution)
        for(int i = 0; i < dp.length; i++) {
            for(int j = 0; j < dp[0].length; j++) 
                if(i == 0 || j == 0) // same as base condition just i <---> n & j <---> W (replacements)
                    dp[i][j] = 0;
        }

        // step 2 --> Filling of the remaining indices in the dp matrix with the help of choice daigram            
        for(int i = 1; i < dp.length; i++) {
            for(int j = 1; j < dp[0].length; j++) {
                if(length[i - 1] <= j) 
                    dp[i][j] = Math.max(price[i - 1] + dp[i][j - length[i - 1]], dp[i - 1][j]);

                else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[n][L];
    }
}