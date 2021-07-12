/* ADVANCED HASHMAPS & HEAPS                                                        Date: 29-May-2021
1. You are given an array(arr) of integers and a number K.
2. You have to find the count of distinct numbers in all windows of size k.
*/

import java.util.*;

public class count_distinct_elements_in_every_window_of_size_k {
    public static ArrayList<Integer> solution(int[] arr, int k) {
	    ArrayList<Integer> ans = new ArrayList<>();
	    HashMap<Integer, Integer> hm = new HashMap<>();
		
		for(int i = 0; i < arr.length; i++) {
		    if(i < k - 1)
		        hm.put(arr[i], hm.getOrDefault(arr[i], 0) + 1);
		        
            else {
                hm.put(arr[i], hm.getOrDefault(arr[i], 0) + 1);
                ans.add(hm.size());
                
                int freq = hm.get(arr[i - k + 1]);
                if(freq == 1) 
                    hm.remove(arr[i - k + 1]);
                else 
                    hm.put(arr[i - k + 1], freq - 1);
            }
		}

		return ans;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int[] arr = new int[scn.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
		scn.close();
		int k = scn.nextInt();
		ArrayList<Integer> ans = solution(arr,k);
		for(int a : ans){
			System.out.print(a + " ");
		}
	}
}
