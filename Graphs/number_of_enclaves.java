
class number_of_enclaves {

  public static int numEnclaves(int[][] arr) {
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[0].length; j++) {
                if(i == 0 || j == 0 || i == arr.length - 1 || j == arr[0].length - 1)
                    dfs(arr, i, j);
            }
        }
        
        int count = 0;
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[0].length; j++) {
                if(arr[i][j] == 1)
                    count++;
            }
        }
        
        return count;
  }
  
  public static void dfs(int[][] arr, int i, int j) {
      // boundary check
      if(i < 0 || j < 0 || i >= arr.length || j >= arr[0].length || arr[i][j] == 0)
        return;
        
      arr[i][j] = 0;
      
      dfs(arr, i + 1, j);
      dfs(arr, i - 1, j);
      dfs(arr, i, j + 1);
      dfs(arr, i, j - 1);
  }

}