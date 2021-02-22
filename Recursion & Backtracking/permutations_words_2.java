/*
    DSA Level-Up - RECURSION & BACKTRACKING                                               Date: 06-Feb-2020

    Permutations of Words 2

1. You are given a word (may have one character repeat more than once).
2. You are required to generate and print all arrangements of these characters. 
*/  

public static void generateWords(int cc, String str, Character[] spots,
        HashMap < Character, Integer > lastOccurence) {
        // base case
        if(cc == str.length()) {
            for(int i = 0; i < spots.length; i++) // printing the spots array
                System.out.print(spots[i]);
            System.out.println();
            return;
        }
        
        /*
         * Character at levels
         * Boxes as options  
        */
        
        char ch = str.charAt(cc); // current character 
        
        int lastOcc = lastOccurence.get(ch); // last occurence in spots array of this character
        
        // since same characters should come after the previous one to avoid duplicacy, that's why loop is started from last occ + 1 
        for(int i = lastOcc + 1; i < spots.length; i++) {
            if(spots[i] == null) { // only if the current spot is null
                
                lastOccurence.put(ch, i); // change the last occurence for the currrent character
                
                spots[i] = ch; // putting the character at the specified spot
                
                generateWords(cc + 1, str, spots, lastOccurence); // recursive call
                
                spots[i] = null; // set the current spot again as null while backtracking
                
                lastOccurence.put(ch, lastOcc); // set the last occurence for current character as prev one
            }
        }
    }
