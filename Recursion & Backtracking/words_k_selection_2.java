/*
    DSA Level-Up - RECURSION & BACKTRACKING                                               Date: 08-Feb-2020

    Words K Selection - 2

1. You are given a word (may have one character repeat more than once).
2. You are given an integer k.
2. You are required to generate and print all ways you can select k distinct characters out of the 
   word.
*/  



public static void generateSelection(String uniqueStr, int cs, int ts, int lc, String asf) {
    // base case
    if(cs > ts) { // when the current selected is greater than total selected letters
        System.out.println(asf);
        return;
    }

    /*
     * putting the boxes at levels
     * characters as options
     * to avoid permutations we have kept the variable last occured (lc)
     */
    
    for(int i = lc + 1; i < uniqueStr.length(); i++) { // traversing the unique string from the last location to avoid permutations of the same words
        
        char ch = uniqueStr.charAt(i); // getting the character at the current value
        
        generateSelection(uniqueStr, cs + 1, ts, i, asf + ch); // recursive call with increase in current selected characters and adding that to ans so far
    }
}