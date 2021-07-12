/* ADVANCED HASHMAPS & HEAPS                                                        Date: 01-Jun-2021
1. You are given a string str.
2. You have to find the smallest window length that contains all the unique characters of the given string.
*/

import java.util.*;

public class min_window_substring_length {
    public static int solution(String str){
		HashSet<Character> set = new HashSet<>();
		for(int i = 0; i < str.length(); i++) 
		    set.add(str.charAt(i));
		
		String s = "";
		for(char ch : set)
		    s += ch;
		
		return minWindow(str, s);
	}
	
	public static int minWindow(String str1, String str2) {
        String ans = "";
		HashMap<Character, Integer> map2 = new HashMap<>();
		
		// designing the freq map for str2
		for(int i = 0; i < str2.length(); i++) {
		    char ch = str2.charAt(i);
		    map2.put(ch, map2.getOrDefault(ch, 0) + 1);
		}
		
		HashMap<Character, Integer> map1 = new HashMap<>();
		int mct = 0, dmct = str2.length(); // match count & desired match count
		int i = -1, j = -1;
		
		while(true) {
		    boolean f1 = false, f2 = false; 
		    
		    // acquire
		    while(i < str1.length() - 1 && mct < dmct) {
		        i++;
		        char ch = str1.charAt(i);
		        map1.put(ch, map1.getOrDefault(ch, 0) + 1);
		        
		        if(map1.get(ch) <= map2.getOrDefault(ch, 0))
		            mct++;
		            
		        f1 = true;
		    }
		    
		    while(j < i && mct == dmct) {
		        // collect ans
		        String str = str1.substring(j + 1, i + 1);
		        if(ans.length() == 0 || str.length() < ans.length()) // min length substring
		            ans = str;
		            
		        // release
		        j++;
		        char ch = str1.charAt(j);
		        if(map1.get(ch) == 1)
		            map1.remove(ch);
		        else
		            map1.put(ch, map1.get(ch) - 1);
		            
		        if(map1.getOrDefault(ch, 0) < map2.getOrDefault(ch, 0))
		            mct--;
		        
		        f2 = true;
		    } 
		    if(f1 == false && f2 == false) // condition to get out of this infinite loop
		        break;
		}
		
		return ans.length();
    }    
}
