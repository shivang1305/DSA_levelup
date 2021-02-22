/*
    DSA Level-Up - RECURSION & BACKTRACKING                                               Date: 04-Jan-2020

    Sudoku Solver (Leetcode - Medium)

Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.

Note: A Sudoku board (partially filled) could be valid but is not necessarily solvable.
Only the filled cells need to be validated according to the mentioned rules.

[["5","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]
Output: true
*/


class Solution {
public:
    bool isValidCell(vector<vector<char>>& board, int x, int y, int val) {
        // check in the same row
        for(int j = 0; j < board[0].size(); j++) {
            if(j != y && board[x][j] == val) // except for the passed row number
                return false;
        }
        
        // check in the same column
        for(int i = 0; i < board.size(); i++) {
            if(i != x && board[i][y] == val) // except for the passed column number
                return false;
        }
        
        // check in the same submatrix
        // to get the starting or the first cell indices of the submatrix
        int si = (x / 3) * 3;
        int sj = (y / 3) * 3;
        for(int  i = 0; i < 3; i++) {
            for(int  j = 0; j < 3; j++) {
                if(si + i == x && sj + j == y) // for the passed position
                    continue;
                if(board[si + i][sj + j] == val)
                    return false;
            }
        }
        
        return true; // if neither of the above conditions met true, then only compiler will reach here
    }
    
    bool isValidSudoku(vector<vector<char>>& board) {
        for(int i = 0; i < board.size(); i++) {
            for(int j = 0; j < board[0].size(); j++) {
                if(board[i][j] != '.') {
                    bool isValid = isValidCell(board, i, j, board[i][j]);
                    if(isValid == false)
                        return false;
                }
            }
        }
        return true;
    }
};