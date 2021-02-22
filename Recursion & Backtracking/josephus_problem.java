/*
    DSA Level-Up - RECURSION & BACKTRACKING                                               Date: 13-Jan-2020

    The game of execution - Josephus Problem

1. You are given two numbers N and K.
2. N represents the total number of soldiers standing in a circle having position marked from 0 
     to N-1.
3. A cruel king wants to execute them but in a different way.
4. He starts executing soldiers from 0th position and proceeds around the circle in clockwise 
     direction.
5. In each step, k-1 soldiers are skipped and the k-th soldier is executed.
6. The elimination proceeds around the circle (which is becoming smaller and smaller as the 
     executed soldiers are removed), until only the last soldier remains, who is given freedom.
7. You have to find the position of that lucky soldier.

*/

import java.io.*;
import java.util.*;

public class Main {

    public static int solution(int n, int k) {
        // base case
        if (n == 1) // for the last element left in recursion tree
            return 0; // it is always converted to corresponding zeroth position

        int x = solution(n - 1, k);
        int y = (x + k) % n; // converting to corresponding orignal position while uplifting in the recursion tree
        return y;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();
        System.out.println(solution(n, k));
    }

}