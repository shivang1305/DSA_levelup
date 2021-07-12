/* ADVANCED HASHMAPS & HEAPS                                                        Date: 03-Jun-2021
1. You are given a string(str) and a number K.
2. You have to find the count of valid substrings of the given string.
3. Valid substring is defined as a substring that has exactly K unique characters.

NOTE: Duplicate substrings are allowed 
*/

import java.util.*;

public class count_substrings_with_k_unique_chars {
    // this function defines the solution for k = 1
    public static int sol(String str, int k) { // acquire and release strategy using single hashmap
        HashMap<Character, Integer> hm = new HashMap<>();
        int i = -1, j = -1, count = 0;
        
        // acquire
        while(true) {
            boolean f1 = false, f2 = false;
            
            while(i < str.length() - 1) {
                f1 = true;
                i++;
                char ch = str.charAt(i);
                
                hm.put(ch, hm.getOrDefault(ch, 0) + 1); // freq map
                
                if(hm.size() == 2) { // delete the last element when exceeds the alotted size
                    removeFromMap(hm, ch);
                    i--;
                    break;
                }
            }
            
            // release
            while(j < i) {
                f2 = true;
                if(hm.size() == 1) // add only if size of hashmap is equal to 1 i.e. k
                    count += i - j;
                    
                j++;
                char ch = str.charAt(i);
                
                removeFromMap(hm, ch);
                
                if(hm.size() == 0)
                    break;
            }
            
            if(f1 == false && f2 == false)
                break;
        }
        return count;
    }

	public static int solution(String str, int k){ // acquire and release strategy using two hashmaps
	    if(k == 1)
	        return sol(str, k);
	    
		int ib = -1, is = -1, j = -1, count = 0;
		
		HashMap<Character, Integer> bhm = new HashMap<>(); // big hashmap
		HashMap<Character, Integer> shm = new HashMap<>(); // small hashmap
		
		while(true) {
		    boolean f1 = false, f2 = false, f3 = false;
		    
		    // acquire from big hashmap
		    while(ib < str.length() - 1) {
		        f1 = true;
		        ib++;
		        char ch = str.charAt(ib);
		        
		        bhm.put(ch, bhm.getOrDefault(ch, 0) + 1);
		        
		        if(bhm.size() == k + 1) {
		            removeFromMap(bhm, ch);
		            ib--;
		            break;
		        }
		        
		    }
		    
		    // acquire from small hashmap
		    while(is < ib) {
		        f2 = true;
		        is++;
		        char ch = str.charAt(is);
		        
		        shm.put(ch, shm.getOrDefault(ch, 0) + 1);
		        
		        if(shm.size() == k) {
		            removeFromMap(shm, ch);
		            is--;
		            break;
		        }
		        
		    }
		    
		    //release from both hashmaps simultaneously
		    while(j < is) {
		        f3 = true;
		        
		        if(bhm.size() == k && shm.size() == k - 1) 
		            count += ib - is;
		        
		        j++;
		        char ch = str.charAt(j);
		        
		        removeFromMap(shm, ch);
		        removeFromMap(bhm, ch);
		        
		        if(shm.size() < k - 1 || bhm.size() < k)
		            break;
		    }
		    
		    if(f1 == false && f2 == false && f3 == false)
		        break;
		}

		return count;
	}
	
	public static void removeFromMap(HashMap<Character, Integer> hm, char ch) {
	    if(hm.get(ch) == 1)
	        hm.remove(ch);
	    else
	        hm.put(ch, hm.get(ch) - 1);
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
        String str = scn.next();
        int k = scn.nextInt();
        scn.close();
		System.out.println(solution(str,k));
	}

}
