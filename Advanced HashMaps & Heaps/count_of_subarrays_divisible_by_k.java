/* ADVANCED HASHMAPS & HEAPS                                                  Date: 19-Jun-2021
Given an array nums of integers, return the number of (contiguous, non-empty) subarrays that have a sum divisible by k.

Example 1:
Input: nums = [4,5,0,-2,-3,1], k = 5
Output: 7

Explanation: There are 7 subarrays with a sum divisible by k = 5:
[4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
*/

import java.util.*;

public class count_of_subarrays_divisible_by_k {
    public int subarraysDivByK(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        
        int sum = 0, count = 0;
        
        for(int i = 0; i < arr.length; i++) {
            sum += arr[i];
            int rem = sum % k;
            
            // normalising the negative remainders
            if(rem < 0)
                rem += k;
            
            if(map.containsKey(rem)) {
                count += map.get(rem);
                map.put(rem, map.get(rem) + 1);
            }
            else
                map.put(rem, 1);
        }

        return count;
    }
}
