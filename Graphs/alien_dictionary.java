import java.util.*;


public class alien_dictionary {
    public static String alienOrder(String[] words) {
        HashMap<Character, HashSet<Character>> graph = new HashMap<>();
        HashMap<Character, Integer> indegree = new HashMap<>();
        
        for(String str : words) {
            for(char ch : str.toCharArray())
              indegree.put(ch, 0); // set indegree map to zero for each char
        }
        
        for(int i = 0; i < words.length - 1; i++) {
            // check for adjacent strings only
            String curr = words[i];
            String next = words[i + 1];
            
            boolean flag = false;
            int len = Math.min(curr.length(), next.length());
            
            for(int j = 0; j < len; j++) {
                char ch1 = curr.charAt(j);
                char ch2 = next.charAt(j);
                if(ch1 != ch2) {
                    HashSet<Character> set = new HashSet<>();
                    
                    if(graph.containsKey(ch1)) {
                        set = graph.get(ch1);
                        
                        if(!set.contains(ch2)) {
                            set.add(ch2);
                            indegree.put(ch2, indegree.get(ch2) + 1); // updating the indegree
                            
                            graph.put(ch1, set); // making the graph
                        }
                    }
                    
                    else {
                        set.add(ch2);
                        indegree.put(ch2, indegree.get(ch2) + 1);
                        
                        graph.put(ch1, set);
                    }
                    flag = true;
                    break;
                }
            }
            
            // here flag = false shows that no mismatched char is found in the given two string and also the length of the curr is greater than next
            // which means wrong order is given no lexio sort is possible in this case
            if(flag == false && curr.length() > next.length())
              return "";
        }
        
        Queue<Character> que = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        
        // BFS of getting the topo sort i.e. Kahn's Algorithm
        for(char key : indegree.keySet()) {
            if(indegree.get(key) == 0)
              que.add(key);
        }
        
        int count = 0;
        while(!que.isEmpty()) {
            char rem = que.remove();
            
            sb.append(rem);
            count++;
            
            if(graph.containsKey(rem)) {
                HashSet<Character> nbrs = graph.get(rem);
                
                for(char nbr : nbrs) {
                    indegree.put(nbr, indegree.get(nbr) - 1);
                    
                    if(indegree.get(nbr) == 0)
                      que.add(nbr);
                }
            }
        }
        
        return (count == indegree.size()) ? sb.toString() : "";
    }
    
    // Time complexity = O(V + E)
    // Space complexity = O(V)
}