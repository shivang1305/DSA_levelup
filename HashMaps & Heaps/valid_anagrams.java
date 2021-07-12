/* ADVANCED HASHMAPS & HEAPS                                                  Date: 08-Jun-2021
Given two strings s and t, return true if t is an anagram of s, and false otherwise.

Example 1:
Input: s = "anagram", t = "nagaram"
Output: true

Example 2:
Input: s = "rat", t = "car"
Output: false
*/


import java.util.*;



public class valid_anagrams {
    public boolean isAnagram(String str1, String str2) {
        HashMap<Character, Integer> map1 = new HashMap<>();
		HashMap<Character, Integer> map2 = new HashMap<>();
        
        for(int i = 0; i < str1.length(); i++) 
            map1.put(str1.charAt(i), map1.getOrDefault(str1.charAt(i), 0) + 1); // freq map of str1
        
            
        for(int i = 0; i < str2.length(); i++) 
            map2.put(str2.charAt(i), map2.getOrDefault(str2.charAt(i), 0) + 1); // freq map of str2
            
		return map1.equals(map2);
    }
}
