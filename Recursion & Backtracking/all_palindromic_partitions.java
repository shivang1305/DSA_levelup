/*
    DSA Level-Up - RECURSION & BACKTRACKING                                               Date: 19-Jan-2020

    All palindromic partitions of a string

1. You are given a string of length n.
2. You have to partition the given string in such a way that every partition is a palindrome.
*/


public static boolean isPalindromic(String str) {
    int li = 0, ri = str.length() - 1; // left and right indices
    while(li < ri) {
        char leftCh = str.charAt(li); // left and right characters
        char rightCh = str.charAt(ri);
        
        if(leftCh != rightCh) // not palindromic string
            return false;
        
        li++;
        ri--;
    }
    
    return true; // if passes all the above checks
}

public static void solution(String str, String asf) {
    // base case
    if(str.length() == 0) 
        System.out.println(asf);
    
    for(int i = 0; i < str.length(); i++) {
        String prefix = str.substring(0, i + 1);
        String ros = str.substring(i + 1);
        
        if(isPalindrome(prefix)) { // only if the partition is palindromic 
            solution(ros, asf + "(" + prefix + ") "); // call from rest of the string 
        }
    }
}