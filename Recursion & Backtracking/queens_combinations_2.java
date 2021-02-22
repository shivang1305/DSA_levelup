/*
    DSA Level-Up - RECURSION & BACKTRACKING                                               Date: 09-Feb-2020

    Queens Combination - 2

1. You are given a number n, representing the size of a n * n chess board.
2. You are required to calculate and print the combinations in which n queens can be placed on the 
   n * n chess-board. 
*/  

/**
 * queen at levels
 * boxes as options where to place and where not to place
 * to avoid duplicacy as the queens are same not distinct we are following the "after me" rule here.
 */

public static void queensCombinations(int qpsf, int tq, boolean[][] chess, int lr, int lc){
    // base case
    if(qpsf == tq) {
            
        for(int i = 0; i < chess.length; i++) { // printing the chess board
                
            for(int j = 0; j < chess[0].length; j++) {
                    
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
        
    
    
    for(int j = lc + 1; j < chess[0].length; j++) { // for the spots left in the same column
        
        if(chess[lr][j] == false) { // empty spot
            
            chess[lr][j] = true; // filling the spot
            
            queensCombinations(qpsf + 1, tq, chess, lr, j); // call
            
            chess[lr][j] = false; // unfill the spot
        }
    }
    
    for(int i = lr + 1; i < chess.length; i++) { // the spots left in the next rows
        
        for(int j = 0; j < chess[0].length; j++) {
            
            if(chess[i][j] == false) { // empty spot
                
                chess[i][j] = true; // filling the spot
                
                queensCombinations(qpsf + 1, tq, chess, i, j); // call
                
                chess[i][j] = false; // unfill the spot while backtracking
            }
        }
    }
}