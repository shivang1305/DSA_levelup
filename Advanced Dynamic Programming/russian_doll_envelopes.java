/* LEETCODE - HARD                                                                    Date: 20-May-2021
ou are given a 2D array of integers envelopes where envelopes[i] = [wi, hi] represents the width and the height of an envelope.

One envelope can fit into another if and only if both the width and height of one envelope are greater than the other envelope's width and height.

Return the maximum number of envelopes you can Russian doll (i.e., put one inside the other).

Note: You cannot rotate an envelope.


Example 1:

Input: envelopes = [[5,4],[6,4],[6,7],[2,3]]
Output: 3
Explanation: The maximum number of envelopes you can Russian doll is 3 ([2,3] => [5,4] => [6,7]).


Example 2:

Input: envelopes = [[1,1],[1,1],[1,1]]
Output: 1
*/

import java.util.*;

public class russian_doll_envelopes {
    public class Envelope implements Comparable<Envelope> {
        int length;
        int width;
        
        Envelope(int length, int width) {
            this.length = length;
            this.width = width;
        }
        
        public int compareTo(Envelope obj) {
            return this.length - obj.length;
        }
    }
    
    public int maxEnvelopes(int[][] envelopes) {
        Envelope[] e = new Envelope[envelopes.length];
        
        for(int i = 0; i < envelopes.length; i++) 
            e[i] = new Envelope(envelopes[i][0], envelopes[i][1]);
        
        Arrays.sort(e);
        
        int[] dp = new int[e.length];
        int ans = 0;
        for(int i = 0; i < dp.length; i++) {
            int max = 0;
            for(int j = 0; j < i; j++) {
                if(e[i].width > e[j].width && e[i].length > e[j].length)
                    max = Math.max(max, dp[j]);
            }
            
            dp[i] = max + 1;
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}