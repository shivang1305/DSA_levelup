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

    // Approach 2: When there can be a cycle in source and destinations
    // PriorityQueue is used to return the value in lexiographical order
    public List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String, PriorityQueue<String>> hm = new HashMap<>();
        
        for(int i = 0; i < tickets.size(); i++) {
            String key = tickets.get(i).get(0);
            String value = tickets.get(i).get(1);
            
            if(!hm.containsKey(key)) {
                PriorityQueue<String> temp = new PriorityQueue<>();
                hm.put(key, temp);
            }
            hm.get(key).add(value);
        }
        
        LinkedList<String> res = new LinkedList<>();
        dfs("JFK", hm, res);
        return res;
    }
    
    // DFS algo is applied
    public void dfs(String dep, HashMap<String, PriorityQueue<String>> hm, LinkedList<String> res) {
        PriorityQueue<String> arrivals = hm.get(dep);
        
        while(arrivals != null && !arrivals.isEmpty())
            dfs(arrivals.poll(), hm, res);
        
        res.addFirst(dep);
    }
}
