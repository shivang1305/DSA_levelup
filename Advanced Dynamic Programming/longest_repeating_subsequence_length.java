import java.util.*;

public class longest_repeating_subsequence_length {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        String str = scn.nextLine();

        scn.close();

        System.out.println(longestRepeatingSubsequence(str));
    }

    public static int longestRepeatingSubsequence(String str) {
        return longestCommonSubsequence(str, str);
    }

    public static int longestCommonSubsequence(String X, String Y) {
        int n = str.length();
        int[][] dp = new int[n + 1][n + 1];

        for(int i = 0; i < dp.length; i++) {
            for(int j = 0; j < dp[0].length; j++) {
                if(i == 0 || j == 0)
                    dp[i][j] = 0;

                // here i != j restriction is because we can't accomodate the same character in both the subsequences, we must put diff indices chars here
                else if(X.charAt(i - 1) == Y.charAt(j - 1) && i != j) 
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return dp[n][n];
    }
}
