import java.util.*;


public class min_swaps_to_sort_array {
    static class Pair implements Comparable<Pair> {
        int val;
        int idx;
    
        Pair(int val, int idx) {
          this.val = val;
          this.idx = idx;
        }
    
        @Override
        public int compareTo(Pair o) {
          return this.val - o.val;
        }
    }

    public static int minSwaps(int[] arr1) {
        Pair[] arr = new Pair[arr1.length];
        
        for(int i = 0; i < arr1.length; i++) 
            arr[i] = new Pair(arr1[i], i);
            
        Arrays.sort(arr);
        
        int ans = 0;
        boolean[] visited = new boolean[arr.length];
        
        for(int i = 0; i < arr.length; i++) {
            if(visited[i] == false && arr[i].idx != i) {
                int cycleLen = 0, j = i;
                
                while(visited[j] == false) {
                    visited[j] = true;
                    cycleLen++;
                    j = arr[j].idx;
                }
                
                ans += (cycleLen - 1);
            }
        }
        
        return ans;
      }

      // Time complexity = O(n.logn) (for sorting) + O(n) (for detecting and calculating cycle length) = O(n.logn)
      // Space complexity = O(2n)
}
