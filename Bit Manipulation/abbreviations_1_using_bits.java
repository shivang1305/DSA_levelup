import java.util.*;

public class abbreviations_1_using_bits {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        scn.close();

        solve(str);
    }

    public static void solve(String str) {
        for(int i = 0; i < (1 << str.length()); i++) { 
            
            StringBuilder sb = new StringBuilder();
            int count = 0;
            
            for(int j = 0; j < str.length(); j++) {
                
                int bit = str.length() - 1 - j; // since bits are read in reverse order
                char ch = str.charAt(j);

                if((i & (1 << bit)) == 0) { // if the incoming bit is off
                    
                    if(count == 0) 
                        sb.append(ch); // append the char only in case where count is zero
                    
                    else {
                        sb.append(count); // first append the count
                        sb.append(ch); // then append the char
                        count = 0; // then set the count to zero agin
                    }
                }
                else
                    count++; // when the incoming bit is on just increase the counter
            }
            if(count > 0)
                sb.append(count); // if count is left non zero in the end of on number then append it
                
            System.out.println(sb);
        }
    }
}
