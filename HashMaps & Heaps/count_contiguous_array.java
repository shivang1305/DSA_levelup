/* ADVANCED HASHMAPS & HEAPS                                                  Date: 12-Jun-2021
1. You are given an array that contains only 0s and 1s.
2. You have to find the count of subarrays with equal number of 0s and 1s.

 
Sample Input:
6
0 1 1 0 1 1

Sample Output:
4
*/

import java.util.*;


public class count_contiguous_array {
    public static int solution(int[] nums) {
        int count = 0, sum = 0;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(sum, 1);
        
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) // treat zero as -1, to neutralize the sum to zero
                sum += -1;
            else
                sum += nums[i];
            
            // check for repeating sum in the array & obtain the count 
            if(map.containsKey(sum)) {
                count += map.get(sum);
                map.put(sum, map.get(sum) + 1);
            }
            else
                map.put(sum, 1);
        }
        
        return count;
    }
}
