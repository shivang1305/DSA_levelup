/*
    DSA Level-Up - RECURSION & BACKTRACKING                                               Date: 05-Feb-2020

    Largest Number possible after k swaps

1. You are given a string which represents digits of a number.
2. You have to create the maximum number by performing at-most k swap operations on its digits.

*/  

public static String swap(String str, int i, int j) {
    char ith = str.charAt(i);
    char jth = str.charAt(j);
    
    String left = str.substring(0, i);
    String middle = str.substring(i + 1, j);
    String right = str.substring(j + 1);
    
    return left + jth + middle + ith + right;
}

static String max;

public static void findMaximum(String str, int k) {
    // finding the max number out of all created 
    if(Integer.parseInt(str) > Integer.parseInt(max)) 
        max = str;
    
    // base case (when we exceeds the max number of swaps)
    if(k == 0) 
        return;
    
    for(int i = 0; i < str.length() - 1; i++) {
        for(int j = i + 1; j < str.length(); j++) {
            if(str.charAt(i) < str.charAt(j)) {
                str = swap(str, i, j); // swapping in the string
                
                findMaximum(str, k - 1); // recursive call with a decrement in max no of swaps
                
                str = swap(str, i , j); // undo while backtracking (two swaps on same values are nullified)
            }
        }
    }
}