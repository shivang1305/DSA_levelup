/*
    DSA Level-Up - RECURSION & BACKTRACKING                                               Date: 09-Feb-2020

    K Length Words - 2

1. You are given a word (may have one character repeat more than once).
2. You are given an integer k.
3. You are required to generate and print all k length words (of distinct chars) by using chars of the 
   word.
*/  



public static void generateWords(int cs, int ts, String ustr, HashSet < Character > used, String asf) {
    // base case
    if(cs > ts) { // when current selected exceeds total selected chars
        System.out.println(asf);
        return;
    }
    
    /**
     * taking characters as options
     * and slots as levels
     */
    
    for(int i = 0; i < ustr.length(); i++) { // traversing the unique string (options)
        char ch = ustr.charAt(i);
        
        if(!used.contains(ch)) { // only if the character is not previously used
            
            used.add(ch); // adding the character to used hashset (marking the character as used)
            
            generateWords(cs + 1, ts, ustr, used, asf + ch);
            
            used.remove(ch); // unmark the character (undo while backtracking)
        }
    }
}