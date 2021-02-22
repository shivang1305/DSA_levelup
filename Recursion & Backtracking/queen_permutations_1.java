/*
    DSA Level-Up - RECURSION & BACKTRACKING                                               Date: 09-Feb-2020

    Queens Permutations - 1

1. You are given a number n, representing the size of a n * n chess board.
2. You are required to calculate and print the permutations in which n queens can be placed on the 
   n * n chess-board. 

*/  

/**
 * queens at levels 
 * boxes as options
 */


public static void queensPermutations(int qpsf, int tq, int[][] chess){
    // base case
    if(qpsf == tq) { // when queen placed so far equals to the total number of queens
        
        for(int i = 0; i < chess.length; i++) {
            
            for(int j = 0; j < chess[0].length; j++) {
                
                if(chess[i][j] == 0) 
                    System.out.print("-\t");
                else
                    System.out.print("q" + chess[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
        
        return;
    }
    
    for(int i = 0; i < chess.length; i++) { // traversing the chess board (options)
        
        for(int  j = 0; j < chess[0].length; j++) {
            
            if(chess[i][j] == 0) { // is the spot is empty
                
                chess[i][j] = qpsf + 1; // placing the queen at the current spot
                
                queensPermutations(qpsf + 1, tq, chess); // recursive call (increasing the queen placed so far at each call)
                
                chess[i][j] = 0; // unplacing the queen (undo while backtracking)
            }
        } 
    }
}