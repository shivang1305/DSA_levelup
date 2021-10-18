import java.util.*;


public class number_of_islands_2 {
    public static List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> ans = new ArrayList<>();
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        
        int[] parent = new int[m * n];
        int[] rank = new int[m * n];
        
        Arrays.fill(parent, -1); // -1 indicates that the current cell no is not processed
        int countIslands = 0;
        
        for(int i = 0; i < positions.length; i++) {
            int row = positions[i][0];
            int col = positions[i][1];
            
            int cellNo = ((row * n) + col); // curr cell no
            
            if(parent[cellNo] != -1) {
                ans.add(countIslands);
                continue;
            }
            
            parent[cellNo] = cellNo;
            rank[cellNo] = 1;
            countIslands++;
            
            for(int[] dir : dirs) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];
                
                int newCellNo = ((newRow * n) + newCol); // neighbour cell no
                
                if(newRow >= 0 && newCol >= 0 && newRow < m && newCol < n && parent[newCellNo] != -1) {
                    // merging or union of curr cell no and neighbour cell no
                    int lx = find(cellNo, parent);
                    int ly = find(newCellNo, parent);
                    
                    if(lx != ly) {
                        if(rank[lx] > rank[ly])
                          parent[ly] = lx;
                          
                        else if(rank[lx] < rank[ly])
                          parent[lx] = ly;
                          
                        else {
                            parent[lx] = ly;
                            rank[ly]++;
                        }
                        countIslands--; // after merging reduce the islands count by 1
                    }
                }
            }
            ans.add(countIslands);
        }
        return ans;
    }
    
    public static int find(int x, int[] parent) {
        if(parent[x] == x)
          return x;
          
        return parent[x] = find(parent[x], parent);
    }
}

// Time complexity = O(m * n + K)
// Space complexity = O(m * n)