/*
    DSA LEVELUP - Bit Manipulation                                              Date: 02-Mar-2021

1. You are given a positive number N.
2. You have to find the minimum number of operations required to convert N into 1.
3. Operations allowed :
     (i)  If n is even, you have to replace n with n/2.
     (ii) If n is odd, you can replace n with either n-1 or n+1.
*/


import java.util.*;

public class reduce_n_to_1 {

    public static int solution(long n) {
        int res = 0;

        while(n > 0) {
            if(n % 2 == 0) // even number
                n = n / 2;
            
            else if(n == 3) { // special case for 3 as 3 is a number of nature 4x + 3 still it is advangeous to reduce the number in case of 3 only as we can also consider 3 as a base case for our trick 
                res = 2; // fixed ans for 3 always
                break;
            }    
            
            // (n % 4) is equivalent to (n & 3) 

            else if((n & 3) == 1) // number of nature 4x + 1
                n = n - 1;
            
            else if((n & 3) == 3) // number of nature 4x + 3
                n = n + 1;

            res++; // number of operations are increasing in each iteration
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        scn.close();

        System.out.println(solution(n));
    }
}