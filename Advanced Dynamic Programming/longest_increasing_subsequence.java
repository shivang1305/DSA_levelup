/* LEETCODE - MEDIUM (300)                                                           Date: 18-May-2021
Given an integer array nums, return the length of the longest strictly increasing subsequence.

A subsequence is a sequence that can be derived from an array by deleting some or no elements without changing the order of the remaining elements. For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].

Example 1:

Input: nums = [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
Example 2:

Input: nums = [0,1,0,3,2,3]
Output: 4
Example 3:

Input: nums = [7,7,7,7,7,7,7]
Output: 1
*/


public class longest_increasing_subsequence {
    public int lengthOfLIS(int[] arr) {
        int[] dp = new int[arr.length];
        
        int ans = Integer.MIN_VALUE; // final ans
        for(int i = 0; i < dp.length; i++) {
            
            int max = 0; // temp ans 
            
            for(int j = 0; j < i; j++) {
                
                if(arr[i] > arr[j]) // compare with the prev values in the given array that's why in dp array we stored the length of LIS ending at curr element
                    max = Math.max(max, dp[j]);
            }
            
            dp[i] = max + 1;
            ans = Math.max(dp[i], ans); // select the max value from the dp array, it will be our final ans
        }

        return ans;
    }
}