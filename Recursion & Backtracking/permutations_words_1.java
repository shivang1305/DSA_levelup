/*
    DSA Level-Up - RECURSION & BACKTRACKING                                               Date: 06-Feb-2020

    Permutations of Words 1

1. You are given a word (may have one character repeat more than once).
2. You are required to generate and print all arrangements of these characters. 
*/  

public static void generateWords(int cs, int ts, HashMap < Character, Integer > fmap, String asf) {
    // base case
    if(cs > ts) { // when current spot is greater than total spots
        System.out.println(asf);
        return;
    }
    
    for(char ch : fmap.keySet()) { // taking out each character from the frequency map hashmap
        
        int currFreq = fmap.get(ch); // getting the current freq of each character
        
        if(currFreq > 0) { // checking for characters which can be used i.e. whose current frequency is greater than 0
            
            fmap.put(ch, currFreq - 1);  // decresing the freq of the char
            
            generateWords(cs + 1, ts, fmap, asf + ch); // recursive call
            
            fmap.put(ch, currFreq); // setting up the same frequency again (backtracking)
        }
    }
}

