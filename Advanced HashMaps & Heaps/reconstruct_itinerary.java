/* ADVANCED HASHMAPS & HEAPS                                                        Date: 27-May-2021
1. You are given number N and 2*N number of strings that represent a list of N tickets(source and destination).
2. You have to find the itinerary in order using the given list of tickets.

Assumption -> The input list of tickets is not cyclic and there is one ticket from every city except the final destination.
*/

import java.util.*;

public class reconstruct_itinerary {
    public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int noofpairs_src_des = scn.nextInt();
		HashMap<String, String> map = new HashMap<>();
		for (int i = 0; i < noofpairs_src_des; i++) {
			String s1 = scn.next();
			String s2 = scn.next();
			map.put(s1, s2);	
		}

        scn.close();

		HashMap<String, Boolean> hm = new HashMap<>();
		
        // to find the orignal source of whole chain
		for(String source : map.keySet()) {
		    String des = map.get(source);
		    
		    if(hm.containsKey(des) && hm.get(des) == true) 
		        hm.put(des, false);
		    
		    else if(!hm.containsKey(des))
		        hm.put(des, false);
		    
		    if(!hm.containsKey(source))    
		        hm.put(source, true);
		}
        
        String source = "";
        for(String s : hm.keySet()) {
            if(hm.get(s))
                source = s;
        }
        
        String ans = "";
        while(true) {
            if(map.containsKey(source)) {
                ans += source + " -> ";
                source = map.get(source);
            }
            else {
                ans += source + ".";
                break;
            }
        }
        
        System.out.println(ans);

	}
}
