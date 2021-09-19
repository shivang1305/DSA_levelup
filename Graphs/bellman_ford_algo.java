import java.util.*;


public class bellman_ford_algo {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String[] str = scn.nextLine().split(" ");
        int vertices = Integer.parseInt(str[0]);
        int edges = Integer.parseInt(str[1]);
        
        int[][] arr = new int[edges][3];
        
        for(int i = 0; i < edges; i++) {
            str = scn.nextLine().split(" ");
            
            // to make the given vertices zero based as 1 based indexing of vertices are given
            arr[i][0] = Integer.parseInt(str[0]) - 1; 
            arr[i][1] = Integer.parseInt(str[1]) - 1;
            arr[i][2] = Integer.parseInt(str[2]);
        }
        scn.close();
        
        int[] path = bellmanFord(arr, 0, vertices, edges);
        
        for(int i = 1; i < path.length; i++) {
            if(path[i] == Integer.MAX_VALUE)
                // if the vertex is not accessible from the src vertex of the graph(disconnected graph)
                System.out.print("1000000000 "); 
                
            else
                System.out.print(path[i] + " ");
        }
	}
	
	public static int[] bellmanFord(int[][] arr, int src, int vertices, int edges) {
	    int[] path = new int[vertices];
	    Arrays.fill(path, Integer.MAX_VALUE);
	    
	    // the dist from src to itself is zero (considering the graph can't contain negative weight cycle)
	    path[src] = 0; 
	    
	    for(int i = 0; i < vertices - 1; i++) {
	        for(int j = 0; j < edges; j++) {
	            int u = arr[j][0];
	            int v = arr[j][1];
	            int wt = arr[j][2];
	            
	            // if the curr path is smaller than the previously discovered path
	            if(path[u] != Integer.MAX_VALUE && path[u] + wt < path[v]) 
	                path[v] = path[u] + wt; // update the path
	        }
	    }
	    
	    return path;
	}

    // Time complexity = O((vertices - 1)*(edges))
    // Time complexity = O(1)
}
