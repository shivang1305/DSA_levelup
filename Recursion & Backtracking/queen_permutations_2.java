/*
    DSA Level-Up - RECURSION & BACKTRACKING                                               Date: 09-Feb-2020

    Queens Permutations - 2

1. You are given a number n, representing the size of a n * n chess board.
2. You are required to calculate and print the permutations in which n queens can be placed on the 
   n * n chess-board. 

*/  

/**
 * boxes at levels 
 * queens as options
 */

public static void queensPermutations(int qpsf, int tq, int row, int col, String asf, boolean[] queens) {
    // base case
    if(row == tq) { // when we reaches the end of the board 
        
        if(qpsf == tq) { // when queens placed so far becomes equal to the total queens
            System.out.println(asf);
            System.out.println();
        }
        
        return;
    }
    
    int nr = 0, nc = 0;
    String sep = ""; // seperator
    
    if(col == tq - 1) { // when we reach in the end of the row
        
        nr = row + 1; // row changes
        
        nc = 0; // column is started again from zero
        
        sep = "\n";
    } else { // in same row
        
        nr = row; // row remains the same
        
        nc = col + 1; // column is increased every time to traverse in the same row
        
        sep = "\t";
    }
    
    for(int i = 0; i < queens.length; i++) { // traversing through the queens (options)
        
        if(queens[i] == false) { // only for unused queens
            
            queens[i] = true; // mark the queens as used (pre)
            
            queensPermutations(qpsf + 1, tq, nr, nc, asf + "q" + (i + 1) + sep, queens); // recursive call (increase the queens placed so far in each call)
            
            queens[i] = false; // unmark the queen as unused again while backtracking
        }
    }
    
    queensPermutations(qpsf, tq, nr, nc, asf + "-" + sep, queens); // no ki call (qpsf is not increased this time)
}