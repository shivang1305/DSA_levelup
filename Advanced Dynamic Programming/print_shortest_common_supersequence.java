import java.util.*;

public class print_shortest_common_supersequence {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        String str1 = scn.nextLine();
        String str2 = scn.nextLine();

        scn.close();

        System.out.println(shortestCommonSupersequence(str1, str2));
    }
    
    public static String shortestCommonSupersequence(String str1, String str2) {
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        
        for(int i = 0; i < dp.length; i++) {
            for(int j = 0; j < dp[0].length; j++) {
                if(i == 0 || j == 0) //INITIALIZATION
                    dp[i][j] = 0;
                
                else if(str1.charAt(i - 1) == str2.charAt(j - 1)) //CHOICE DAIGRAM
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        
        int i = str1.length(), j = str2.length(); // put the indices at the end of the dp matrix
        String ans = "";
        
        while(i > 0 && j > 0) { // till we get in the 1st row or 1st column where one string becomes empty
            if(str1.charAt(i - 1) == str2.charAt(j - 1)) { // check for chars are equal in both strings
                ans += str1.charAt(i - 1); // append the char in the ans string
                i--; // reduce both i & j so that we can move in the previous daigonal element 
                j--;
            }
            else { // when the char in both strings are not equal
                if(dp[i - 1][j] > dp[i][j - 1]) { // now move the element which is greater out of the two
                    ans += str1.charAt(i - 1); // pushing the non common chars also in the ans string
                    i--;
                }
                else {
                    ans += str2.charAt(j - 1);
                    j--;
                }
            }
        }
        
        // when any string turns empty during this process then we push all the remaining chars in the ans string
        while(i > 0) {
            ans += str1.charAt(i - 1);
            i--;
        }
        
        while(j > 0) {
            ans += str2.charAt(j - 1);
            j--;
        }
        
        // to reverse the final string
        StringBuilder sb = new StringBuilder();
        sb.append(ans);
        ans = sb.reverse().toString();
        
        return ans;
    }
}
