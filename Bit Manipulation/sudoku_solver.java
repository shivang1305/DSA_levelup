/*
    DSA LEVELUP - Bit Manipulation                                              Date: 05-Mar-2021

1. You are give a partially filled 9*9 2-D array(arr) which represents an incomplete sudoku state.
2. You are required to assign the digits from 1 to 9 to the empty cells following some rules.
Rule 1 -> Digits from 1-9 must occur exactly once in each row.
Rule 2 -> Digits from 1-9 must occur exactly once in each column.
Rule 3 -> Digits from 1-9 must occur exactly once in each 3x3 sub-array of the given 2D array.

Assumption -> The given Sudoku puzzle will have a single unique solution.
Note -> You have to Solve this problem using bits.
*/

import java.util.*;

public class sudoku_solver {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int[][] arr = new int[9][9];
        int[] rows = new int[9];
        int[] cols = new int[9];
        int[][] grid = new int[3][3];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int digit = scn.nextInt();
                arr[i][j] = digit;
                rows[i] |= (1 << digit);
                cols[j] |= (1 << digit);
                grid[i / 3][j / 3] |= (1 << digit);
            }
        }

        scn.close();

        solveSudoku(arr, rows, cols, grid, 0, 0);
    }

    public static void display(int[][] arr){
        for (int ii = 0; ii < arr.length; ii++) {
          for (int jj = 0; jj < arr.length; jj++) {
            System.out.print(arr[ii][jj] + " ");
          }
          System.out.println();
        }
        System.out.println();
    }

    public static void solveSudoku(int[][] arr, int[] rows, int[] cols, int[][] grid, int i, int j) {
        if(i == arr.length) { // when the program reaches the end of sudoku board
            display(arr); // display the sudoku board
            return;
        }

        if(arr[i][j] > 0) // if the current visiting element of the sudoku board is non - zero
            solveSudoku(arr, rows, cols, grid, j == arr[0].length - 1 ? i+1 : i, j == arr[0].length-1 ? 0 : j+1); // call to the next element in the sudoku board
        
        else {
            for(int num = 1; num <= 9; num++) {
                if( (rows[i] & (1 << num)) == 0 && (cols[j] & (1 << num)) == 0 && (grid[i/3][j/3] & (1 << num)) == 0) {
                    
                    arr[i][j] = num; // place the number in sudoku 
                    rows[i] ^= (1 << num); // toggle the numth bit for rows 
                    cols[j] ^= (1 << num); // toggle the numth bit for cols 
                    grid[i/3][j/3] ^= (1 << num); // toggle the numth bit for grid 

                    solveSudoku(arr, rows, cols, grid, j == arr[0].length - 1 ? i+1 : i, j == arr[0].length-1 ? 0 : j+1); // recursive call to the next element
                    
                    // undo while backtracking
                    grid[i/3][j/3] ^= (1 << num); // toggle the numth bit for rows array
                    cols[j] ^= (1 << num); // toggle the numth bit for rows array
                    rows[i] ^= (1 << num); // toggle the numth bit for rows array
                    arr[i][j] = 0; // empty the space occupied on the sudoku board
                }
            }
        }
    }
}
