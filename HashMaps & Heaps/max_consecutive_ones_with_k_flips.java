/* ADVANCED HASHMAPS & HEAPS                                                        Date: 05-Jun-2021
Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.

Example 1:
Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
Output: 6
Explanation: [1,1,1,0,0,1,1,1,1,1,1]

Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
*/


public class max_consecutive_ones_with_k_flips {
    public int longestOnes(int[] arr, int k) {
        int j = -1, count = 0, ans = 0;
        
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == 0)
                count++;
                
            while(count > k) {
                j++;
                if(arr[j] == 0)
                    count--;
            }
            
            int len = i - j;
            ans = Math.max(ans, len);
        }

        return ans;
    }
}