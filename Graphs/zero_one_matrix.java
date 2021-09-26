// Find the shortest distance of all 1's present in the given matrix with O's.
// Instead of applying BFS from all the 1's, we apply the BFS from all the zeroes which reduces the time complexity 

import java.util.*;

public class zero_one_matrix {
    private static class Pair {
        int x;
        int y;
    
        Pair(int x, int y) {
          this.x = x;
          this.y = y;
        }
      }
    
      private static int[][] dirs = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
      
      public static int[][] updateMatrix(int[][] matrix) {
        Queue<Pair> que = new ArrayDeque<>();
        
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0)
                    que.add(new Pair(i, j));
                else
                    matrix[i][j] = -1;
            }
        }
        
        while(!que.isEmpty()) {
            Pair p = que.remove();
            
            for(int[] dir : dirs) {
                int nx = p.x + dir[0];
                int ny = p.y + dir[1];
                
                if(nx >= 0 && ny >= 0 && nx < matrix.length && ny < matrix[0].length && matrix[nx][ny] < 0) {
                    matrix[nx][ny] = matrix[p.x][p.y] + 1;
                    que.add(new Pair(nx, ny));
                }
            }
        }
        
        return matrix;
      }
}
