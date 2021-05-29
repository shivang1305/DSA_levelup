/* ADVANCED HASHMAPS & HEAPS                                                        Date: 29-May-2021
Given an array of integers arr of even length n and an integer k.

We want to divide the array into exactly n / 2 pairs such that the sum of each pair is divisible by k.

Return True If you can find a way to do that or False otherwise.

Input: arr = [-1,1,-2,2,-3,3,-4,4], k = 3
Output: true
*/

import java.util.*;

public class check_if_array_pairs_are_divisible_by_k {
    public boolean canArrange(int[] arr, int k) {
        HashMap<Integer, Integer> freqCount = new HashMap<>();
        
        for(int n : arr) {
            int rem = n % k;
            
            if(rem < 0)
                rem += k;
                
            int of = freqCount.getOrDefault(rem, 0); // given old freq if present else gives zero
            freqCount.put(rem, of + 1);
        }
        
        for(int key : freqCount.keySet()) {
            if(key == 0 || key == k - key) { // if k is odd then k/2 creates error that's why we write 2 * key == k rather than key == k / 2
                if(freqCount.get(key) % 2 != 0)
                    return false;    
            }
                 
            else {
                if(!freqCount.get(key).equals(freqCount.getOrDefault(k - key, 0)))
                    return false;
            }
        }
        return true;
    }
}