/*
    DSA LEVELUP - Bit Manipulation                                              Date: 23-Feb-2021

1. The gray code is a binary numeral system where two successive numbers differ in only one bit.
2. Given a non-negative integer n representing the total number of bits in the code, print the 
     sequence of gray code. A gray code sequence must begin with 0.
 
 Example:
    Input: 2

    Output: [0,1,3,2]

    Explanation:
        00 - 0
        01 - 1
        11 - 3
        10 - 2
        [0,2,3,1] is also a valid gray code sequence.
        00 - 0
        10 - 2
        11 - 3
        01 - 1
*/

import java.util.*;

public class gray_bit_code {

    public static ArrayList<String> solution(int n) {
        if(n == 1) { // base case
            ArrayList<String> bres = new ArrayList<>();
            bres.add("0"); // adding zero
            bres.add("1"); // adding one, for the base case as it has only 2 gray bits
            return bres;
        }

        ArrayList<String> rres = solution(n);
        ArrayList<String> mres = new ArrayList<>();

        for(int i = 0; i < rres.size(); i++) { // increasing loop 
            String str = rres.get(i);
            mres.add("0" + str); // adding zero in the result of old bit
        }

        for(int i = rres.size() - 1; i >= 0; i--) { // decreasing loop (so that the last bit of zeros can be grey with the first bit of ones)
            String str = rres.get(i);
            mres.add("1" + str); // adding one in the result of old bit 
        }

        return mres;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        scn.close();

        ArrayList<String> ans = solution(n - 1);

        for(String str : ans) {
            for(int i = 0; i < str.length(); i++) {
                System.out.print(str.charAt(i) + " ");
            }
            System.out.println();
        }
    }
}

/**
  Approach 2 - Print the actual number instead of bits i.e. print the numbers in decimal form of their bits.
  
  class Solution {
    
    public List<String> grayCodeHelper(int n) {
        // no case is possible for zero value
        if(n == 0) {
            List<String> noRes = new ArrayList<>();
            noRes.add("0");
            return noRes;
        }
        
        // base case
        if(n == 1) {
            List<String> baseRes = new ArrayList<>();
            baseRes.add("0"); // for bit 1 there are only 2 gray bits i.e 0 & 1
            baseRes.add("1");
            return baseRes;
        }
        
        List<String> oldRes = grayCodeHelper(n - 1);
        List<String> res = new ArrayList<>();
        
        for(int i = 0; i < oldRes.size(); i++) { // increasing loop 
            String str = oldRes.get(i);
            res.add("0" + str); // adding zero in the result of old bit
        }
        
        for(int i = oldRes.size() - 1; i >= 0; i--) { // decreasing loop 
            String str = oldRes.get(i);
            res.add("1" + str); // adding one in the result of old bit 
        }
        
        return res;
    }
    
    public List<Integer> grayCode(int n) {
        List<String> res = grayCodeHelper(n);
        List<Integer> ans = new ArrayList<>();
        
        for(int i = 0; i < res.size(); i++) {
            String str = res.get(i);
            int num = Integer.parseInt(str, 2); // converting the binary number string to decimal form integer
            ans.add(num);
        }
        
        return ans;
    }
}
 */
