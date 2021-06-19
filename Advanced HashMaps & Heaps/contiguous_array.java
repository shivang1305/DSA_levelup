/* ADVANCED HASHMAPS & HEAPS                                                  Date: 12-Jun-2021
Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.

 
Example 1:
Input: nums = [0,1]
Output: 2
Explanation: [0, 1] is the longest contiguous subarray with an equal number of 0 and 1.

Example 2:
Input: nums = [0,1,0]
Output: 2
Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
*/

import java.util.*;

public class contiguous_array {
    public int findMaxLength(int[] nums) {
        int maxLen = 0, sum = 0;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(sum, -1);
        
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) // treat zero as -1, to neutralize the sum to zero
                sum += -1;
            else
                sum += nums[i];
            
            // check for repeating sum in the array & obtain the max len accordingly
            if(map.containsKey(sum)) 
                maxLen = Math.max(maxLen, i - map.get(sum));
            else
                map.put(sum, i);
        }
        
        return maxLen;
    }
}