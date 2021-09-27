// Leetcode Medium (Que. 1162)
// 1 -> land, 0 -> water
// Calculate the max distance possible of water from the land. 

import java.util.*;

class as_far_from_land_as_possible {
    int[][] dirs = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
    
    public int maxDistance(int[][] grid) {
        Queue<int[]> que = new ArrayDeque<>();
        
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1)
                    que.add(new int[]{i, j}); // simultaneous BFS from all 1's present initially in the matrix (multisource BFS)
            }
        }
        
        if(que.size() == 0 || que.size() == grid.length * grid[0].length)
            return -1;
        
        int level = -1;
        while(!que.isEmpty()) {
            level++; // it signifies the dist of the curr level zeroes from the ones
            int size = que.size();
            
            while(size-- > 0) { // for treating each level differently
                int[] p = que.remove();
            
                for(int[] dir : dirs) {
                    int nx = p[0] + dir[0];
                    int ny = p[1] + dir[1];

                    if(nx >= 0 && ny >= 0 && nx < grid.length && ny < grid[0].length && grid[nx][ny] == 0) {
                        grid[nx][ny] = 1;
                        que.add(new int[]{nx, ny});
                    }
                }
            }
        }
        
        return level;
    }
    
    // Time complexity = O(V + E) = O(m * n)  (m -> grid.length, n -> grid[0].length)
    // Space complexity = O(V)
}