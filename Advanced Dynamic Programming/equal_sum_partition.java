import java.util.*;

public class equal_sum_partition {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = scn.nextInt();
        
        scn.close();
        System.out.println(canPartition(arr));
    }
    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for(int val : nums) // O(n)
            sum += val;
        
        if(sum % 2 != 0) // if the sum is odd then there can never be a equal sum partition 
            return false;
        
        else {
            int half = sum / 2;
            for(int val : nums) { // O(n), if the half of the sum is present in the array then surely we can divide the array into equal sum partition
                if(val == half)
                    return true;
            }
            
            Boolean[][] dp = new Boolean[nums.length + 1][half + 1];
            
            return subsetSumTabulation(nums, half, dp);
        }
    }
    
    public static boolean subsetSumTabulation(int[] arr, int sum, Boolean[][] dp) {
        // initialization of the matrix
        for(int i = 0; i < dp.length; i++) { // O(n^2)
            for(int j = 0; j < dp[0].length; j++) {
                if(i == 0) // when the sum is 0
                    dp[i][j] = false;
                if(j == 0) // when the size of the array is 0
                    dp[i][j] = true;

                // but for sum = 0 and size = 0, the answer will be true because for 0 sum and 0 elements in the array there can be one possible subset i.e. {} empty subset as its sum is zero and it does not contain any element
                else if(arr[i - 1] <= j) // when the given element in the array is less than the given sum for a subproblem
                    dp[i][j] = (dp[i - 1][j - arr[i - 1]]) || (dp[i - 1][j]); // TRUE || FALSE = TRUE
                
                else
                    dp[i][j] = dp[i -1][j]; // false (for not including the current element)
            }
        }
        
        return dp[arr.length][sum];
    }
}
