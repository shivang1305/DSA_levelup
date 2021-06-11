/* ADVANCED HASHMAPS & HEAPS                                                  Date: 11-Jun-2021
1. You are given an array of strings.
2. You have to group the given strings in such a way that all strings in a group are shifted versions of each other. 
3. Two strings s1 and s2 are shifted if -
   -> Length of both the strings is the same.
   -> The difference between ASCII values of every character of s1 and s2 is constant.

Note -> Every string consists of lower-case English letters only.


Input:
    9
    acd dfg wyz yab mop bdfh a x moqs

Output:
    acd dfg mop wyz yab 
    a x 
    bdfh moqs 
*/

import java.util.*;




public class group_pair_shiftings {
    public static ArrayList<ArrayList<String>> groupShiftedStrings(String[] strs) {
		HashMap<String, ArrayList<String>> map = new HashMap<>();
		
		for(int i = 0; i < strs.length; i++) {
		    String key = "";
		    for(int j = 0; j < strs[i].length() - 1; j++) {
		        int diff = strs[i].charAt(j + 1) - strs[i].charAt(j);
		        
		        if(diff < 0) // since we are assuming that the alphabet sequence is circular in order i.e. after 'z', 'a' comes
		            diff += 26;
		        
		        // making a unique key for hashmap
		        if(j == 0)
		            key += diff;
		            
		        else
		            key += "#" + diff;
		    }
		    
		    ArrayList<String> list;
		    
		    if(map.containsKey(key)) 
		        list = map.get(key);
		    else 
		        list = new ArrayList<String>();
		    
		    // updating the list of arraylist
		    list.add(strs[i]);
		    map.put(key, list);
		}
		
		ArrayList<ArrayList<String>> ans = new ArrayList<>();
		
		for(String key : map.keySet()) // concatenating all the lists of the hashmap into a single list of lists
		    ans.add(map.get(key));
		    
		return ans;
	}
}
