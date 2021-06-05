/* ADVANCED HASHMAPS & HEAPS                                                        Date: 05-Jun-2021
1. You are given an array(arr) of integers. Values may be duplicated.
2. You have to find the length of the largest subarray with contiguous elements.

Note -> The contiguous elements can be in any order(not necessarily in increasing order).

Input:
3
10 12 11

Output:
3
*/

import java.util.*;

public class largest_subarray_of_contiguous_elements {

	public static int solution(int[] arr) {
		HashSet<Integer> hs;
		int maxEle = Integer.MIN_VALUE, minEle = Integer.MAX_VALUE, ans = 0;
		
		for(int i = 0; i < arr.length; i++) {
		    
		    // update the min max values and hashset in every iteration
		    minEle = Integer.MAX_VALUE;
		    maxEle = Integer.MIN_VALUE;
		    
		    hs = new HashSet<>(); // it is used to avoid duplicacy in the subarray of contiguous elements
		    
		    for(int j = i; j < arr.length; j++) {
		        hs.add(arr[j]);
		        
		        maxEle = Math.max(maxEle, arr[j]);
		        minEle = Math.min(minEle, arr[j]);
		        
		        if(maxEle - minEle == j - i && hs.size() == j - i + 1) // this is the trick to obtain the subarray of contiguous elements with duplicacy
		            ans = Math.max(ans, j - i + 1);
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
		System.out.println(solution(arr));
	}

}
