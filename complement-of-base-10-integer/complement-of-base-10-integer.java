class Solution {
    public int bitwiseComplement(int n) {
        char[] binary = Integer.toBinaryString(n).toCharArray();
    
        for (int i = 0; i < binary.length; i++) 
            binary[i] = binary[i] == '0' ? '1' : '0';
        
        
        return bitsToDeci(binary);
    }
    
    private int bitsToDeci(char[] binary) {
        int result = 0;
        
        for (int i = binary.length-1; i >=0; i--) {
            if (binary[i] == '1')
                result += Math.pow(2, binary.length-i-1);
        }
        
        return result;
    }
}