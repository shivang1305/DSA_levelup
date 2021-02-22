/*
    DSA Level-Up - RECURSION & BACKTRACKING                                               Date: 10-Feb-2020

    Queens Permutations - 3

1. You are given a number n, representing the size of a n * n chess board.
2. You are required to calculate and print the permutations in which n queens (distinct) can be 
     placed on the n * n chess-board. 
3. No queen shall be able to kill another.
*/  

/**
 * queen at levels
 * boxes as options where to place and where not to place
 */


public static boolean isQueenSafe(int[][] chess, int row, int col) {
    // checking horizontally
    for(int j = 0; j < chess.length; j++) {
        if(chess[row][j] != 0)
            return false;
    }
    
    // checking vertically
    for(int i = 0; i < chess.length; i++) {
        if(chess[i][col] != 0)
            return false;
    }
    
    // checking left daigonal (upwards)
    for(int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
        if(chess[i][j] != 0)
            return false;
    }
    
    // checking left daigonal (downwards)
    for(int i = row, j = col; i < chess.length && j < chess.length; i++, j++) {
        if(chess[i][j] != 0)
            return false;
    }
    
    // checking the right daigonal (upwards)
    for(int i = row, j = col; i >= 0 && j < chess.length; i--, j++) {
        if(chess[i][j] != 0)
            return false;
    }
    
    // checking the right daigonal (downwards)
    for(int i = row, j = col; i < chess.length && j >= 0; i++, j--) {
        if(chess[i][j] != 0)
            return false;
    }
    
    return true; // if none of the above specified condition is true
}

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
    
    for(int i = 0; i < chess.length * chess.length; i++) { // traversing the chess board (options)
        
        int row = i / chess.length;
        int col = i % chess.length;
            
        if(chess[row][col] == 0 && isQueenSafe(chess, row, col)) { // is the spot is empty
                
            chess[row][col] = qpsf + 1; // placing the queen at the current spot
                
            queensPermutations(qpsf + 1, tq, chess); // recursive call (increasing the queen placed so far at each call)
                
            chess[row][col] = 0; // unplacing the queen (undo while backtracking)
        }
        
    }
}