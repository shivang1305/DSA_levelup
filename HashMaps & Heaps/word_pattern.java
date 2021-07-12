/* ADVANCED HASHMAPS & HEAPS                                                  Date: 11-Jun-2021
Given a pattern and a string s, find if s follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s.

 
Example 1:
Input: pattern = "abba", s = "dog cat cat dog"
Output: true

Example 2:
Input: pattern = "abba", s = "dog cat cat fish"
Output: false
*/


import java.util.*;


public class word_pattern {
    public boolean wordPattern(String pattern, String s) {
        String[] strs = s.split(" ");
        
        if(strs.length != pattern.length())
            return false;
        
        HashMap<Character, String> map = new HashMap<>(); // to maintain the pattern
        HashMap<String, Boolean> used = new HashMap<>(); // to check the used strings
        
        for(int i = 0; i < strs.length; i++) {
            if(map.containsKey(pattern.charAt(i))) {
                if(!strs[i].equals(map.get(pattern.charAt(i)))) // when the same key is mapped to different values
                    return false;
            }
            
            else if(!used.containsKey(strs[i])){ 
                map.put(pattern.charAt(i), strs[i]);
                used.put(strs[i], true);
            }
            
            else if(used.containsKey(strs[i])) // when the used value is mapped to different key
                return false;
        }
        return true;
    }
}
