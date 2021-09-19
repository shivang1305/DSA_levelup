import java.util.*;

public class negative_weight_cycle_detection {
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

        System.out.println(negativeCycleDetect(arr, 0, vertices, edges));
    }

    public static int negativeCycleDetect(int[][] arr, int src, int vertices, int edges) {
        int[] path = new int[vertices];
        Arrays.fill(path, Integer.MAX_VALUE);

        path[src] = 0;

        for(int i = 0; i < vertices - 1; i++) {
            for(int j = 0; j < edges; j++) {
                int u = arr[j][0];
                int v = arr[j][1];
                int wt = arr[j][2];

                if(path[u] != Integer.MAX_VALUE && path[u] + wt < path[v])
                    path[v] = path[u] + wt;
            }
        }

        for(int j = 0; j < edges; j++) {
            int u = arr[j][0];
            int v = arr[j][1];
            int wt = arr[j][2];

            if(path[u] != Integer.MAX_VALUE && path[u] + wt < path[v])
            // if after doing (v - 1) iterations again the compiler is entering into this if condition then it simply means that graph contains negative weight cycle
                return 1; 
        }

        return 0; // else graph does not contain any negative weight cycle
    }
    // m -> edges, n -> vertices
    // Time complexity = O(m.n)
    // Space complexity = O(n)
}