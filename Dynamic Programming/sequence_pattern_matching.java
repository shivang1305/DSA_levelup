import java.util.*;

public class sequence_pattern_matching {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        String str1 = scn.nextLine();
        String str2 = scn.nextLine();

        scn.close();

        System.out.println(sequencePatternMatching(str1, str2));
    }

    public static boolean sequencePatternMatching(String s1, String s2) {
        
        if(LCS(s1, s2, s1.length(), s2.length()) == s1.length()) // only when str2 completely contains str1 as a subsequence
            return true;
        
        else
            return false;
    }

    public static int LCS(String X, String Y, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];

        for(int i = 0; i < dp.length; i++) {
            for(int j = 0; j < dp[0].length; j++) {
                
                if(i == 0 || j == 0)
                    dp[i][j] = 0;

                else if(X.charAt(i - 1) == Y.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];

                else 
                    dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]);
            }
        }

        return dp[m][n];
    }
}
