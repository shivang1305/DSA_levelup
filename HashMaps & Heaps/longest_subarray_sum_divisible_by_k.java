/* ADVANCED HASHMAPS & HEAPS                                                  Date: 19-Jun-2021
1. You are given an array of integers(arr) and a number K.
2. You have to find length of the longest subarray whose sum is divisible by K.

 
Sample Input
6
2 7 6 1 4 5
3
Sample Output
4
*/

import java.util.*;



public class longest_subarray_sum_divisible_by_k {
    public static int solution(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        
        int sum = 0, maxLen = 0;
        
        for(int i = 0; i < arr.length; i++) {
            sum += arr[i];
            int rem = sum % k;
            
            // normalizing the negative remainders
            if(rem < 0)
                rem += k;
            
            if(map.containsKey(rem)) {
                int len = i - map.get(rem);
                maxLen = Math.max(maxLen, len);
            }
            else
                map.put(rem, i);
        }

        return maxLen;
    }
}
