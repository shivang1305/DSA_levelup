/* ADVANCED HASHMAPS & HEAPS                                                  Date: 08-Jun-2021
1. You are given two strings s1, s2, and a number K.
2. You have to find if two strings are K-anagrams of each other or not.
3. Two strings are called K-anagrams if 
   -> Both s1 and s2 have the same number of characters.
   -> After changing K characters in any string, s1 and s2 become anagram of each other. 

Note -> Both s1 ad s2 consist of lowercase English letters only.

Sample Input
fodr 
gork
2

Sample Output
true
*/

import java.util.*;


public class K_anagrams {
    public static boolean areKAnagrams(String str1, String str2, int k) {
		HashMap<Character, Integer> map1 = new HashMap<>();
		HashMap<Character, Integer> map2 = new HashMap<>();
		
		int count = 0;
        
        for(int i = 0; i < str1.length(); i++) 
            map1.put(str1.charAt(i), map1.getOrDefault(str1.charAt(i), 0) + 1); // freq map of str1
        
            
        for(int i = 0; i < str2.length(); i++) 
            map2.put(str2.charAt(i), map2.getOrDefault(str2.charAt(i), 0) + 1); // freq map of str2
            
        for(char key : map1.keySet()) {
            if(map1.get(key) - map2.getOrDefault(key, 0) >= 0)
                count += map1.get(key) - map2.getOrDefault(key, 0);
        }
        
        if(count <= k)
		    return true;
		    
		return false;
	}
}
