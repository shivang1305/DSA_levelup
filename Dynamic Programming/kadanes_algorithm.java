import java.util.*;

public class kadanes_algorithm {

   public static int maximumSum(int[] arr) {
      int currSum = arr[0]; // puts the first element of the given array in both
      int overallSum = arr[0];

      for(int i = 1; i < arr.length; i++) {
         if(currSum >= 0) // check for positive value of currSum
            currSum += arr[i]; // add the next element of the array in the currSum
         else // if the value of currSum is negative
            currSum = arr[i]; // drop the value and start the currSum with the new value

         overallSum = Math.max(overallSum, currSum); // obtain the overall sum
      }

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