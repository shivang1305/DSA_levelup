/*
    DSA Level-Up - RECURSION & BACKTRACKING                                               Date: 09-Feb-2020

    Queens Combination - 3

1. You are given a number n, representing the size of a n * n chess board.
2. You are required to calculate and print the combinations in which n queens can be placed on the 
   n * n chess-board. 
*/  

/**
 * queen at levels
 * boxes as options where to place and where not to place
 * to avoid duplicacy as the queens are same not distinct we are following the "after me" rule here.
 */



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
        
        chess[row][col] = true; // marking the spot
        
        queensCombinations(qpsf + 1, tq, chess, i); // call
        
        chess[row][col] = false; // unmarking the spot
    }
}