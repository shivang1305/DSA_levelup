/*
    DSA Level-Up - RECURSION & BACKTRACKING                                               Date: 17-Jan-2020

    All palindromic permutations of a string

1. You are given a string of length n.
2. You have to print all the palindromic permutations of the given string.
3. If no palindromic permutation exists for the given string, print "-1".
*/



import java.io.*;
import java.util.*;

public class Main {

    public static void generatepw(int cs, int ts, HashMap < Character, Integer > fmap, Character oddc, String asf) {
        
        if(cs > ts) {
            String rev = "";
            for(int i = asf.length() - 1; i >= 0; i--) 
                rev += asf.charAt(i); // reversing the answer so far
            
            String res = asf;
            
            if(oddc != null) // adding the odd freq character if exists 
                res += oddc;
                
            res += rev; 
            
            System.out.println(res);
            return;
        }
        
        for(char ch : fmap.keySet()) {
            int freq = fmap.get(ch);
            if(freq > 0) {
                fmap.put(ch, freq - 1);
                
                generatepw(cs + 1, ts, fmap, oddc, asf + ch);
                
                fmap.put(ch, freq);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        HashMap < Character, Integer > fmap = new HashMap < > ();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(fmap.containsKey(ch)) { // when the given character is already present in the frequency map 
                int oldFreq = fmap.get(ch);
                fmap.put(ch, oldFreq + 1); // increase the frequency by 1
            }
            else // for new word in frequency map
                fmap.put(ch, 1); // put the frequency of new character as 1
        }
        
        Character oddFreqCh = null;
        int oddFreqNo = 0;
        
        int lngth = 0;
        
        for(char ch : fmap.keySet()) {
            int freq = fmap.get(ch);
            
            if(freq % 2 == 1) { // for odd frequency characters
                oddFreqCh = ch;
                oddFreqNo++;
            }
            
            fmap.put(ch, freq / 2); // reducing the string into half
            lngth += freq / 2; // length of that half string
        }
        
        if(oddFreqNo > 1) { // for more than 1 odd freq character in the string it is immpossible to make palindromic permutations for that string
            System.out.println(-1);
            return;
        }
        
        generatepw(1, lngth, fmap, oddFreqCh, "");
    }

}