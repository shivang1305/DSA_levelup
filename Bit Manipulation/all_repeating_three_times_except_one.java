/*
    DSA LEVELUP - Bit Manipulation                                              Date: 16-Mar-2021

1. You are given an array of numbers.
2. All numbers occur thrice in the array except one.
3. You have to find the element that occurs once.
*/

import java.util.*;

public class all_repeating_three_times_except_one {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] arr = new int[n];

        for(int i = 0; i < n; i++)
            arr[i] = scn.nextInt();

        scn.close();

        solution(arr);
    }

    public static void solution(int[] arr) {
        int tn = Integer.MAX_VALUE, tnp1 = 0, tnp2 = 0;

        for(int i = 0; i < arr.length; i++) {
            // for the current number in the array obtain the number of ones uptill now and accordingly categorize it in the category of 3n, 3n + 1, 3n + 2
            int cwtn = arr[i] & tn;  // 3n
            int cwtnp1 = arr[i] & tnp1; // 3n + 1
            int cwtnp2 = arr[i] & tnp2; // 3n + 2

            tn = tn & (~cwtn); // off the bits in 3n
            tnp1 = tnp1 | cwtn; // on the bits in 3n + 1 (since it was already on in 3n and came again so it will become 3n + 1)

            tnp1 = tnp1 & (~cwtnp1); // off the bits in 3n + 1
            tnp2 = tnp2 | cwtnp1; // on the bits in 3n + 2(since it was already on in 3n + 1 and came again so it will become 3n + 2)

            tnp2 = tnp2 & (~cwtnp2); // off the bits in 3n + 2
            tn = tn | cwtnp2; // on the bits in 3n (since it was already on in 3n + 2 and came again so it will become 3n + 3 = 3n)
        }
        
        System.out.println(tnp1);
    }
}