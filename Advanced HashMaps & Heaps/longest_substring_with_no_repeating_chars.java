/* ADVANCED HASHMAPS & HEAPS                                                        Date: 02-Jun-2021
Given a string s, find the length of the longest substring without repeating characters.

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
*/

import java.util.*;

public class longest_substring_with_no_repeating_chars {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> hm = new HashMap<>();
        int maxLen = 0;
        
        int i = -1, j = -1;
        
        while(true) {
            boolean f1 = false, f2 = false;
            
            // acquire
            while(i < s.length() - 1) {
                f1 = true;
                i++;
                
                char ch = s.charAt(i);
                
                hm.put(ch, hm.getOrDefault(ch, 0) + 1); // adding the char to the hashmap
                
                if(hm.get(ch) == 2) // if the freq of added element reaches 2 i.e. this char is repeated
                    break;
                else { // colllect ans
                    int len = i - j; // calc the length every time
                    maxLen = Math.max(maxLen, len);
                }
            }
            
            // release
            while(j < i) {
                f2 = true;
                j++;
                
                char ch = s.charAt(j);
                
                hm.put(ch, hm.get(ch) - 1); // decrease the freq of char in hashmap
                if(hm.get(ch) == 1)
                    break;
            }
            
            if(f1 == false && f2 == false)
                break;
        }
        return maxLen;
    }
}