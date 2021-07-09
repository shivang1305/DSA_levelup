import java.util.*;

public class egg_dropping_problem {
    static HashMap<String, Integer> memo;
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int e = scn.nextInt(); // number of eggs
        int f = scn.nextInt(); // number of floors in the building
        scn.close();
        
        // System.out.println(solRecursive(e, f)); // min number of trails (dropping eggs from specified floor) needed in order to calculate the threshold/critical floor in worst case scenario.

        memo = new HashMap<>();
        System.out.println(solMemoized(e, f));
    }

    public static int solRecursive(int e, int f) {
        // base conditions
        if(f == 0 || f == 1) 
            return f;

        if(e == 1) // we will be keep checking from 1st floor to f floors in this case resulting into f attempts
            return f;

        int ans = Integer.MAX_VALUE;

        for(int k = 1; k <= f; k++) {
            int temp = 1 + Math.max(solRecursive(e - 1, k - 1), solRecursive(e, f - k)); // number of attempts here max is calculated because we need worst case scenario

            ans = Math.min(ans, temp);
        }
        return ans;
    }

    public static int solMemoized(int e, int f) {
        // base conditions
        if(f == 0 || f == 1) 
            return f;

        if(e == 1) // we will be keep checking from 1st floor to f floors in this case resulting into f attempts
            return f;

        String key = "" + e + " " + f;
        if(memo.containsKey(key))
            return memo.get(key);

        int ans = Integer.MAX_VALUE;

        for(int k = 1; k <= f; k++) {
            int temp = 1 + Math.max(solMemoized(e - 1, k - 1), solMemoized(e, f - k)); // number of attempts here max is calculated because we need worst case scenario

            ans = Math.min(ans, temp);
        }
        memo.put(key, ans);
        return ans;
    }
}
