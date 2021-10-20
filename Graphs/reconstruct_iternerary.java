import java.util.*;


public class reconstruct_iternerary {
    public List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String, PriorityQueue<String>> graph = new HashMap<>();
        LinkedList<String> ans = new LinkedList<>();
        
        for(List<String> ticket : tickets) {
            String source = ticket.get(0);
            String dest = ticket.get(1);
            
            PriorityQueue<String> pq;
            
            if(!graph.containsKey(source)) 
                pq = new PriorityQueue<>();  
            
            else 
                pq = graph.get(source);
            
            pq.add(dest);
            graph.put(source, pq);
        }
        
        DFS("JFK", graph, ans);
        return ans;
    }
    
    public void DFS(String src, HashMap<String, PriorityQueue<String>> graph, LinkedList<String> ans) {
        PriorityQueue<String> nbrs = graph.get(src);
        
        while(nbrs != null && !nbrs.isEmpty()) 
            DFS(nbrs.remove(), graph, ans);
        
        ans.addFirst(src);
    }
    
    // Time complexity = O(n^2) -> DFS time complexity
    // Space complexity = O(n) -> for making the graph
}
