public class longest_bitonic_sequence {
    public int LongestBitonicSequence(int[] arr)
    {
        int[] lis = new int[arr.length]; // obtain the lis first
        
        for(int i = 0; i < lis.length; i++) {
            
            int max = 0; // temp ans 
            
            for(int j = 0; j < i; j++) {
                
                if(arr[i] > arr[j]) 
                    max = Math.max(max, lis[j]);
            }
            
            lis[i] = max + 1;
        }

        int[] lds = new int[arr.length]; // obtain the lds second
        
        for(int i = lds.length - 1; i >= 0; i--) { // reverse traverse the array 
            
            int max = 0; // temp ans 
            
            for(int j = arr.length - 1; j > i; j--) { // obtain lds from right to left
                
                if(arr[i] > arr[j]) 
                    max = Math.max(max, lds[j]);
            }
            
            lds[i] = max + 1;
        }

        int ans = 0;
        for(int i = 0; i < arr.length; i++) 
            ans = Math.max(ans, lis[i] + lds[i] - 1);
        
        return ans;
    }
}
