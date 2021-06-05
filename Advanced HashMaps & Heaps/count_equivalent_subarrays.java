/* ADVANCED HASHMAPS & HEAPS                                                        Date: 05-Jun-2021
1. You are given an array of integers(arr).
2. You have to find the count of equivalent subarrays.
3. A subarray is equivalent if, count of unique integers in the subarray = count of unique integers in the given array. 

Input:
5
2 1 3 2 3

Output:
5
*/


import java.util.*;

public class count_equivalent_subarrays {
    public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i  < n; i++){
            arr[i] = scn.nextInt();
        }
		scn.close();

		HashSet<Integer> hs = new HashSet<>();
		
		for(int i = 0; i < arr.length; i++) 
		    hs.add(arr[i]);
		
		int d = hs.size(); // number of distinct elements
		
		HashMap<Integer, Integer> hm = new HashMap<>();
		int i = -1, j = -1, count = 0;
		
		while(true) {
		    boolean f1 = false, f2 = false;
		    
		    // acquire
		    while(i < arr.length - 1) {
		       f1 = true;
		       i++;
		       
		       hm.put(arr[i], hm.getOrDefault(arr[i], 0) + 1);
		       
		       if(hm.size() == d) {
		           count += (arr.length - i);
		           break;
		       }
		    }
		    
		    // release
		    while(j < i) {
		        f2 = true;
		        j++;
		        
		        if(hm.get(arr[j]) == 1)
		            hm.remove(arr[j]);
		            
		        else 
		            hm.put(arr[j], hm.get(arr[j]) - 1);
		        
		        if(hm.size() == d)
		            count += arr.length - i;
		        
		        else if(hm.size() < d)
		            break;
		    }
		    
		    if(f1 == false && f2 == false)
		        break;
		}
		System.out.println(count);
	}
}
