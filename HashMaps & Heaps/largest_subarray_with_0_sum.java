/* ADVANCED HASHMAPS & HEAPS                                                        Date: 01-Jun-2021
1. You are given an array(arr) of integers.
2. You have to find the length of the largest subarray with sum 0.
*/

import java.util.*;

public class largest_subarray_with_0_sum {
    public static int solution(int[] arr) {
	    HashMap<Integer, Integer> hm = new HashMap<>(); // hashmap will store the sum and its index
	    int sum = 0, maxLen = 0;

		// here we have initialized hashmap with zero sum because if the sum = 0 is repeated again in the array traversal then we can obtain the length of that subarray.

	    hm.put(0, -1); // sum = 0 at index = -1 before starting array traversal
	    
		for(int i = 0; i < arr.length; i++) {
		    sum += arr[i];
		    if(hm.containsKey(sum))
		        maxLen = Math.max(maxLen, i - hm.get(sum)); // length will be curr index - last index of same sum (which is obtained from the hashmap)
		    
		    else
		        hm.put(sum, i); 
		}
		return maxLen;
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int[] arr = new int[scn.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
        scn.close();
		System.out.println(solution(arr));
	}
}
