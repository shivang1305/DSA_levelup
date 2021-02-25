/*
    DSA LEVELUP - Bit Manipulation                                              Date: 24-Feb-2021

1. You are given N number of words.
2. You are given M puzzles in the form of M strings.
3. For a given puzzle, a word is valid if both the following conditions are confirmed - 
    Condition 1 -> Word contains the first letter of puzzle.
    Condition 2 -> For each letter in word, that letter should be present in puzzle.
4. You have to print the number of valid words corresponding to a puzzle.
*/

import java.util.*;

public class no_of_valid_words {

    public static ArrayList<Integer> findNumOfValidWords (String[] words, String[] puzzles) {
        
        HashMap<Character, ArrayList<Integer>> hm = new HashMap<>();

        for(int i = 0; i < 26; i++) 
            hm.put((char)('a' + i), new ArrayList<>()); // putting empty arraylist in front of each letter till 'a' to 'z'

        // for words
        for(String word : words) { // traversing the words array and taking out each word 
            int wMask = 0;
            for(char ch : word.toCharArray()) { // traversing each word and taking out characters
                int bit = ch - 'a'; // setting the bit for each char
                wMask = wMask | (1 << bit); // making the mask for each letter of the word
            }

            HashSet<Character> uniqueChars = new HashSet<>(); // to avoid the duplicacy of same chars

            for(char ch : word.toCharArray()) {
                if(!uniqueChars.contains(ch)) {
                    uniqueChars.add(ch); // so that same word cannot be added to the same char in hashmap even if it is repeating
                    hm.get(ch).add(wMask); // adding the mask of each word in the hashmap for all the letters that the word contains
                }
                
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();

        // for puzzles
        for(String puzzle : puzzles) {
            int pMask = 0;
            for(char ch : puzzle.toCharArray()) {
                int bit = ch - 'a'; // getting the bit mask for each letter of the puzzle
                pMask = pMask | (1 << bit); // obtain the bit mask for each puuzle
            }

            char firstPuzzleChar = puzzle.charAt(0); // obtaining the first character of the puzzle
            ArrayList<Integer> wordsToCheck = hm.get(firstPuzzleChar); // getting only those words from the hashmap which has the first char of the puzzle (first condition)

            int count = 0;

            for(int validWordMask : wordsToCheck) {
                if((pMask & validWordMask) == validWordMask) // checking for the second condition i.e. each char of the word must be in the puzzle
                    count++; 
            }

            ans.add(count);
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
		int n = scn.nextInt(); // number of words
		
        String[] words = new String[n];
		for(int i = 0 ; i < words.length; i++) {
			words[i] = scn.next(); // each word
		}

		int m = scn.nextInt(); // no of puzzles
		
        String[] puzzles = new String[m];
		for(int i = 0 ; i < m ;i++) {
			puzzles[i] = scn.next(); // each puzzle
		}

        scn.close();

		ArrayList<Integer> ans = findNumOfValidWords(words,puzzles); // function call
		
        for(int i = 0; i < ans.size(); i++) {
			System.out.println(puzzles[i] + " -> " + ans.get(i)); // output
		}
    }
}