/*
    DSA Level-Up - RECURSION & BACKTRACKING                                               Date: 13-Jan-2020

    Gold Mine 2

1. You are given a number n, representing the number of rows.
2. You are given a number m, representing the number of columns.
3. You are given n*m numbers, representing elements of 2d array a, which represents a gold mine.
4. You are allowed to take one step left, right, up or down from your current position.
5. You can't visit a cell with 0 gold and the same cell more than once. 
6. Each cell has a value that is the amount of gold available in the cell.
7. You are required to identify the maximum amount of gold that can be dug out from the mine if 
   you start and stop collecting gold from any position in the grid that has some gold.
*/
    
    
    static int maxGold = 0;
    
    public static void getMaxGold(int[][] arr) {
        boolean[][] visited = new boolean[arr.length][arr[0].length];
        
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[0].length; j++) {
                if(arr[i][j] != 0 && visited[i][j] == false) // every unvisited and non-zero cell starts a path
                    maxGold = Math.max(maxGold, sumOfGoldMine(arr, i, j, visited, 0));
                
            }
        }
    }
    
    public static int sumOfGoldMine(int[][] arr, int i, int j, boolean[][] visited, int sum) {
        // base case
        if(i < 0 || j < 0 || i >= arr.length || j >= arr[0].length || visited[i][j] == true || arr[i][j] == 0)
            return 0;
            
        visited[i][j] = true; // marking the cell visited
        
        int sumNorth = sumOfGoldMine(arr, i - 1, j, visited, sum); // top
        int sumEast = sumOfGoldMine(arr, i, j + 1, visited, sum); // right
        int sumSouth = sumOfGoldMine(arr, i + 1, j, visited, sum); // down
        int sumWest = sumOfGoldMine(arr, i, j - 1, visited, sum); // left
        
        sum += arr[i][j]; // collecting the gold at the current cell
        
        int totalSum = sumNorth + sumEast + sumSouth + sumWest + sum; // getting the total gold from all directions
        
        return totalSum;
    }