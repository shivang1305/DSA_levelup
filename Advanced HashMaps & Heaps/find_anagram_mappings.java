/* ADVANCED HASHMAPS & HEAPS                                                  Date: 09-Jun-2021
Given an array of strings strs, group the anagrams together. You can return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

 
Sample Input
6
1 2 3 4 5 2
4 3 2 1 5 2

Sample Output
3 2 1 0 4 5 
*/

import java.util.*;



public class find_anagram_mappings {
    public static int[] anagramMappings(int[] arr1, int[] arr2) {
	    HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
		ArrayList<Integer> list;
		
        // Mapping all indices to the element in the hashmap
		for(int i = 0; i < arr2.length; i++) {
		    
		    if(map.containsKey(arr2[i])) 
		        list = map.get(arr2[i]);
		    else 
		        list = new ArrayList<>();
		        
		    list.add(i);
		    map.put(arr2[i], list);
		}
		
		int[] ans = new int[arr1.length];
		
        // elements of array 1 are present on which index of array 2 
		for(int i = 0; i < arr1.length; i++) {
		    ArrayList<Integer> indices = map.get(arr1[i]);
		    
		    ans[i] = indices.get(0);
		    
		    if(indices.size() > 1)
		        indices.remove(0);
		}
		return ans;
	}
}
