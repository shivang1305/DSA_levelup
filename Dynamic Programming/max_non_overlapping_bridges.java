/*                                                                                     Date: 20-May-2021
1. You are given a number n, representing the number of bridges on a river.
2. You are given n pair of numbers, representing the north bank and south bank co-ordinates of each bridge.
3. You are required to print the count of maximum number of non-overlapping bridges.
*/

import java.util.*;

public class max_non_overlapping_bridges {
    public static class Bridge implements Comparable<Bridge> {
        int north;
        int south;
        
        Bridge(int north, int south) {
            this.north = north;
            this.south = south;
        }
        
        public int compareTo(Bridge obj) { 
            if(this.north != obj.north) // when the north bank values are not equal
                return this.north - obj.north; // sort the bridges on the basis of north bank values
                
            else // when the north bank value is equal i.e. starting pt of the bridge is same
                return this.south - obj.south; // sort the bridge on the basis of south bank values
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = Integer.parseInt(scn.nextLine());
        
        Bridge[] bridges = new Bridge[n];
        
        for(int i = 0; i < n; i++) {
            String b = scn.nextLine();
            String[] parts = b.split(" "); 
            
            int north = Integer.parseInt(parts[0]);
            int south = Integer.parseInt(parts[1]);
            bridges[i] = new Bridge(north, south);
        }
        scn.close();
        Arrays.sort(bridges); // it will sort the bridges on the basis of north bank values
        
        // obtain the LIS of the south bank values ans that will be our final ans
        int[] dp = new int[n];
        int ans = 0;
        
        for(int i = 0; i < n; i++) {
            int max = 0;
            for(int j = 0; j < i; j++) {
                if(bridges[i].south >= bridges[j].south)
                    max = Math.max(max, dp[j]);
            }
            
            dp[i] = max + 1;
            ans = Math.max(ans, dp[i]);
        }
        
        System.out.println(ans);
    }
}