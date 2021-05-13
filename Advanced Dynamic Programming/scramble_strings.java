public class scramble_strings {
    static HashMap<String, Integer> hm;

    public int isScramble(final String A, final String B) {
        if(A.length() != B.length()) // length of both strings are different
            return 0;
            
        if(A.length() == 0 && B.length() == 0) // when both the strings are empty
            return 1;
            
        hm = new HashMap<>();
            
        return solMemoized(A, B);
    }

    public boolean solRecursive(String A, String B) {
        if(A.equals(B)) // when both the strings are equal
            return true;
        
        if(A.length() <= 1) // when any one string becomes empty
            return false;
            
        int n = A.length();
        boolean flag = false;
        
        for(int i = 0; i <= n - 1; i++) { // traverse through any one string and partition it 
            if(
                (solRecursive(A.substring(0, i), B.substring(n - i)) == true &&
                solRecursive(A.substring(i), B.substring(0, n - i)) == true) // this whole condition is when there is a swap at position i
                
                ||
                
                (solRecursive(A.substring(0, i), B.substring(0, i)) == true &&
                solRecursive(A.substring(i), B.substring(i)) == true) // when there is no swap done at position i in the given string
                
                == true
                ) {
                    flag = true;
                    break;
                }
        
        }
        return flag;
    }
    
    // here memoization is done by using hashmap <key, value>
    public int solMemoized(String A, String B) {
        
        String key = A + " " + B;
        if(hm.containsKey(key))
            return hm.get(key);
            
        if(A.compareTo(B) == 0) {// when both the strings are equal
            hm.put(key, 1);
            return 1;
        }
        
        if(A.length() <= 1) // when any one string becomes empty
            return 0;
            
        int n = A.length();
        int flag = 0;
        
        for(int i = 1; i <= n - 1; i++) { // traverse through any one string and partition it 
            if(
                (solMemoized(A.substring(0, i), B.substring(n - i)) == 1 &&
                solMemoized(A.substring(i), B.substring(0, n - i)) == 1) 
                
                ||
                
                (solMemoized(A.substring(0, i), B.substring(0, i)) == 1 &&
                solMemoized(A.substring(i), B.substring(i)) == 1)
                ){
                    flag = 1;
                    break;
            }
        
        }
        hm.put(key, flag);
        return flag;
    }
}
