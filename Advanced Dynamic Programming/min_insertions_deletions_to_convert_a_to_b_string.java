import java.util.*;

public class min_insertions_deletions_to_convert_a_to_b_string {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String a = scn.nextLine();
        String b = scn.nextLine();

        scn.close();

        int[][] dp = new int[a.length() + 1][b.length() + 1];
        System.out.println(a.length() - LCSTabulated(a, b, a.length(), b.length(), dp)); // number of deletions
        System.out.println(b.length() - LCSTabulated(a, b, a.length(), b.length(), dp)); // number of insertions        
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
