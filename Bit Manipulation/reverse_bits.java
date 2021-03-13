/*
    DSA LEVELUP - Bit Manipulation                                              Date: 13-Mar-2021

Reverse bits of a given 32 bits unsigned integer.
*/

public class reverse_bits {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int rev = 0, j = 0;
        
        for(int i = 31; i >= 0; i--) {
            int mask = (1 << i);
            
            // only set those bit in the reverse number which are set in the orignal number (in a reverse order)
            
            if((n & mask) != 0) {
                
                int setMask = (1 << j);
                
                rev |= setMask; 
            }
            j++; // increase the reverse bit counter every time irrespective of the incoming bit
        }
        return rev;
    }
}