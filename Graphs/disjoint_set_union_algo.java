import java.util.*;

public class disjoint_set_union_algo {

    static int[] parent;
    static int[] rank;

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        scn.close();

        parent = new int[n];
        rank = new int[n];

        for(int i = 0; i < n; i++)
            parent[i] = i; // initially every node is the parent of itself or leader of its own group

        // Can call union() & find() function for performing Disjoint set union algorithm
    }

    public static int find(int x) {
        if(parent[x] == x) // base condition of recursive function
            return x;

        return parent[x] = find(parent[x]); // path compression
    }

    public static void union(int u, int v) {
        u = find(u);
        v = find(v);

        // union by rank method
        if(rank[u] > rank[v])
            parent[v] = u;

        else if(rank[u] < rank[v])
            parent[u] = v;

        else {
            parent[u] = v;
            rank[v]++;
        }
    }

    // TC of single union() & find() without any optimization algo (i.e. path compression and union by rank) = O(n)

    // TC of single union() & find() with any 1 optimization algo (i.e. path compression or union by rank) = O(log n)

    // TC of single union() & find() with both optimization algos (i.e. path compression and union by rank) = O(1)
}