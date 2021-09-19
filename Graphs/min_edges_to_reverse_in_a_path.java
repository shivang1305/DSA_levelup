import java.util.*;

public class min_edges_to_reverse_in_a_path {
    static class Edge {
        int src;
        int nbr;
        int wt;

        Edge(int src, int nbr, int wt) {
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
    }

	public static void main(String[] args)  {
		Scanner scn = new Scanner(System.in);
		String[] str = scn.nextLine().split(" ");
		int V = Integer.parseInt(str[0]);
		int E = Integer.parseInt(str[1]);
		
		List<List<Edge>> adj = new ArrayList<>();
		for(int i = 0; i < V; i++)
		    adj.add(new ArrayList<>());
		
		for(int i = 0; i < E; i++) {
		    str = scn.nextLine().split(" ");
		    int u = Integer.parseInt(str[0]) - 1;
		    int v = Integer.parseInt(str[1]) - 1;
		    
		    adj.get(u).add(new Edge(u, v, 0));
		    adj.get(v).add(new Edge(v, u, 1));
		}
        scn.close();
		
		int src = 0, dest = V - 1;
		boolean[] visited = new boolean[V];
		
		System.out.println(dijkstraAlgo(adj, src, dest, visited));
	}
	
	static class Pair implements Comparable<Pair> {
        int vertex;
        int wsf;
        
        Pair(int vertex, int wsf) {
            this.vertex = vertex;
            this.wsf = wsf;
        }
        
        public int compareTo(Pair p) { // sorting in priority queue is done on the basis of weight so far 
            return this.wsf - p.wsf;
        }
    }

    /* Approach 1 - Using simple Dijkstra algorithm */
	
	public static int dijkstraAlgo(List<List<Edge>> adj, int src, int dest, boolean[] visited) {
	    PriorityQueue<Pair> pq = new PriorityQueue<>();
	    pq.add(new Pair(src, 0));
	    
	    while(!pq.isEmpty()) {
	        Pair p = pq.remove();
	        
	        if(p.vertex == dest)
	            return p.wsf;
	        
	        visited[p.vertex] = true;
	        
	        for(Edge e : adj.get(p.vertex)) {
	            if(visited[e.nbr] == false)
	                pq.add(new Pair(e.nbr, p.wsf + e.wt));
	        }
	    }
	    
	    return -1;
	} 

    // Time complexity = O(E.logV) -> logV is the TC of removing elements from priority queue
    // Space complexity = O(V)

    /* Approach 2 - (0-1 BFS Algo) Using Dijkstra with a normal queue rather than a priority queue.

       Since the edge weights can be either 0 or 1 so we can have only two types of 
       values in the queue i.e. 'y' or 'y + 1' at any point of time.

       So for handling only two types of values we don't need a priority queue rather we can handle this using a normal queue by making a partition in the queue adding 'y' sum element in the beginning of the queue and 'y+1' elements in the end of the queue and remove always from the beginning.
    */

    public static int dijkstraAlgo2(List<List<Edge>> adj, int src, int dest, boolean[] visited) {
	    LinkedList<Pair> que = new LinkedList<>();
	    que.addFirst(new Pair(src, 0));
	    
	    while(!que.isEmpty()) {
	        Pair p = que.removeFirst();
	        
	        if(p.vertex == dest)
	            return p.wsf;
	        
	        visited[p.vertex] = true;
	        
	        for(Edge e : adj.get(p.vertex)) {
	            if(visited[e.nbr] == false) {
                    if(e.wt == 0)
	                    que.addFirst(new Pair(e.nbr, p.wsf + e.wt));

                    else
	                    que.addLast(new Pair(e.nbr, p.wsf + e.wt));
                }
	        }
	    }
	    return -1;
	} 

    // Time complexity = O(V+E)
    // Space complexity = O(V)
}
