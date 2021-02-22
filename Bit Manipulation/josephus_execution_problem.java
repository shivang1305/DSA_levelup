/*
    DSA LEVELUP - Bit Manipulation                                              Date: 22-Feb-2021

1. You are given an integer N which represents the total number of soldiers standing in a circle 
   having position marked from 1 to N.
2. A cruel king wants to execute them but in a different way.
3. He starts executing soldiers from 1st position and proceeds around the circle in clockwise 
   direction.
4. In each step, every second soldier is executed.
5. The elimination proceeds around the circle (which is becoming smaller and smaller as the 
   executed soldiers are removed), until only the last soldier remains, who is given freedom.
6. You have to find the position of that lucky soldier.
*/

import java.util.*;

public class josephus_execution_problem {

    public static int highestPowerOf2(int n) {
        int i = 1;
        while(i * 2 <= n) {
            i = i * 2;
        }
        return i;
    }

    public static int solution(int n) {
        int hp2 = highestPowerOf2(n);
        int l = n - hp2;
        return (2*l + 1);
    }

    public static void main(String[] ars) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        scn.close();

        System.out.println(solution(n));
    }
}
