/* ADVANCED HASHMAPS & HEAPS                                                  Date: 08-Jun-2021
Given an array of strings strs, group the anagrams together. You can return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

 

Example 1:
Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

Example 2:
Input: strs = [""]
Output: [[""]]
*/


import java.util.*;


public class group_anagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<HashMap<Character, Integer>, ArrayList<String>> map = new HashMap<>();
		
		for(String s : strs) {
		    
		    HashMap<Character, Integer> hm = new HashMap<>();
		    ArrayList<String> list = new ArrayList<>();
		    
		    for(int i = 0; i < s.length(); i++) 
		        hm.put(s.charAt(i), hm.getOrDefault(s.charAt(i), 0) + 1);
		    
		    list.add(s);
		    if(map.containsKey(hm)) {
		        ArrayList<String> l = map.get(hm);
		        l.add(s);
		        map.put(hm, l);
		    }
		    else
		        map.put(hm, list);
		}
		
		List<List<String>> ans = new ArrayList<>();
		
		for(HashMap<Character, Integer> key : map.keySet()) {
		    ans.add(map.get(key));
		}

		return ans;
    }
}
