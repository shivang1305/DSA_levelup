// Count the min number of palindromic partitions that can be done in the given string

import java.util.*;

public class palindromic_partitioning {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();

        scn.close();

        int[][] dp = new int[str.length() + 1][str.length() + 1];
        for(int i = 0; i < dp.length; i++) {
            for(int j = 0; j < dp[0].length; j++)
                dp[i][j] = -1;
        }

        System.out.println(palindromic_partitioning_memoized(str, 0, str.length() - 1, dp));
    }

    public static boolean isPalindrome(String str, int i, int j) {
        if(i == j) // for a single letter 
            return true; // always palindrome
    
        if(i > j)
            return true;
        
        while(i < j) {
            if(str.charAt(i) != str.charAt(j)) 
                return false;
            i++;
            j--;
        }

        return true;
    }

    public static int palindromic_partitioning_recursive(String str, int i, int j) {
        if(i >= j) // base condition
            return 0;

        if(isPalindrome(str, i, j) == true) // base condition
            return 0;

        int ans = Integer.MAX_VALUE;

        for(int k = i; k <= j - 1; k++) {
            int tempAns = 1 + palindromic_partitioning_recursive(str, i, k) + palindromic_partitioning_recursive(str, k + 1, j); // here 1 is added for the current partition

            ans = Math.min(ans, tempAns); // since we have to calculate the min number of partitions
        }
        
        return ans;
    }

    public static int palindromic_partitioning_memoized(String str, int i, int j, int[][] dp) {
        if(i >= j)
            return 0;

        if(isPalindrome(str, i, j) == true)
            return 0;

        if(dp[i][j] != -1)
            return dp[i][j];

        int ans = Integer.MAX_VALUE;

        for(int k = i; k <= j - 1; k++) {
            int tempAns = 1 + palindromic_partitioning_memoized(str, i, k, dp) + palindromic_partitioning_memoized(str, k + 1, j, dp);

            ans = Math.min(ans, tempAns);
        }
        
        return dp[i][j] = ans;
    }
}
