/*
    DSA Level-Up - RECURSION & BACKTRACKING                                               Date: 17-Jan-2020

    Partitions in K subsets

1. You are given two integers n and k, where n represents number of elements and k represents 
   number of subsets.
2. You have to partition n elements in k subsets and print all such configurations.
*/


public static void solution(int i, int n, int k, int rssf, ArrayList < ArrayList < Integer >> ans) {
        // base case
        if(i > n) {
            if(rssf == k) { // when no set is empty
                counter++;
                System.out.print(counter + ". ");
                for(ArrayList<Integer> set : ans) { // printing every set from the ans
                    System.out.print(set + " ");
                }
                System.out.println();
            }
            return;
        }
        
        for(int j = 0; j < ans.size(); j++) {
            if(ans.get(j).size() > 0) { // for non-empty existing sets
                
                ans.get(j).add(i); // adding the number in the set
                
                solution(i + 1, n , k, rssf, ans); // since no new set is created here therefore we did not increase number of sets
                
                ans.get(j).remove(ans.get(j).size() - 1); // removing the last added element from the list while backtracking
            }
            else { // for the empty sets
                
                ans.get(j).add(i); // adding the number in the first non-empty set
                
                solution(i + 1, n, k, rssf + 1, ans); // here a new set is created so number of sets is increased
                
                ans.get(j).remove(ans.get(j).size() - 1); // removing the last added element from the list while backtracking
                
                break; // to avoid permutations to create
            }
        }

    }