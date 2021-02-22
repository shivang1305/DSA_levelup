/*
    DSA Level-Up - RECURSION & BACKTRACKING                                               Date: 04-Jan-2020

1. You are give a partially filled 9*9 2-D array(arr) which represents an incomplete sudoku state.
2. You are required to assign the digits from 1 to 9 to the empty cells following some rules.
Rule 1 -> Digits from 1-9 must occur exactly once in each row.
Rule 2 -> Digits from 1-9 must occur exactly once in each column.
Rule 3 -> Digits from 1-9 must occur exactly once in each 3x3 sub-array of the given 2D array.
*/


// import java.io.*;
import java.util.*;

public class Main {
  public static void display(int[][] board){
    for(int i = 0; i < board.length; i++){
      for(int j = 0; j < board[0].length; j++){
        System.out.print(board[i][j] + " ");
      }
      System.out.println();
    }
  }

  public static void solveSudoku(int[][] board, int i, int j) {
    // base case
    if(i == board.length) {
        display(board);
        return;
    }
    
    int ni = 0, nj = 0; // next indices
    
    if(j == board[0].length - 1) { // changing the row after completing one
        ni = i + 1; // new row
        nj = 0; // first column
    }
    else { // moving forward in the same row
        ni = i; // same row
        nj = j + 1; // next column
    }
    
    if(board[i][j] != 0) // for an already filled cell
        solveSudoku(board, ni, nj); // call to the next cell in sudoku matrix
    
    else { // for an emty cell in sudoku 
        for(int op = 1; op <= 9; op++) {
            if(isValidOption(board, i, j, op) == true) { // when the given option is valid
                board[i][j] = op; // fill the cell with the valid option
                
                solveSudoku(board, ni, nj); // call to the next cell
                
                board[i][j] = 0; // undo the option while backtracking
            }
        }
    }
  }
  
  public static boolean isValidOption(int[][] board, int x, int y, int val) {
      // check in the same row
      for(int j = 0; j < board[0].length; j++) {
          if(board[x][j] == val)
            return false;
      }
      
      // check in the same column
      for(int i = 0; i < board.length; i++) {
          if(board[i][y] == val)
            return false;
      }
      
      // check in the same submatrix
      
      // to get the starting or the first cell indices of the submatrix
      int si = (x / 3) * 3;
      int sj = (y / 3) * 3;
      for(int  i = 0; i < 3; i++) {
          for(int  j = 0; j < 3; j++) {
              if(board[si + i][sj + j] == val)
                return false;
          }
      }
      
      return true; // if neither of the above conditions met true, then only compiler will reach here
  }

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int[][] arr = new int[9][9];
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        arr[i][j] = scn.nextInt();
      }
    }

    solveSudoku(arr, 0, 0);
  }
}
