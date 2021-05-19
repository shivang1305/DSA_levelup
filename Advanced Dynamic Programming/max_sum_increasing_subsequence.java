/*                                                                                    Date: 18-May-2021
1. You are given a number n, representing the number of elements.
2. You are given n numbers, representing the contents of array of length n.
3. You are required to print the sum of elements of the increasing subsequence with maximum sum for the array.
*/

public class max_sum_increasing_subsequence {
    public int sumOfLIS(int[] arr) {
        int[] dp = new int[arr.length];
        
        int ans = Integer.MIN_VALUE; // final ans
        for(int i = 0; i < dp.length; i++) {
            
            int max = arr[i]; // temp ans 
            
            for(int j = 0; j < i; j++) {
                
                if(arr[i] > arr[j]) // compare with the prev values in the given array that's why in dp array we stored the length of LIS ending at curr element
                    max = Math.max(max, dp[j]);
            }
            
            dp[i] += max;
            ans = Math.max(dp[i], ans); // select the max value from the dp array, it will be our final ans
        }

        return ans;
    }
}
