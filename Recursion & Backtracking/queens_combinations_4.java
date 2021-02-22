/*
    DSA Level-Up - RECURSION & BACKTRACKING                                               Date: 10-Feb-2020

    Queens Combination - 4

1. You are given a number n, representing the size of a n * n chess board.
2. You are required to calculate and print the combinations in which n queens can be placed on the 
   n * n chess-board. 
3. No queen shall be able to kill another.
*/  

/**
 * queen at levels
 * boxes as options where to place and where not to place
 * to avoid duplicacy as the queens are same not distinct we are following the "after me" rule here.
 */

public static boolean IsQueenSafe(boolean[][] chess, int row, int col) {
    // checking horizontally
    for(int j = col; j >= 0; j--) {
        if(chess[row][j])
            return false;
    }
    
    // checking vertically
    for(int i = row; i >= 0; i--) {
        if(chess[i][col])
            return false;
    }
    
    // checking left daigonal
    for(int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
        if(chess[i][j])
            return false;
    }
    
    // checking the right daigonal
    for(int i = row, j = col; i >= 0 && j < chess.length; i--, j++) {
        if(chess[i][j])
            return false;
    }
    
    return true; // if none of the above specified condition is true
}

public static void queensCombinations(int qpsf, int tq, boolean[][] chess, int lcno) {
    // base case
    if(qpsf == tq) {
        
        for(int i = 0; i < chess.length; i++) {
            
            for(int j = 0; j < chess.length; j++) {
                
                if(chess[i][j] == true)
                    System.out.print("q\t");
                
                else
                    System.out.print("-\t");
            }
            System.out.println();
        }
        System.out.println();
        
        return;
    }

    /**
     * assigning a continuous number to the boxes 
     * cellno = rno * size + col (2d to 1d)
     * rno = cellno / size
     * cno = cellno % size
     */
    
    for(int i = lcno + 1; i < chess.length * chess.length; i++) { // converting from 2d to 1d
        
        // obtaining the row and col number from i
        int row = i / chess.length; 
        int col = i % chess.length;
        
        if(isQueenSafe(chess, row, col)) {
            chess[row][col] = true; // marking the spot
        
            queensCombinations(qpsf + 1, tq, chess, i); // call
            
            chess[row][col] = false; // unmarking the spot
        }
        
    }
}