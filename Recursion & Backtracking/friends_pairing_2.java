/*
    DSA Level-Up - RECURSION & BACKTRACKING                                               Date: 15-Jan-2020

    Friends Pairing 2

1. You are given an integer n, which represents n friends numbered from 1 to n.
2. Each one can remain single or can pair up with some other friend.
3. You have to print all the configurations in which friends can remain single or can be paired up.
*/
    
    
    static int counter = 1;

    public static void solution(int i, int n, boolean[] used, String asf) {
        // base case
        if( i > n) {
            System.out.println(counter + "." + asf);
            counter++;
            return;
        }
        
        if(used[i] == true)  // when the number is already used then no change can be done in the answer
            solution(i + 1, n, used, asf); // cross call
        
        else {
            used[i] = true; // node pre
            
            solution(i + 1, n, used, asf + "(" + i + ") "); // akele jaane waali call or . call
            
            // possible options
            for(int j = i + 1; j <= n; j++) { // every number can make a call to pair with number greater than the current number
                if(used[j] == false) { // real options
                    used[j] = true; // edge pre - while going deep into the recursion tree
                    
                    solution(i + 1, n, used, asf + "(" + i + j + ") "); // loop call
                    
                    used[j] = false; // edge post - while coming back up in the recurion tree - backtracking
                }
            }
            used[i] = false; // node post
        }