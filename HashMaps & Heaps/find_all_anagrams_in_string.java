/* ADVANCED HASHMAPS & HEAPS                                                  Date: 08-Jun-2021
Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.


Example 1:
Input: s = "cbaebabacd", p = "abc"
Output: [0,6]
Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".

Example 2:
Input: s = "abab", p = "ab"
Output: [0,1,2]
Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
*/



import java.util.*;


public class find_all_anagrams_in_string {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        
        if(p.length() > s.length()) // exceptional case
            return ans;
        
        HashMap<Character, Integer> hm1 = new HashMap<>();
        HashMap<Character, Integer> hm2 = new HashMap<>();
        
        for(int i = 0; i < p.length(); i++) 
            hm1.put(p.charAt(i), hm1.getOrDefault(p.charAt(i), 0) + 1);
        
        for(int i = 0; i < p.length(); i++)
            hm2.put(s.charAt(i), hm2.getOrDefault(s.charAt(i), 0) + 1);
        
        int i = p.length();
        
        while(i < s.length()) {
            if(hm1.equals(hm2))
                ans.add(i - p.length());
            
            //acquire
            hm2.put(s.charAt(i), hm2.getOrDefault(s.charAt(i), 0) + 1);
            
            //release
            if(hm2.get(s.charAt(i - p.length())) == 1)
                hm2.remove(s.charAt(i - p.length()));
            else
                hm2.put(s.charAt(i - p.length()), hm2.get(s.charAt(i - p.length())) - 1);
            
            i++;
        }
        
        if(hm1.equals(hm2))
            ans.add(i - p.length());
        
        return ans;
    }
}
