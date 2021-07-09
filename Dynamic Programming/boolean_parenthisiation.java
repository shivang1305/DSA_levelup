import java.util.*;

public class boolean_parenthisiation {

    static HashMap<String, Integer> hm;
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s = scn.nextLine();

        scn.close();

        hm = new HashMap<>();

        int[][][] dp = new int[s.length() + 1][s.length() + 1][2];
        for(int i = 0; i < dp.length; i++) {
            for(int j = 0; j < dp[0].length; j++) {
                for(int k = 0; k < dp[0][0].length; k++) 
                    dp[i][j][k] = -1;
            }
        }

        System.out.println(solMemoized(s, 0, s.length() - 1, true));
    }

    public static int solRecursive(String s, int i, int j, boolean eval) {
        if(i > j) // base condition (empty string)
            return 0;

        if(i == j) { // base condition (single char in the string)
            if(eval == true)
                return s.charAt(i) == 'T' ? 1 : 0;
            else
                return s.charAt(i) == 'F' ? 1 : 0;
        }

        int ans = 0;
        for(int k = i + 1; k <= j - 1; k++) { // k loop schema
            
            int lT = solRecursive(s, i, k - 1, true); // left true
            int lF = solRecursive(s, i, k - 1, false); // left false
            int rT = solRecursive(s, k + 1, j, true); // right true
            int rF = solRecursive(s, k + 1, j, false); // right false

            if(s.charAt(k) == '&') { // AND operator only
                if(eval == true) // no of ways to obtain true for the passed sub-expression
                    ans += lT * rT;
                else // no of ways to obtain false for the passed sub-expression
                    ans += (lF * rT) + (lT * rF) + (lF * rF);
            }

            else if(s.charAt(k) == '|') { // OR operator only
                if(eval == true) 
                    ans += (lT * rT) + (lF * rT) + (lT * rF);
                else
                    ans += (lF * rF);
            }

            else if(s.charAt(k) == '^') { // XOR operator only
                if(eval == true)
                    ans += (lF * rT) + (lT * rF);
                else
                    ans += (lT * rT) + (lF * rF);
            }
        }

        return ans;
    }
    
    public static int solMemoized(String s, int i, int j, boolean eval) {
        if(i > j) // base condition (empty string)
            return 1;

        if(i == j) { // base condition (single char in the string)
            if(eval)
                return (s.charAt(i) == 'T') ? 1 : 0;
            else
                return (s.charAt(i) == 'F') ? 1 : 0;
        }
        
        String temp = "" + i + " " + j + " " + eval;
        if(hm.containsKey(temp))
            return hm.get(temp);

        int ans = 0;
        for(int k = i + 1; k <= j - 1; k++) { // k loop schema
            
            int lT = solMemoized(s, i, k - 1, true); // left true
            int lF = solMemoized(s, i, k - 1, false); // left false
            int rT = solMemoized(s, k + 1, j, true); // right true
            int rF = solMemoized(s, k + 1, j, false); // right false

            if(s.charAt(k) == '&') { // AND operator only
                if(eval) // no of ways to obtain true for the passed sub-expression
                    ans += lT * rT;
                else // no of ways to obtain false for the passed sub-expression
                    ans += (lF * rT) + (lT * rF) + (lF * rF);
            }

            else if(s.charAt(k) == '|') { // OR operator only
                if(eval) 
                    ans += (lT * rT) + (lF * rT) + (lT * rF);
                else
                    ans += (lF * rF);
            }

            else if(s.charAt(k) == '^') { // XOR operator only
                if(eval)
                    ans += (lF * rT) + (lT * rF);
                else
                    ans += (lT * rT) + (lF * rF);
            }
        }
        hm.put(temp, ans);
        return ans;
    }

    // 3D matrix 
    public static int solMemoized(String s, int i, int j, boolean eval, int[][][] dp) {
        if(i > j) // base condition (empty string)
            return 1;

        if(i == j) { // base condition (single char in the string)
            if(eval == true) {
                if(s.charAt(i) == 'T')
                    return 1;
                else
                    return 0;
            }

            else {
                if(s.charAt(i) == 'F')
                    return 1;
                else
                    return 0;
            }
        }

        if(dp[i][j][eval ? 1 : 0] != -1)
            return dp[i][j][eval ? 1 : 0];

        int ans = 0;
        for(int k = i + 1; k <= j - 1; k += 2) { // k loop schema
            
            int lT = solMemoized(s, i, k - 1, true, dp); // left true
            int lF = solMemoized(s, i, k - 1, false, dp); // left false
            int rT = solMemoized(s, k + 1, j, true, dp); // right true
            int rF = solMemoized(s, k + 1, j, false, dp); // right false

            if(s.charAt(k) == '&') { // AND operator only
                if(eval == true) // no of ways to obtain true for the passed sub-expression
                    ans += lT * rT;
                else // no of ways to obtain false for the passed sub-expression
                    ans += (lF * rT) + (lT * rF) + (lF * rF);
            }

            else if(s.charAt(k) == '|') { // OR operator only
                if(eval == true) 
                    ans += (lT * rT) + (lF * rT) + (lT * rF);
                else
                    ans += (lF * rF);
            }

            else if(s.charAt(k) == '^') { // XOR operator only
                if(eval == true)
                    ans += (lF * rT) + (lT * rF);
                else
                    ans += (lT * rT) + (lF * rF);
            }
        }

        return dp[i][j][eval ? 1 : 0] = ans;
    }
}
