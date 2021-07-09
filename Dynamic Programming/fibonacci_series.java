import java.util.*;

public class fibonacci_series {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n  = scn.nextInt();
        scn.close();

        System.out.println(fiboRecursive(n));
    }

    public static int fiboRecursive(int n) {
        if(n <= 1) // base condition fibonacci series for no.s less than 1 is the number itself
            return n;

        int ans = fiboRecursive(n - 1) + fiboRecursive(n - 2); // depends on the last 2 number in the fibonacci series

        return ans;
    }

    // same as recursive solution just question bank array is passed here as dp to store the ans of the recursion
    public static int fiboMemoization(int n, int[] dp) {
        if(n <= 1)
            return dp[n] = n;
        
        if(dp[n] != 0)
            return dp[n];

        int ans = fiboMemoization(n - 1, dp) + fiboMemoization(n - 2, dp);

        return dp[n] = ans;
    }

    public static int fiboTabulation(int n, int[] dp) {
        // intialization of the matrix same as base condition of the recursive solution
        dp[0] = 0;
        dp[1] = 1;

        for(int i = 2; i < n; i++) // filling of the matrix by choice daigram
            dp[i] = dp[i - 1] + dp[i - 2];

        return dp[n];
    }

    // most optimized approach as it uses const space because it does not use additonal matrix 
    public static int fiboOptimized(int n) {
        if(n <= 1)
            return n;
        int a = 0, b = 1, sum = 0;

        for(int i = 2; i <= n; i++)  {
            sum = a + b;
            a = b;                          
            b = sum;
        }
        return sum;
    }
}