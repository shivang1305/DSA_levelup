/* ADVANCED HASHMAPS & HEAPS                                                        Date: 01-Jun-2021
1. You are given an array(arr) of integers.
2. You have to find the length of the largest subarray with sum 0.
*/

import java.util.*;

public class largest_subarray_with_0_sum {
    public static int solution(int[] arr) {
	    HashMap<Integer, Integer> hm = new HashMap<>();
	    int sum = 0, maxLen = 0;
	    hm.put(0, -1);
	    
		for(int i = 0; i < arr.length; i++) {
		    sum += arr[i];
		    if(hm.containsKey(sum))
		        maxLen = Math.max(maxLen, i - hm.get(sum));
		    
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
