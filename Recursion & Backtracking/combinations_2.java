/*
    DSA Level-Up - RECURSION & BACKTRACKING                                               Date: 02-Feb-2020

    Combinations - 2

1. You are give a number of boxes (nboxes) and number of identical items (ritems).
2. You are required to place the items in those boxes and print all such configurations possible.

Items are identical and all of them are named 'i'
Note -> Number of boxes is greater than number of items, hence some of the boxes may remain 
          empty.

*/  

// COMBINATIONS WITH THE PERMUTATION METHOD

public static void combinations(int[] boxes, int ci, int ti, int lb) {
    // base case
    if(ci > ti) {
        for(int i = 0; i < boxes.length; i++) {
            if(boxes[i] == 0)
                System.out.print("-");
            else
                System.out.print("i");
        }
        System.out.println();
        return;
    }
    
    for(int b = lb + 1; b < boxes.length; b++) {
        if(boxes[b] == 0) { // check if the box is empty or not
            boxes[b] = 1; // fill the current box
            
            combinations(boxes, ci + 1, ti, b); // recursive call to the function
            
            boxes[b] = 0; // undo the action while backtracking i.e. empty the current box again
        }
    }
}