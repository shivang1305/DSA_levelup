import java.util.*;

public class count_subsets_with_given_diff {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = scn.nextInt();

        int diff = scn.nextInt();

        scn.close();

        System.out.println(countSubsetsDiff(arr, diff));
    }

    public static int countSubsetsDiff(int[] arr, int diff) {
        int sum = 0, count = 1;
        for(int val : arr) {
            sum += val;
            if(val == 0) // since zero is a special number in case of making subsets as it would not impact the sum of the subset
                count *= 2;
        }

        int s1 = (sum + diff) / 2;

        int[][] dp = new int[arr.length + 1][s1 + 1];

        return count * countSubsetSum(arr, arr.length , s1, dp);
    }

    public static int countSubsetSum(int[] arr, int n, int sum, int[][] dp) {
        // initialization
        for(int i = 0; i < dp.length; i++) {
            for(int j = 0; j < dp[0].length; j++) {
                if(i == 0)
                    dp[i][j] = 0;
                if(j == 0)
                    dp[i][j] = 1;

                else if(arr[i - 1] <= j)
                    dp[i][j] = dp[i - 1][j - arr[i - 1]] + dp[i - 1][j];
                
                else
                    dp[i][j] = dp[i - 1][j];

            }
        }

        return dp[n][sum];
    }
}
