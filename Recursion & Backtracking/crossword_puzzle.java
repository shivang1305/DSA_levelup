/*
    DSA Level-Up - RECURSION & BACKTRACKING                                               Date: 15-Jan-2020

    Crossword Puzzle

1. You are given a 10*10 2-D array(arr) containing only '+' and '-' characters, which represents a 
    crossword puzzle. 
2. You are also given n number of words which need to be filled into the crossword.
3. Cells containing '-' are to be filled with the given words.
*/



public static void solution(char[][] arr, String[] words, int vidx) {
        // base case
        if(vidx == words.length) {
            print(arr);
            return;
        }
        
        String word = words[vidx];
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[0].length; j++) {
                if(arr[i][j] == '-' || arr[i][j] == word.charAt(0)) {
                    
                    // horizontal checks
                    if(canPlaceWordHorizontally(arr, word, i, j)) {
                        boolean[] wePlaced = placeWordHorizontally(arr, word, i, j);
                        solution(arr, words, vidx + 1);
                        unplaceWordHorizontally(arr, wePlaced, i, j); // backtracking undo
                    }
                    
                    // vertical checks
                    if(canPlaceWordVertically(arr, word, i, j)) {
                        boolean[] wePlaced = placeWordVertically(arr, word, i, j);
                        solution(arr, words, vidx + 1);
                        unplaceWordVertically(arr, wePlaced, i, j); // backtracking undo
                    }
                }
            }
        }

    }
    
    public static boolean canPlaceWordHorizontally(char[][] arr, String word, int i, int j) {
        // left side check
        if(j - 1 >= 0 && arr[i][j - 1] != '+') 
            return false;
        
        // right side check
        else if(j + word.length() < arr[0].length && arr[i][j + word.length()] != '+') 
            return false;
            
        // try to place the word 
        for(int jj = 0; jj < word.length(); jj++) {
            if(j + jj >= arr[0].length) // while placing the word check for the limit of the board
                return false;
            
            if(arr[i][j + jj] == '-' || arr[i][j + jj] == word.charAt(jj))
                continue;
            else
                return false;
        }
        
        return true;
    }
    
    public static boolean canPlaceWordVertically(char[][] arr, String word, int i, int j) {
        // up side check
        if(i - 1 >= 0 && arr[i - 1][j] != '+') 
            return false;
        
        // right side check
        else if(i + word.length() < arr.length && arr[i + word.length()][j] != '+') 
            return false;
            
        // try to place the word 
        for(int ii = 0; ii < word.length(); ii++) {
            if(i + ii >= arr.length) // while placing the word check for the limit of the board
                return false;
            
            if(arr[i + ii][j] == '-' || arr[i + ii][j] == word.charAt(ii))
                continue;
            else
                return false;
        }
        
        return true;
    }
    
    public static boolean[] placeWordHorizontally(char[][] arr, String word, int i, int j) {
        boolean[] wePlaced = new boolean[word.length()]; // checks for which words we placed and which were already placed at their position
        
        for(int jj = 0; jj < word.length(); jj++) {
            if(arr[i][j + jj] == '-') {
                arr[i][j + jj] = word.charAt(jj);
                wePlaced[jj] = true;
            }
        }
        
        return wePlaced;
    }
    
    public static boolean[] placeWordVertically(char[][] arr, String word, int i, int j) {
        boolean[] wePlaced = new boolean[word.length()]; // checks for which words we placed and which were already placed at their position
        
        for(int ii = 0; ii < word.length(); ii++) {
            if(arr[i + ii][j] == '-') {
                arr[i + ii][j] = word.charAt(ii);
                wePlaced[ii] = true;
            }
        }
        
        return wePlaced;
    }

    public static void unplaceWordHorizontally(char[][] arr, boolean[] wePlaced, int i, int j) {
       for(int jj = 0; jj < wePlaced.length; jj++) {
           if(wePlaced[jj] == true) // only unplace those words which we placed
               arr[i][j + jj] = '-';
       } 
    }
    
    public static void unplaceWordVertically(char[][] arr, boolean[] wePlaced, int i, int j) {
       for(int ii = 0; ii < wePlaced.length; ii++) {
           if(wePlaced[ii] == true) // only unplace those words which we placed
               arr[i + ii][j] = '-';
       } 
    }
