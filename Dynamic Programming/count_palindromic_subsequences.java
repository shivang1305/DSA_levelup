/* LEETCODE - HARD                                                                     Date: 24-May-2021
Given a string s, find the number of different non-empty palindromic subsequences in s, and return that number modulo 10^9 + 7.

A subsequence of a string s is obtained by deleting 0 or more characters from s.

A sequence is palindromic if it is equal to the sequence reversed.

Two sequences A_1, A_2, ... and B_1, B_2, ... are different if there is some i for which A_i != B_i.

Example 1:

Input: 
s = 'bccb'
Output: 9
Explanation: 
The 6 different non-empty palindromic subsequences are 'b', 'b', 'c', 'c', 'bb', 'cc', 'bcb', 'bcb', 'bccb'.
Note that 'bcb' is counted only twice.
*/


public class count_palindromic_subsequences {
    public int countPalindromicSubsequences(String s) {
        return solve(s);
    }
    
    public static int solve(String str) {
        int n = str.length();
        
        if(n == 0 || n == 1)
            return n;
            
        if(str.charAt(0) == str.charAt(n - 1))
            return 1 + solve(str.substring(0, n - 1)) + solve(str.substring(1, n));
            
        else
            return solve(str.substring(0, n - 1)) + solve(str.substring(1, n)) - solve(str.substring(1, n - 1));
    }
    
    public static int solMemo(String str, int i, int j, int[][] dp) {
        if(i > j)
            return 0;
        
        if(i == j)
            return 1;
        
        if(dp[i][j] != -1)
            return dp[i][j];
            
        if(str.charAt(i - 1) == str.charAt(j - 1))
            return dp[i][j] = 1 + solMemo(str, i, j - 1, dp) + solMemo(str, i + 1, j, dp);
            
        else
            return dp[i][j] = solMemo(str, i, j - 1, dp) + solMemo(str, i + 1, j, dp) - solMemo(str, i + 1, j - 1, dp);
    }
    
    public static int solTabu(String str) {
        int[][] dp = new int[str.length() + 1][str.length() + 1];
        
        for(int i = 0; i < dp.length; i++) {
            for(int j = 0; j < dp[0].length; j++) {
                if(i > j)
                    dp[i][j] = 0;
                if(i == j)
                    dp[i][j] = 1;
                else {
                    if(str.charAt(i - 1) == str.charAt(j - 1))
                        dp[i][j] = 1 + dp[i][j - 1] + dp[i + 1][j];
                    else
                        dp[i][j] = dp[i][j - 1] + dp[i + 1][j] - dp[i + 1][j - 1];
                }
            }
        }
        return dp[str.length()][str.length()];
    }
}