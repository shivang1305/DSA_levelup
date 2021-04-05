import java.util.*;

public class min_subset_sum_diff {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = scn.nextInt();

        scn.close();

        System.out.println(minSubsetSumDiff(arr, n));
    }

    public static int minSubsetSumDiff(int[] arr, int n) {
        // obtaining the range
        int range = 0;
        for(int val : arr)
            range += val;

        // subset sum problem (it will fill the dp array)
        Boolean[][] dp = new Boolean[n + 1][range + 1];
        dp = subsetSum(arr, range, n, dp);

        int minDiff = Integer.MAX_VALUE;
        
        // for even and odd ranges of the array (we only need to go till the half of the range of the array since s1 will always belong to the first half of the range and s2 will always be in the second half)
        int idx = (range % 2 == 0) ? dp[0].length / 2 : (dp[0].length / 2) - 1;
        
        for(int j = 0; j <= idx; j++) {
            if(dp[n][j] == true) // possible values of s1, s2
                minDiff = Math.min(minDiff, range - 2 * j); // obtaining the min diff
        }

        return minDiff; // ans
    }

    public static Boolean[][] subsetSum(int[] arr, int sum, int n, Boolean[][] dp) {
        for(int i = 0; i < dp.length; i++) {
            for(int j = 0; j < dp[0].length; j++) {
                if(i == 0)
                    dp[i][j] = false;
                
                if(j == 0)
                    dp[i][j] = true;

                else if(arr[i - 1] <= j)
                    dp[i][j] = (dp[i - 1][j - arr[i - 1]] || dp[i - 1][j]);

                else
                    dp[i][j] = dp[i - 1][j];
            }
        }

        return dp;
    }
}
