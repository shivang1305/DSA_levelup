/*
    DSA LEVELUP - Bit Manipulation                                              Date: 12-Mar-2021

1. You are given a number n.
2. You have to print the count of set bits of first n natural numbers.
*/

import java.util.*;

public class count_set_bits_in_N_natural_nos {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        scn.close();
        System.out.println(solution(n));
    }

    public static int solution(int n) {
        if(n == 0)
            return 0;

        int x = maxPowerOf2(n);

        int ans = ((1 << (x - 1)) * x) + (n - (1 << x) + 1) + solution(n - (1 << x));

        // (1 << x) here depicts 2^x

        return ans;
    }

    public static int maxPowerOf2(int n) {
        int x = 0;

        while((1 << x) <= n)
            x++;
        
        return x - 1;
    }
}
