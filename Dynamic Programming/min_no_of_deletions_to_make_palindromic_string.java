import java.util.*;

public class min_no_of_deletions_to_make_palindromic_string {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();

        scn.close();

        int n = str.length();
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        String s = sb.reverse().toString();

        int[][] dp = new int[n + 1][n + 1];

        for(int i = 0; i < dp.length; i++) {
            for(int j = 0; j < dp[0].length; j++) {
                if(i == 0 || j == 0)
                    dp[i][j] = 0;

                else if(str.charAt(i - 1) == s.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];

                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        System.out.println(str.length() - dp[n][n]);
    }

}
