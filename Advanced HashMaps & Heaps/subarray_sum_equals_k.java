/* ADVANCED HASHMAPS & HEAPS                                                  Date: 08-Jun-2021
Given an array of integers nums and an integer k, return the total number of continuous subarrays whose sum equals to k.


Example 1:
Input: nums = [1,1,1], k = 2
Output: 2

Example 2:
Input: nums = [1,2,3], k = 3
Output: 2
*/



import java.util.*;

public class subarray_sum_equals_k {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int sum = 0, count = 0;
        
        hm.put(0, 1);
        
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            
            if(hm.containsKey(sum - k)) 
                count += hm.get(sum - k);
            
            hm.put(sum, hm.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
