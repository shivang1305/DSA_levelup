/* ADVANCED HASHMAPS & HEAPS                                                        Date: 05-Jun-2021
1. You are given a string(str) and a number K.
2. You have to find the count of substrings of the given string that contains at most K unique characters.


Input:
aabcbcdbca
2

Output:
23
*/


import java.util.*;

public class count_substrings_with_atmost_k_unique_chars {

	public static int solution(String str, int k) {
		HashMap<Character, Integer> hm = new HashMap<>();
        int i = -1, j = -1, ans = 0;
        
        // acquire
        while(true) {
    
            while(i < str.length() - 1) {
                i++;
                char ch = str.charAt(i);
                
                hm.put(ch, hm.getOrDefault(ch, 0) + 1); // freq map
                
                if(hm.size() <= k)  
                    ans += i - j;
                else
                    break;
            }
            
            if(i == str.length() - 1 && hm.size() <= k)
                break;
            
            // release
            while(j < i) {
                j++;
                char ch = str.charAt(j);
                
                if(hm.get(ch) == 1)
                    hm.remove(ch);
                else
                    hm.put(ch, hm.get(ch) - 1);
                
                if(hm.size() == k) {
                    ans += i - j;
                    break;
                }
            }
        }
        return ans;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
        String str = scn.next();
        int k = scn.nextInt();
        scn.close();
		System.out.println(solution(str,k));
	}

}

