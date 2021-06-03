/* ADVANCED HASHMAPS & HEAPS                                                        Date: 03-Jun-2021
1. You are given a string.
2. You have to find the count of valid substrings of the given string.
3. Valid substring is defined as a substring that has all unique characters.

Input: aabcbcdbca
Output: 24  
*/

import java.util.*;

public class count_all_substrings_with_unique_chars {
    public static int solution(String s) {
		HashMap<Character, Integer> hm = new HashMap<>();
        int count = 0;
        
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
                else // colllect ans
                    count += i - j;
            }
            
            // release
            while(j < i) {
                f2 = true;
                j++;
                
                char ch = s.charAt(j);
                
                hm.put(ch, hm.get(ch) - 1); // decrease the freq of char in hashmap
                if(hm.get(ch) == 1) {
                    count += i - j;
                    break;
                }
            }
            
            if(f1 == false && f2 == false)
                break;
        }
        return count;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		System.out.println(solution(str));
        scn.close();
	}
}
