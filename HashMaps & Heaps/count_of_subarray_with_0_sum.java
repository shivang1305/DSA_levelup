/* ADVANCED HASHMAPS & HEAPS                                                        Date: 01-Jun-2021
1. You are given an array(arr) of integers.
2. You have to find the count of all subarrays with sum 0.
*/


import java.util.*;

public class count_of_subarray_with_0_sum {
    public static int solution(int[] arr) {
		HashMap<Integer, Integer> hm = new HashMap<>();
	    int sum = 0, count = 0;
	    hm.put(0, 1); // sum and freq of that sum
	    
		for(int i = 0; i < arr.length; i++) {
		    sum += arr[i];
		    
		    if(hm.containsKey(sum)) {
		        hm.put(sum, hm.get(sum) + 1);
		        count += hm.get(sum) - 1;
		    }
		    else 
		        hm.put(sum, 1);
		    
		}
		return count;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
		}
        scn.close();
		System.out.println(solution(arr));

	}
}
