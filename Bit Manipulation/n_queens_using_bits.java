/*
    DSA LEVELUP - Bit Manipulation                                              Date: 07-Mar-2021

1. You are given a number n, the size of a chess board.
2. You are required to place n number of queens in the n * n cells of board such that no queen can kill another.
Note - Queens kill at distance in all 8 directions
3. Complete the body of printNQueens function - without changing signature - to calculate and print all safe configurations of n-queens
Use sample input and output to get more idea.

Note -> Write recursive and not iterative logic. The purpose of the question is to aid learning recursion, branch and bound technique, bit manipulation and not test you.
*/

// using branch and bound algorithm with bits instead of using arrays

import java.util.*;

public class n_queens_using_bits {
    public static void solution(boolean[][] board, int row, int cols, int daig, int rdaig, String asf) {

        if(row == board.length) {
            System.out.println(asf);
            return;
        }

        for(int i = 0; i < board[0].length; i++) { // loop in columns
            
            if(board[row][i] == false && (cols & (1 << i)) == 0 && (daig & (1 << (row + i))) == 0 && (rdaig & (1 << (row - i + board.length - 1))) == 0) {

                board[row][i] = true;
                cols ^= (1 << i);
                daig ^= (1 << (row + i));
                rdaig ^= (1 << (row - i + board.length - 1));

                solution(board, row + 1, cols, daig, rdaig, asf + row + "-" + i + ", ");

                // undo while backtracking
                board[row][i] = false;
                cols ^= (1 << i); // toggling the bits
                daig ^= (1 << (row + i));
                rdaig ^= (1 << (row - i + board.length - 1));

            }
            
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        scn.close();
        boolean[][] board = new boolean[n][n];
        int cols = 0;
        int ndiag = 0;
        int rdiag = 0;
        solution(board, 0, cols, ndiag, rdiag, "");
    }
}