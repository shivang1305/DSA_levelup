// Leetcode - Medium (Que 1254)
// 0 -> land
// 1 -> water
// number of connected components of land which are completely surrounded by water 
// should not consider boundary land elements in the given grid

public class number_of_closed_islands {
    public int closedIsland(int[][] arr) {
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[0].length; j++) {
                if(i == 0 || j == 0 || i == arr.length - 1 || j == arr[0].length - 1)
                    dfs(arr, i, j); // call DFS from boundary land elements of the grid and mark them because they cannot be a closed island
            }
        }
        
        int count = 0;
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[0].length; j++) {
                if(arr[i][j] == 0) {
                    dfs(arr, i, j); // now call DFS from the remaining land cells and calculate the number of connected components in them 
                    count++; // which is the number of closed islands
                }
            }
        }
        
        return count;
    }
    
    public static void dfs(int[][] arr, int i, int j) {
      // boundary check
      if(i < 0 || j < 0 || i >= arr.length || j >= arr[0].length || arr[i][j] == 1)
        return;
        
      arr[i][j] = 1;
      
      dfs(arr, i + 1, j);
      dfs(arr, i - 1, j);
      dfs(arr, i, j + 1);
      dfs(arr, i, j - 1);
  }
}
