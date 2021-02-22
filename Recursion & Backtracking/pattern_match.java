 /*
    DSA Level-Up - RECURSION & BACKTRACKING                                               Date: 22-Jan-2020

    Pattern Matching

1. You are given a string and a pattern. 
2. You've to check if the string is of the same structure as pattern without using any regular 
   expressions.

   Example: 
   Input -> graphtreesgraph
            pep

   Output -> p -> graph, e -> trees, . 
*/
 
 
 public static void solution(String str, String pattern, HashMap < Character, String > map, String op) {
        // base case
        if(pattern.length() == 0) {
            if(str.length() == 0) { // when pattern has ended then the string must also end
                HashSet<Character> hs = new HashSet<>(); 
                for(int i = 0; i < op.length(); i++) {
                    char ch = op.charAt(i);
                    if(hs.contains(ch) == false) { // to remove duplicacy while printing the answers
                        System.out.print(ch + " -> " + map.get(ch) + ", ");
                        hs.add(ch);
                    }
                }
                System.out.println(".");
            }
        return;
    }
    
    char ch = pattern.charAt(0); // first character of the pattern
    String rop = pattern.substring(1); // rest of the pattern
    
    if(map.containsKey(ch)) { // if that key is already mapped
        if(str.length() >= map.get(ch).length()) { // remaining string length must be greater than or equal to previous mapped string length
            String prefix = str.substring(0, map.get(ch).length());
            String ros = str.substring(map.get(ch).length());
            if(prefix.equals(map.get(ch))) 
                solution(ros, rop, map, op); // call
        }
    }
    else { // if that key is not mapped
        for(int i = 0; i < str.length(); i++) {
            String prefix = str.substring(0, i + 1);
            String ros = str.substring(i + 1);
            
            map.put(ch, prefix); // mapping the string with the character of the pattern
            solution(ros, rop, map, op); // call
            map.remove(ch); // unmapping the character while backtracking
            
        }
     }

}