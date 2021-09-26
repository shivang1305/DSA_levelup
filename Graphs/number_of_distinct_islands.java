// Differentiate distinct islands based on the shape of island (i.e. the number of 1's) in the given matrix

import java.util.*;


public class number_of_distinct_islands {
  public static StringBuilder psf = new StringBuilder(); // path so far string builder

  public static int numDistinctIslands(int[][] arr) {
    HashSet<String> set = new HashSet<>();
    
    for(int i = 0; i < arr.length; i++) {
        for(int j = 0; j < arr[0].length; j++) {
            if(arr[i][j] == 1) {
                psf = new StringBuilder();
                psf.append("1");
                
                DFS(arr, i, j);
                
                set.add(psf.toString());
            }
        }
    }
    
    return set.size();
  }
  
  public static void DFS(int[][] arr, int i, int j) {
      arr[i][j] = 0;
      
      if(i - 1 >= 0 && arr[i - 1][j] == 1) {
          psf.append("u"); // upwards
          DFS(arr, i - 1, j);
      }
      
      if(i + 1 < arr.length && arr[i + 1][j] == 1) {
          psf.append("d"); // downwards
          DFS(arr, i + 1, j);
      }
      
      if(j - 1 >= 0 && arr[i][j - 1] == 1) {
          psf.append("l"); // left
          DFS(arr, i, j - 1);
      }
      
      if(j + 1 < arr[0].length && arr[i][j + 1] == 1) {
          psf.append("r"); // right
          DFS(arr, i, j + 1);
      }
      
      psf.append("b"); // backtrack
  }
}
