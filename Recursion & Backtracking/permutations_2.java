/*
    DSA Level-Up - RECURSION & BACKTRACKING                                               Date: 01-Feb-2020

    Permutations - 2

1. You are give a number of boxes (nboxes) and number of non-identical items (ritems).
2. You are required to place the items in those boxes and print all such configurations possible.

Items are numbered from 1 to ritems.
Note -> Number of boxes is greater than number of items, hence some of the boxes may remain 
          empty.

*/    
    
    // PERMUTATIONS WITH THE COMBINATION METHOD
    
    public static void permutations(int cb, int tb, int[] items, int ssf, int ts, String asf) {
        //base case
        if(cb > tb) {
            if(ssf == ts) 
                System.out.println(asf);
            return;
        }
        
        // items array is used to check that weather the current item is used or not
        // 0 -> item not used
        // 1 -> item is used
        
        for(int i = 0; i < items.length; i++) {
            if(items[i] == 0) { // check if the item is used or not
                
                items[i] = 1; // mark the current item as used
                
                permutations(cb + 1, tb, items, ssf + 1, ts, asf + (i + 1));
                
                items[i] = 0; // undo the action while backtracking
            }            
        }
        permutations(cb + 1, tb, items, ssf, ts, asf + 0); // no ki call
    }