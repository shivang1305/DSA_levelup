/*
    DSA Level-Up - RECURSION & BACKTRACKING                                               Date: 09-Feb-2020

    Queens Combination - 1

1. You are given a number n, representing the size of a n * n chess board.
2. You are required to calculate and print the combinations in which n queens can be placed on the 
   n * n chess-board. 
*/  

/**
 * box at levels
 * yes and no as options to place or not to place the queen
 */

public static void queensCombinations(int qpsf, int tq, int row, int col, String asf){
    // base case
    if(row == tq) { // when we reach the end of the matrix
        if(qpsf == tq)
            System.out.println(asf);
        return;
    }
    
    int nr = 0, nc = 0; // new row and column
    String yasf = "", nasf = ""; // for yes and no call
    
    if(col == tq - 1) { // when we reach at the end of one row in the 2d matrix
        nr = row + 1; // we move to next row
        nc = 0; // in the starting of the column
        
        yasf = asf + "q\n"; // yes call string
        nasf = asf + "-\n"; // no call string
    }else {
        nr = row; // row remains same
        nc = col + 1; // column increases to move ahead in the same row
        
        yasf = asf + "q"; // yes call string
        nasf = asf + "-"; // no call string
    }
    
    queensCombinations(qpsf + 1, tq, nr, nc, yasf); // yes call (queen placed so far increases)
    
    queensCombinations(qpsf, tq, nr, nc, nasf); // no call
}