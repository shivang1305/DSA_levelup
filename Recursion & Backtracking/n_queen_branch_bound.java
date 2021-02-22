/*
    DSA Level-Up - RECURSION & BACKTRACKING                                               Date: 10-Jan-2020

    N Queens using Branch and Bound Technique

1. You are given a number n, the size of a chess board.
2. You are required to place n number of queens in the n * n cells of board such that no queen can 
     kill another.
Note - Queens kill at distance in all 8 directions
3. Complete the body of printNQueens function - without changing signature - to calculate and 
     print all safe configurations of n-queens

Use sample input and output to get more idea.

Note -> The online judge can't force you to write the function recursively but that is what the spirit 
               of question is.

*/


public static void nQueens(boolean[][] board, int row, boolean[] cols, boolean[] daig, boolean[] rdaig, String asf) {
    // base case
    if (row == board.length) {
        System.out.println(asf + ".");
        return;
    }

    for (int col = 0; col < board[0].length; col++) {

        if (cols[col] == false && daig[row + col] == false && rdaig[row - col + board.length - 1] == false) {
            board[row][col] = true;
            cols[col] = true;
            daig[row + col] = true;
            rdaig[row - col + board.length - 1] = true;

            nQueens(board, row + 1, cols, daig, rdaig, asf + row + "-" + col + ", ");

            // backtracking undo
            board[row][col] = false;
            cols[col] = false;
            daig[row + col] = false;
            rdaig[row - col + board.length - 1] = false;
        }
    }
}