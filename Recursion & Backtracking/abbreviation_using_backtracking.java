/*
    DSA Level-Up - RECURSION & BACKTRACKING                                               Date: 04-Jan-2020

    Abbreviation Using Backtracking

1. You are given a word.
2. You have to generate all abbrevations of that word.

Example:
    input: pep

    output: 000 -> pep
            001 -> pe1
            010 -> p1p
            011 -> p2
            100 -> 1ep
            101 -> 1e1
            110 -> 2p
            111 -> 3
*/



public static void solution(String str, String asf, int count, int pos) {
    // base case
    if(pos == str.length()) {
        if(count == 0)
            System.out.println(asf);
        else
            System.out.println(asf + count);
        
        return;
    }
    
    // yes ki call
    if(count > 0)
        solution(str, asf + count + str.charAt(pos), 0, pos + 1);
    else 
        solution(str, asf + str.charAt(pos), 0, pos + 1);
        
    // no ki call
    solution(str, asf, count + 1, pos + 1);

}