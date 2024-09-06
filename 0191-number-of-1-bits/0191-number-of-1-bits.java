// One of Bit-Manipulation Pattern Question
// Traversing each bit and checking each last bit is 1 or not
class Solution {
    public int hammingWeight(int n) {
        int count=0;
        while(n != 0) {
            count += n & 1;
            n >>= 1;
        }
        return count;
    }
}
/*
class Solution {
    public int hammingWeight(int n) {
        int count=0;
        while(n != 0) {
            n = n & (n-1);
            count++;
        }
        return count;
    }
}
// Converting Decimal to Binary number by Wrapper Class methods (without using any bit-manipulation)
class Solution {
    public int hammingWeight(int n) {
        int count=0;
        String s = Integer.toBinaryString(n);
        for(char ch: s.toCharArray())
            if(ch == '1')
                count++;
        return count;
    }
}
*/