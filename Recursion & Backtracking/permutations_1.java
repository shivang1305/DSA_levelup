/*
    DSA Level-Up - RECURSION & BACKTRACKING                                               Date: 31-Jan-2020

    Permutations - 1

1. You are give a number of boxes (nboxes) and number of non-identical items (ritems).
2. You are required to place the items in those boxes and print all such configurations possible.

Items are numbered from 1 to ritems.
Note -> Number of boxes is greater than number of items, hence some of the boxes may remain empty.

*/
    
    public static void permutations(int[] boxes, int ci, int ti) {
        // base case
        if(ci > ti) {
            for(int i = 0; i < boxes.length; i++) 
                System.out.print(boxes[i]);
            
            System.out.println();
            return;
        }

        // here we keep items at levels and boxes as options at each level
        
        for(int i = 0; i < boxes.length; i++) {
            if(boxes[i] == 0) { // check if the box is empty
            
                boxes[i] = ci; // put the current item in the box
                
                permutations(boxes, ci + 1, ti); // call to the next level and increase the current item
                
                boxes[i] = 0; // undo the action while backtracking
            }
        }
    }