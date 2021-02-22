/*
    DSA Level-Up - RECURSION & BACKTRACKING                                               Date: 04-Jan-2020

    Sudoku Solver (Leetcode - Hard)

Write a program to solve a Sudoku puzzle by filling the empty cells.

A sudoku solution must satisfy all of the following rules:

1. Each of the digits 1-9 must occur exactly once in each row.
2. Each of the digits 1-9 must occur exactly once in each column.
3. Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.

The '.' character indicates empty cells.

Input: board = [["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]]
Output: [["5","3","4","6","7","8","9","1","2"],["6","7","2","1","9","5","3","4","8"],["1","9","8","3","4","2","5","6","7"],["8","5","9","7","6","1","4","2","3"],["4","2","6","8","5","3","7","9","1"],["7","1","3","9","2","4","8","5","6"],["9","6","1","5","3","7","2","8","4"],["2","8","7","4","1","9","6","3","5"],["3","4","5","2","8","6","1","7","9"]]
*/

class Solution {
public:
    int flag = 0; 
    void solveSudokuCell(vector<vector<char>>& board, int i, int j) {
        // base condition
        if(i == board.size()) {
            flag = 1;
            return; 
        }
        
        int ni = 0, nj = 0; // next indices
    
        if(j == board[0].size() - 1) { // changing the row after completing one
            ni = i + 1; // new row
            nj = 0; // first column
        }
        else { // moving forward in the same row
            ni = i; // same row
            nj = j + 1; // next column
        }
        
        if(board[i][j] != '.') // for an already filled cell
            solveSudokuCell(board, ni, nj); // call to the next cell in sudoku matrix
        
        else { // for an emty cell in sudoku 
            for(int op = 49; op <= 57; op++) {
                if(isValidOption(board, i, j, op) == true) { // when the given option is valid
                    board[i][j] = op; // fill the cell with the valid option

                    solveSudokuCell(board, ni, nj); // call to the next cell
                    
                    if(flag != 1) // this prevents undoing the filled cells when returning after completely solving the sudoku board
                        board[i][j] = '.'; // undo the option while backtracking
                }
            }
        } 
    }
    
    bool isValidOption(vector<vector<char>>& board, int x, int y, int val) {
        // check in the same row
        for(int j = 0; j < board[0].size(); j++) {
            if(board[x][j] == val)
                return false;
        }
        
        // check in the same column
        for(int i = 0; i < board.size(); i++) {
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
    
    void solveSudoku(vector<vector<char>>& board) {
        solveSudokuCell(board, 0, 0);
    }
};