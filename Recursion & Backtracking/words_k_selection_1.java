/*
    DSA Level-Up - RECURSION & BACKTRACKING                                               Date: 08-Feb-2020

    Words K Selection - 1

1. You are given a word (may have one character repeat more than once).
2. You are given an integer k.
2. You are required to generate and print all ways you can select k distinct characters out of the 
   word.
*/  



public static void generateSelection(int i, String uniqueStr, int ssf, int ts, String asf) {
    // base case
    if(i == uniqueStr.length()) {
        if(ssf == ts) // when selected so far equals to total selected
            System.out.println(asf);
        return;
    }

    /*
    * taking all the letters of given question string into the hashmap so that we can get a unique string 
    * putting each letter of unique string at the levels and taking yes and no as options to select the     letter or not.
    */
    
    char ch = uniqueStr.charAt(i); // obtaining the character at current level 
    generateSelection(i + 1, uniqueStr, ssf + 1, ts, asf + ch); // yes ki call
    generateSelection(i + 1, uniqueStr, ssf, ts, asf); // no ki call
}