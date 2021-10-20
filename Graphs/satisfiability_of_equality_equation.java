public class satisfiability_of_equality_equation {
    public boolean equationsPossible(String[] equations) {
        int[] parent = new int[26];
        int[] rank = new int[26];
        
        // initialization of the parent array for union() & find()
        for(int i = 0; i < 26; i++)
            parent[i] = i;
        
        for(String equation : equations) {
            char ch = equation.charAt(1);
            
            if(ch == '=') // dealing the equality equations first
                // putting these characters into the same group
                union(equation.charAt(0) - 'a', equation.charAt(3) - 'a', parent, rank);
        }
        
        for(String equation : equations) {
            char ch = equation.charAt(1);
            
            if(ch == '!') { // checking for inequality conditions now
                int lx = find(equation.charAt(0) - 'a', parent);
                int ly = find(equation.charAt(3) - 'a', parent);
                
                if(lx == ly) // if the characters of inequality belongs to the same group already
                    return false; // then the equations are contradictory
            }
        }
        
        return true; // none if the given equations are contradicting each other i.e. all equations can be satisfied simultaneously
    }
    
    public int find(int x, int[] parent) {
        if(parent[x] == x)
            return x;
        
        return parent[x] = find(parent[x], parent);
    }
    
    public boolean union(int u, int v, int[] parent, int[] rank) {
        u = find(u, parent);
        v = find(v, parent);
        
        if(u != v) {
            if(rank[u] > rank[v])
                parent[v] = u;
            
            else if(rank[u] < rank[v])
                parent[u] = v;
            
            else {
                parent[u] = v;
                rank[v]++;
            }
            return false;
        }
        return true;
    }
    
    // Time complexity = O(n)
    // Space complexity = O(n)
}
