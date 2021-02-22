/*
    DSA Level-Up - RECURSION & BACKTRACKING                                               Date: 31-Jan-2020

    Combinations - 1

1. You are give a number of boxes (nboxes) and number of identical items (ritems).
2. You are required to place the items in those boxes and print all such configurations possible.

Items are identical and all of them are named 'i'.
Note -> Number of boxes is greater than number of items, hence some of the boxes may remain 

*/

public static void combinations(int cb, int tb, int ssf, int ts, String asf) {
    // base case
    if(cb > tb) {
        if(ssf == ts)  // when selected items so far is equal to total selected items
            System.out.println(asf);
        return;
    }
    
    // here unlike permutations we keep the boxes at levels and yes and no as options
    
    combinations(cb + 1, tb, ssf + 1, ts, asf + "i"); // yes ki call
    
    combinations(cb + 1, tb, ssf, ts, asf + "-"); // no ki call
}