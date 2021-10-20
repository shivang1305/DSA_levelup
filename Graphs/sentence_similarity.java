import java.util.*;


public class sentence_similarity {
    static HashMap<String, String> parent;
    static HashMap<String, Integer> rank;
    
    public static boolean areSentencesSimilarTwo(String[] Sentence1, String[] Sentence2, String[][] pairs) {
        int n = Sentence1.length;
        
        if(Sentence1.length != Sentence2.length)
            return false;
            
        parent = new HashMap<>();
        rank = new HashMap<>();
        
        for(String[] pair : pairs) 
            union(pair[0], pair[1]);
        
        for(int i = 0; i < n; i++) {
            String u = Sentence1[i];
            String v = Sentence2[i];
            
            if(!u.equals(v) && find(u).equals(find(v)) == false)
                return false;
        }
        return true;
    }
    
    public static void union(String u, String v) {
        u = find(u);
        v = find(v);
        
        if(rank.get(u) > rank.get(v))
            parent.put(v, u);
            
        else if(rank.get(u) < rank.get(v))
            parent.put(u, v);
            
        else {
            parent.put(u, v);
            rank.put(v, rank.get(v) + 1);
        }
    } 
    
    public static String find(String x) {
        // initialization of parent and rank array
        if(!parent.containsKey(x)) { 
            parent.put(x, x);
            rank.put(x, 0);
        }
        
        if(parent.get(x).equals(x))
            return x;
            
        String temp = find(parent.get(x));
        parent.put(x, temp); // path compression
        return temp;
    }
    
    // Time complexity = O(n)
    // Space complexity = O(n)
}
