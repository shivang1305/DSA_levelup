/* ADVANCED HASHMAPS & HEAPS                                                        Date: 02-Jun-2021
1. You are given a string(str) and a number K.
2. You have to find length of the longest substring that has exactly k unique characters.
3. If no such substring exists, print "-1".
*/

import java.util.*;

public class longest_substring_with_k_unique_chars {
    public static int solution(String str, int k){
		HashMap<Character, Integer> hm = new HashMap<>();
		int i = -1, j = -1, maxLen = Integer.MIN_VALUE;
		
		while(true) {
		    boolean f1 = false, f2 = false;
		    // acquire
		    while(i < str.length() - 1) {
		        f1 = true;
		        i++;
		        char ch = str.charAt(i);
		        
		        hm.put(ch, hm.getOrDefault(ch, 0) + 1);
		        
		        if(hm.size() > k)
		            break;
		        else if(hm.size() == k){
		            int len = i - j;
		            maxLen = Math.max(maxLen, len);
		        }
		    }
		    
		    //release
		    while(j < i) {
		        f2 = true;
		        j++;
		        char ch = str.charAt(j);
		        
		        if(hm.get(ch) == 1)
		            hm.remove(ch);
		        else  
		            hm.put(ch, hm.get(ch) - 1);
		        
				if(hm.size() == k) {
					int len = i - j;
					maxLen = Math.max(maxLen, len);
					break;
				}
		    }
		    
		    if(f1 == false && f2 == false)
		        break;
		}

		return maxLen;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
        String str = scn.next();
        int k = scn.nextInt();
		scn.close();
		System.out.println(solution(str,k));
	}
}
