/*
    DSA Level-Up - RECURSION & BACKTRACKING                                               Date: 08-Feb-2020

    K Length Words - 1

1. You are given a word (may have one character repeat more than once).
2. You are given an integer k.
3. You are required to generate and print all k length words (of distinct chars) by using chars of the 
   word.
*/  



public static void generateWords(int cc, String ustr, int ssf, int ts, Character[] spots) {
    // base case
    if(cc == ustr.length()) { // when we reach the end of the unique string
        
        if(ssf == ts) { // when selected so far equals to the total selected
            
            for(int i = 0; i < spots.length; i++) // printing the answer
                System.out.print(spots[i]);
            System.out.println();
        }
        return;
    }

    /**
     * taking characters at levels
     * and slots or boxes as options 
     * options par hmesha loop lgega or levels pr hmesha call lgegi 
     * jisko bhi levels pr rkhenge wo parameter ya usse related parameter function me zarur pass hoga
     */
    
    char ch = ustr.charAt(cc); // obtaining the character at current level (levels)
    
    for(int i = 0; i < spots.length; i++) { // traversing the spots array (options)
        
        if(spots[i] == null) { // place the character at that spot which is empty
            
            spots[i] = ch; // placing the character
            
            generateWords(cc + 1, ustr, ssf + 1, ts, spots); // recursive call (increasing selected so far and current spot)
            
            spots[i] = null; // setting the spot again to null (undo while backtracking)
        }
    }
    
    generateWords(cc + 1, ustr, ssf, ts, spots); // no ki call
}