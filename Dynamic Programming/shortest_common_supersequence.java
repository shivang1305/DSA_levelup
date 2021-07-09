import java.util.*;

public class shortest_common_supersequence {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String X = scn.nextLine();
        String Y = scn.nextLine();

        scn.close();

        int[][] dp = new int[X.length() + 1][Y.length() + 1];
        System.out.println(X.length() + Y.length() - LCSTabulated(X, Y, X.length(), Y.length(), dp));
    }

    public static int LCSTabulated(String X, String Y, int n, int m, int[][] dp) {
        for(int i = 0; i < dp.length; i++) {
            for(int j = 0; j < dp[0].length; j++) {
                if(i == 0 || j == 0)
                    dp[i][j] = 0;

                else if(X.charAt(i - 1) == Y.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];

                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return dp[n][m];
    }
}