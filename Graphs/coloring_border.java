// Leetcode - Medium (Que 1034)
// Color the border of the connected component of the given element in the grid with the given color

public class coloring_border {
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        dfs(grid, row, col, grid[row][col]); // dfs call with color same as that of given element
        
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] < 0) // now color all the negative elements(visited elements only) in the grid
                    grid[i][j] = color;
            }
        }
        
        return grid;
    }
    
    int[][] dirs = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    
    public void dfs(int[][] grid, int i, int j, int color) {
        grid[i][j] = -color; // mark visited
        int count = 0; // it signifies that the curr element is surrounded by how many same elements
        
        for(int[] dir : dirs) {
            int row = i + dir[0];
            int col = j + dir[1];
            
            // boundary check & element value must be same as that of what we are searching for
            if(row >= 0 && col >= 0 && row < grid.length && col < grid[0].length && Math.abs(grid[row][col]) == color) { 
                count++;
                
                if(grid[row][col] == color)
                    dfs(grid, row, col, color);
            }
        }
        
        if(count == 4) // this means that curr element is not a boundary element
            grid[i][j] = color; // uncolor this or unvisit this
    }
}
