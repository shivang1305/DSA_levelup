/*
    LEETCODE - Medium                                                                Date: 19-Jan-2020

    All palindromic partitions of a string

Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.
A palindrome string is a string that reads the same backward as forward.
*/


class Solution {
public:
    vector<vector<string>> ans;
    
    // function to check that given string is palindrome or not 
    bool isPalindromic(string s) {
        string rev = s;
        reverse(s.begin(), s.end());
        
        if(rev == s)
            return true;
        else
            return false;
    }
    
    void partitionPalindromic(string s, vector<string> p) {
        // base case
        if(s.size() == 0) {
            ans.push_back(p);
            return;
        }
            
        for(int i = 0; i < s.size(); i++) {
            string prefix = s.substr(0, i + 1); 
            string restOfStr = s.substr(i + 1);
            
            if(isPalindromic(prefix)) { // palindromic partition only
                p.push_back(prefix);
                partitionPalindromic(restOfStr, p); // recursive call
                p.pop_back(); // backtracking
            }     
        }    
    }
    
    vector<vector<string>> partition(string s) {
        vector<string> str;
        partitionPalindromic(s, str);
        return ans;
    }
};