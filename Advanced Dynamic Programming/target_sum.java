import java.util.*;

public class target_sum {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = scn.nextInt();

        int S = scn.nextInt();

        scn.close();

        System.out.println(findTargetSumWays(arr, S));
    }

    public static int findTargetSumWays(int[] nums, int S) {
        int sum = 0, count = 1;
        for(int val : nums) {
            sum += val;
            if(val == 0) // since zero is a special number in case of making subsets as it would not impact the sum of the subset
                count *= 2;
        }
        
        if(sum < S)
            return 0;
        if((S+sum)%2!=0) 
            return 0;
        
        int s1 = (sum + S) / 2; // for the sum of one subset
        
        int[][] dp = new int[nums.length + 1][s1 + 1];
        return count * countSubsetSum(nums, nums.length, s1, dp);
    }
    
    // tabulation code for subset sum problem
    public static int countSubsetSum(int[] arr, int n, int sum, int[][] dp) {
        // initialization
        for(int i = 0; i < dp.length; i++) {
            for(int j = 0; j < dp[0].length; j++) {
                if(i == 0)
                    dp[i][j] = 0;
                if(j == 0)
                    dp[i][j] = 1;
            }
        }

        for(int i = 1; i < dp.length; i++) {
            for(int j = 1; j < dp[0].length; j++) {
                if(arr[i - 1] == 0)
                    dp[i][j] = dp[i - 1][j];
                else if(arr[i - 1] <= j)
                    dp[i][j] = dp[i - 1][j - arr[i - 1]] + dp[i - 1][j];
                
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }

        return dp[n][sum];
    }
}
