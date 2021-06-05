/* ADVANCED HASHMAPS & HEAPS                                                        Date: 05-Jun-2021
Given a binary array nums, return the maximum number of consecutive 1's in the array if you can flip at most 1 zero.

Example 1:
Input: nums = [1 1 0 0 1 1]
Output: 3
Explanation: [1 1 1 0 1 1]

One zero is flipped if you flip either of the zero to one the length of max consecutive ones will be 3
*/

import java.util.*;

public class max_consecutive_ones_with_1_flip {

    public static int solution(int[] arr){
        int j = -1, count = 0, ans = 0;
        
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == 0)
                count++;
                
            while(count > 1) {
                j++;
                if(arr[j] == 0)
                    count--;
            }
            
            int len = i - j;
            ans = Math.max(ans, len);
        }

        return ans;
    }
    
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i  < n; i++){
            arr[i] = scn.nextInt();
        }
        scn.close();
        System.out.println(solution(arr));
	}

}
