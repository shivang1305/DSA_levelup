import java.util.*;

public class kadanes_algorithm {

   public static int maximumSum(int[] arr) {
      int currSum = arr[0];
      int overallSum = arr[0];

      for(int i = 1; i < arr.length; i++) {
         if(currSum > 0) 
            currSum += arr[i];
         else 
            currSum = arr[i];
      }

      if(currSum > overallSum)
         overallSum = currSum;

      return overallSum;
   }

   public static void main(String args[] ) throws Exception {
      Scanner scn = new Scanner(System.in);
      int n = scn.nextInt();

      int[] arr = new int[n];
      for(int i = 0; i < n; i++)
         arr[i] = scn.nextInt();

      scn.close();

      System.out.println(maximumSum(arr));

   }
}