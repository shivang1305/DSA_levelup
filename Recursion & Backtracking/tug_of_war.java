/*
    DSA Level-Up - RECURSION & BACKTRACKING                                               Date: 28-Jan-2020

    Tug of war

1. You are given an array of n integers.
2. You have to divide these n integers into 2 subsets such that the difference of sum of two subsets 
   is as minimum as possible.
3. If n is even, both set will contain exactly n/2 elements. If  is odd, one set will contain (n-1)/2 and 
   other set will contain (n+1)/2 elements.
3. If it is not possible to divide, then print "-1".

Input -> 6
         1
         2
         3
         4
         5
         6

Output -> [1, 3, 6] [2, 4, 5]
*/
    
    static int minDiff = Integer.MAX_VALUE;
    static String ans = "";

    public static void solve(int[] arr, int vidx, ArrayList < Integer > set1, ArrayList < Integer > set2, int sumSet1,
        int sumSet2) {
        
        // base case
        if(vidx == arr.length) { 
            int sumDiff = Math.abs(sumSet1 - sumSet2);
            if(sumDiff < minDiff) { // finding the min difference set
                minDiff = sumDiff;
                ans = set1 + " " + set2;
            }
            return;
        }
        
        // one set must have the length less than half of the size of the array to be eligible to add more elements because the difference between the sizes of both sets can be 1            in case of odd array length and 0 in case of even array length
        
        if(set1.size() < (arr.length + 1) / 2) {  
            set1.add(arr[vidx]);
            solve(arr, vidx + 1, set1, set2, sumSet1 + arr[vidx], sumSet2); // adding the value into the required set at each level 
            set1.remove(set1.size() - 1); // while backtracking undo the action
        }
        
        if(set2.size() < (arr.length + 1) / 2) {
            set2.add(arr[vidx]);
            solve(arr, vidx + 1, set1, set2, sumSet1, sumSet2 + arr[vidx]);
            set2.remove(set2.size() - 1);
        }
    }
