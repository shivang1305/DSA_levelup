/*
    DSA Level-Up - RECURSION & BACKTRACKING                                               Date: 27-Jan-2020

    Word Break

1. You are given n space separated strings, which represents a dictionary of words.
2. You are given another string which represents a sentence.
3. You have to print all possible sentences from the string, such that words of the sentence are 
   present in dictionary.
*/



import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        HashSet < String > dict = new HashSet < > ();
        for (int i = 0; i < n; i++) {
            dict.add(scn.next());
        }
        String sentence = scn.next();
        wordBreak(sentence, "", dict);
    }

    public static void wordBreak(String str, String ans, HashSet < String > dict) {
        if (str.length() == 0) { // base case
            System.out.println(ans);
            return;
        }

        for (int i = 0; i < str.length(); i++) { // looping through the current string at every level
            String prefix = str.substring(0, i + 1); // obtaining the substring

            if (dict.contains(prefix)) { // matching the words
                String ros = str.substring(i + 1);
                wordBreak(ros, ans + prefix + " ", dict);
            }
        }
    }

}