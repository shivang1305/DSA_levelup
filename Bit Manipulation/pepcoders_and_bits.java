/*
    DSA LEVELUP - Bit Manipulation                                              Date: 04-Mar-2021

1. Pepcoder is feeling confident after solving many problems on Bit Manipulation.
2. So, his teacher ask him to find out the count of positive integers strictly less than N, having same number of set bits as that of N.
3. Let us see that if pepcoder can solve it or not.
*/

import java.util.*;

public class pepcoders_and_bits {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        long n = scn.nextLong();
        scn.close();

        int k = countSetBits(n);

        System.out.println(solution(n, k, 63));
    }

    public static int countSetBits(long n) {
        int res = 0;

        while(n > 0) {
            long rsb = n & -n;
            n -= rsb;
            res++;
        }

        return res;
    }

    public static long solution(long n, int k, int i) {
        if(i == 0)
            return 0;

        long res = 0;

        long mask = 1L << i;

        if((mask & n) == 0) { // first bit is off
            res = solution(n, k, i-1);
        }
        else { // first bit is set
            long res1 = solution(n, k-1, i-1); // when one is taken out and rest number of bits are recursively passed into the function 

            long res0 = ncr(i, k); // when 0 is taken out from the number and the rest of the number we have to arrange k no of set bits in i-1 positions 

            res = res0 + res1;
        }

        return res;
    }

    public static long ncr(long n, long r) {
        if(n < r) // when number of places are less than the number of items to be placed
            return 0L;
        
        long res = 1L;

        for(long i = 0L; i < r; i++) {
            res = res * (n - i); 
            res = res / (i + 1);
        }

        return res;
    }
}
