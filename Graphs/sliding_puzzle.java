// Leetcode Hard (Que. 773) Sliding Puzzle


import java.io.*;
import java.util.*;

public class sliding_puzzle {
  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int[][] arr = new int[2][3];

    for (int i = 0; i < 2; i++) {
      String[] st = br.readLine().split(" ");
      for (int j = 0; j < 3; j++) {
        arr[i][j] = Integer.parseInt(st[j]);
      }
    }

    System.out.println(slidingPuzzle(arr));
  }

    // this function returns that index on which zero is present
    private static int getZeroIndex(String str) {
        int zeroIdx = -1;
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '0') {
                zeroIdx = i;
                break;
            }
        }
        return zeroIdx;
    }
    
    // this function swaps the passed indices of the string
    private static String swapStringIndices(String str, int i, int j) {
        StringBuilder sb = new StringBuilder(str);
        sb.setCharAt(j, str.charAt(i));
        sb.setCharAt(i, str.charAt(j));
        
        return sb.toString();
    }
    
    public static int slidingPuzzle(int[][] board) {
        String target = "123450"; // final target
        String initial = ""; 
        
        // here we converted integer matrix to string so that we can store it in the queue
        // as we can't store matrix in the queue as it will be stored as address not value and we can compare on addresses while traversing each level in the queue.
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) 
                initial += board[i][j]; // initial string 
        }
        
        // this array tells that ith index can be swapped with which indices (in the matrix)
        // since we converted matrix into string therefore we need to create this array specially
        int[][] swaps = {{1, 3}, {0, 2, 4}, {1, 5}, {0, 4}, {1, 3, 5}, {2, 4}};
        
        Queue<String> que = new ArrayDeque<>();
        que.add(initial);
        
        int numSwaps = 0;
        // so that we can keep a track that how many strings are already created to avoid repeatitions
        HashSet<String> visited = new HashSet<>(); 
        
        while(!que.isEmpty()) {
            int size = que.size();
            
            while(size-- > 0) {
                String rem = que.remove();
                if(rem.equals(target))
                    return numSwaps;
                
                int zeroIdx = getZeroIndex(rem);
                
                for(int swapIdx : swaps[zeroIdx]) {
                    String swappedStr = swapStringIndices(rem, zeroIdx, swapIdx);
                    
                    if(!visited.contains(swappedStr)) {
                        visited.add(swappedStr);
                        que.add(swappedStr);
                    }
                }
            }
            numSwaps++;
        }
        return -1;
    }
}
