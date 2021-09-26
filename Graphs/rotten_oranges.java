// Leetcode MEDIUM                                                         Date: 14-Sept-2021

import java.util.*;


public class rotten_oranges {
    // BFS Approach
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        Queue<int[]> que = new ArrayDeque<>();
        int countFresh = 0; // count the number of fresh oranges intitally exits in grid
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 2)
                    que.offer(new int[]{i, j}); // push all the rotten oranges into the queue
                
                else if(grid[i][j] == 1)
                    countFresh++;
            }
        }
        
        if(countFresh == 0) // if no fresh orange is there in the queue
            return 0;
        
        int count = 0;
        int[][] dirs = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}}; // all possible directions of movement for BFS
        
        while(countFresh != 0 && !que.isEmpty()) { 
            count++; // increasing the no of mins
            int size = que.size();
            
            while(size-- > 0) { // level order traversal (BFS)
                int[] remove = que.poll(); 
                
                for(int[] dir: dirs) {
                    int x = remove[0] + dir[0];
                    int y = remove[1] + dir[1];
                    
                    // if the index is getting out of the bounds of grid
                    // or the cell is empty
                    // or the cell contains already rotten orange
                    if(x >= 0 && y >= 0 && x < m && y < n && grid[x][y] == 1) { 
                        grid[x][y] = 2; // make the orange rotten at that place
                        que.offer(new int[]{x, y}); // push the indices of that place into the queue
                        
                        countFresh--; // decrement the number of fresh oranges left in the grid
                    }
                }
            }
        }
        
        return (countFresh == 0) ? count : -1;
    }
    
    // Time complexity = O(N^2)
    // Space complexity = O(N)
}