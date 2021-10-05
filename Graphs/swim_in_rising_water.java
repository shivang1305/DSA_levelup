import java.util.*;



public class swim_in_rising_water {
    private class Pair implements Comparable<Pair> {
        int row;
        int col;
        int msf; // max so far in the path
        
        Pair(int row, int col, int msf) {
            this.row = row;
            this.col = col;
            this.msf = msf;
        }
        
        @Override
        public int compareTo(Pair p) {
            return this.msf - p.msf;
        }
    }
    
    // Same as dijkstra algo, just the diff is that here we are adding max so far in the path instead of path sum
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, 0, grid[0][0]));
        
        while(!pq.isEmpty()) {
            Pair rem = pq.remove();
            
            if(rem.row == n - 1 && rem.col == n - 1)
                return rem.msf;
            
            if(visited[rem.row][rem.col] == false) {
                visited[rem.row][rem.col] = true;
                
                for(int[] dir : dirs) {
                    int r = rem.row + dir[0];
                    int c = rem.col + dir[1];
                    
                    if(r >= 0 && c >= 0 && r < n && c < n && visited[r][c] == false) 
                        pq.add(new Pair(r, c, Math.max(rem.msf, grid[r][c])));
                }
            }
        }
        return -1;
    }
    
    // Time complexity = O(ElogV) -> since priority queue is used
    // Time complexity = O(V) 
}
