/*
    DSA Level-Up - RECURSION & BACKTRACKING                                               Date: 28-Jan-2020

    Invalid Parantheses

1. You are given a string, which represents an expression having only opening and closing parenthesis.
2. You have to remove minimum number of parenthesis to make the given expression valid.
3. If there are multiple answers, you have to print all of them.

Input -> ()())()

Output -> (())()
          ()()()
*/



import java.io.*;
import java.util.*;

public class Main {

    public static void solution(String str, int minRemoval, HashSet < String > ans) {
        // base case
        if(minRemoval == 0) {
            int minRemovalNow = getMin(str); // for the current string 
            
            if(minRemovalNow == 0) { // for the current string to be the valid ans 
                if(!ans.contains(str)) { // if the hashset does not contains the same ans  to remove duplicacy
                    System.out.println(str);
                    ans.add(str); // adding the ans to the hashset
                }
            }
            return;
        }
        
        for(int i = 0; i < str.length(); i++) { // to traverse the whole string at each level
            // obtaining left and right prefixes and removing the invalid paranthesis at each level
            String left = str.substring(0 , i); 
            String right = str.substring(i + 1);
            
            solution(left + right, minRemoval - 1, ans); // recursive call
        }
    }

    public static int getMin(String str) {
        Stack<Character> st = new Stack<>();
        
        for(int i = 0; i < str.length(); i++) { 
            char ch = str.charAt(i); 
            
            if(ch == '(') 
                st.push(ch); 
            else if(ch == ')') { 
                if(st.size() == 0) 
                    st.push(ch);
                else if(st.peek() == '(')
                    st.pop();
                else if(st.peek() == ')')
                    st.push(ch);
            }
        }
        
        return st.size();
    }

    
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        solution(str, getMin(str), new HashSet < > ());
    }

}