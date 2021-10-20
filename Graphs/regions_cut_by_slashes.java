public class regions_cut_by_slashes {
    int[] parent;
    int[] rank;
    int countRegions;
    
    public int regionsBySlashes(String[] grid) {
        int n = grid.length;
        int dots = n + 1; // we will be dealing in terms of dots rather than lines
        
        // creating parent and rank arrays for DSU
        parent = new int[dots * dots];
        rank = new int[dots * dots];
        countRegions = 1;
        
        // initialization of parent array
        for(int i = 0; i < parent.length; i++)
            parent[i] = i;
        
        // connect the boundary dots
        for(int i = 0; i < dots; i++) {
            for(int j = 0; j < dots; j++) {
                if(i == 0 || j == 0 || i == dots - 1 || j == dots - 1) {
                    int cellNo = i * dots + j;
                    
                    if(cellNo != 0)
                        union(0, cellNo);
                }
            }
        }
        
        for(int i = 0; i < n; i++) {
            char[] ch = grid[i].toCharArray();
            for(int j = 0; j < ch.length; j++) {
                if(ch[j] == '/') {
                    int cellNo1 = i * dots + (j + 1);
                    int cellNo2 = (i + 1) * dots + j;
                    
                    union(cellNo1, cellNo2);
                }
                
                else if(ch[j] == '\\') {
                    int cellNo1 = i * dots + j;
                    int cellNo2 = (i + 1) * dots + (j + 1);
                    
                    union(cellNo1, cellNo2);
                }
            }
        }
        
        return countRegions;
    }
    
    private int find(int x) {
        if(parent[x] == x)
            return x;
        
        return parent[x] = find(parent[x]);
    }
    
    private void union(int u, int v) {
        u = find(u);
        v = find(v);
        
        if(u != v) {
            if(rank[u] > rank[v])
                parent[v] = u;
            
            else if(rank[u] < rank[v])
                parent[u] = v;
                
            else {
                parent[u] = v;
                rank[v]++;
            }
        }
        
        else
            countRegions++; // count will be increased when cycle is created
    }
    
    // Time complexity = O(n^2)
    // Space complexity = O(n^2)
}
