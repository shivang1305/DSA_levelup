import java.util.*;

public class longest_common_subsequence {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        String str1 = scn.nextLine();
        String str2 = scn.nextLine();

        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        for(int i = 0; i < dp.length; i++) {
            for(int j = 0; j < dp[0].length; i++) 
                dp[i][j] = -1;
        }

        // System.out.println(lcsRecursive(str1, str2, str1.length(), str2.length()));
        System.out.println(lcsMemoized(str1, str2, str1.length(), str2.length(), dp));
        scn.close();
    }

    public static int lcsRecursive(String X, String Y, int n, int m) { // tle exceeded
        // BASE CONDITION
        if(n == 0 || m == 0)
            return 0;

        if(X.charAt(n - 1) == Y.charAt(m - 1)) 
            return 1 + lcsRecursive(X, Y, n - 1, m - 1);

        else
            return Math.max(lcsRecursive(X, Y, n-1, m), lcsRecursive(X, Y, n, m-1));
    }

    public static int lcsMemoized(String X, String Y, int n, int m, int[][] dp) { 
        // BASE CONDITION
        if(n == 0 || m == 0)
            return 0;

        if(dp[n][m] != -1)
            return dp[n][m];

        if(X.charAt(n - 1) == Y.charAt(m - 1)) 
            return dp[n][m] = 1 + lcsMemoized(X, Y, n - 1, m - 1, dp);

        else
            return dp[n][m] = Math.max(lcsMemoized(X, Y, n-1, m, dp), lcsMemoized(X, Y, n, m-1, dp));
    }

    public static int lcsTabulated(String X, String Y, int n, int m, int[][] dp) { 

        for(int i = 0; i < dp.length; i++) {
            for(int j = 0; j < dp[0].length; j++) {
                if(i == 0 || j == 0) //INITIALIZATION
                    dp[i][j] = 0;
                
                else if(X.charAt(i - 1) == Y.charAt(j - 1)) //CHOICE DAIGRAM
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return dp[n][m];
    }
}
