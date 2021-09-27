import java.util.*;

public class shortest_bridge {
    static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    
    public static int shortestBridge(int[][] grid) {
        boolean flag = false;
        
        Queue<int[]> que = new ArrayDeque<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        
        for(int i = 0; i < grid.length && !flag; i++) {
            for(int j = 0; j < grid[0].length && !flag; j++) {
                if(grid[i][j] == 1) {
                    DFS(grid, i, j, visited, que); // call DFS from 1st 1 we found in matrix & fill all the connected component element (1's of this island) into the queue
                    flag = true;
                }
            }
        }
        
        int level = 0;
        
        // BFS levelwise 
        while(!que.isEmpty()) {
            int size = que.size();
            
            while(size-- > 0) {
                int[] cell = que.remove();
                
                for(int[] dir : dirs) {
                    int row = cell[0] + dir[0];
                    int col = cell[1] + dir[1];

                    if(row >= 0 && col >= 0 && row < grid.length && col < grid[0].length && visited[row][col] == false) { 
                        if(grid[row][col] == 1)
                            return level;
                        
                        que.add(new int[]{row, col});
                    }
                }
                level++;
            }
        }
        return -1;
    }
    
    private static void DFS(int[][] grid, int i, int j, boolean[][] visited, Queue<int[]> que) {
        visited[i][j] = true; // mark visited
        que.add(new int[]{i, j}); // add into the queue
        
        for(int[] dir : dirs) {
            int row = i + dir[0];
            int col = j + dir[1];
            
            // boundary check 
            if(row >= 0 && col >= 0 && row < grid.length && col < grid[0].length && grid[i][j] == 1 && visited[row][col] == false) 
                DFS(grid, row, col, visited, que); // DFS recursive call
        }
    }

    // Time complexity = O(V + E)
    // Space complexity = O(V) (beacause of visited array)

    /* Approach 2 - Without using 2D visited array (saves on space complexity) */

    int[][] dirs2 = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    
    public int shortestBridge2(int[][] grid) {
        boolean flag = false;
        Queue<int[]> que = new ArrayDeque<>();
        
        for(int i = 0; i < grid.length && !flag; i++) {
            for(int j = 0; j < grid[0].length && !flag; j++) {
                if(grid[i][j] == 1) {
                    DFS(grid, i, j, que);
                    flag = true;
                }
            }
        }
        
        int level = 0;
        
        while(!que.isEmpty()) {
            int size = que.size();
            
            while(size-- > 0) {
                int[] cell = que.remove();
                
                for(int[] dir : dirs) {
                    int row = cell[0] + dir[0];
                    int col = cell[1] + dir[1];

                    if(row >= 0 && col >= 0 && row < grid.length && col < grid[0].length && grid[row][col] != -1) { 
                        if(grid[row][col] == 1)
                            return level;
                        
                        grid[row][col] = -1;
                        que.add(new int[]{row, col});
                    }
                }
            }
            level++;
        }
        return -1;
    }
    
    private void DFS(int[][] grid, int i, int j, Queue<int[]> que) {
        grid[i][j] = -1; // mark visited
        que.add(new int[]{i, j}); // add the current element of 1 into que
        
        for(int[] dir : dirs) {
            int row = i + dir[0];
            int col = j + dir[1];
            
            if(row >= 0 && col >= 0 && row < grid.length && col < grid[0].length && grid[row][col] == 1) 
                DFS(grid, row, col, que);
        }
    }

    // Time complexity = O(V + E)
    // Space complexity = O(1) (except for the space taken by queue which is less than V)
}
