/*
    DSA Level-Up - RECURSION & BACKTRACKING                                               Date: 15-Jan-2020

    Cryptarithmetic Puzzle

1. You are given three strings s1, s2 and s3.
2. First two are supposed to add and form third. s1 + s2 = s3
3. You have to map each individual character to a digit, so that the above equation holds true.
*/


// getting the indexed number from the string
public static int getNum(String str, HashMap < Character, Integer > charIntMap) {
    /* Approach 1 */
    // char ch = str.charAt(0);
    // int num = charIntMap.get(ch);
    
    // for(int i = 1; i < str.length(); i++) {
    //     num = num * 10 + charIntMap.get(str.charAt(i));
    // }
    
    // return num;
    
    /* Approach 2 */
    String num = "";
    for(int i = 0; i < str.length(); i++) {
        num += charIntMap.get(str.charAt(i));
    }
    
    return Integer.parseInt(num);
}


public static void solution(String unique, int idx,
    HashMap < Character, Integer > charIntMap, boolean[] usedNumbers,
    String s1, String s2, String s3) {

    // base condition
    if (idx == unique.length()) {
        int n1 = getNum(s1, charIntMap); 
        int n2 = getNum(s2, charIntMap);
        int n3 = getNum(s3, charIntMap);

        if (n1 + n2 == n3) { 
            for (int i = 0; i < 26; i++) {
                char ch = (char)('a' + i);
                if (charIntMap.containsKey(ch)) // only those characters to be printed which are present in hashmap
                    System.out.print(ch + "-" + charIntMap.get(ch) + " ");
            }
            System.out.println();
        }
        return;
    }

    char ch = unique.charAt(idx); // level - character
    for (int i = 0; i <= 9; i++) { // possible options
        if (usedNumbers[i] == false) { // real options

            charIntMap.put(ch, i);
            usedNumbers[i] = true;

            solution(unique, idx + 1, charIntMap, usedNumbers, s1, s2, s3); // recursive call

            // while backtracking undo
            usedNumbers[i] = false;
            charIntMap.put(ch, -1);
        }
    }
}