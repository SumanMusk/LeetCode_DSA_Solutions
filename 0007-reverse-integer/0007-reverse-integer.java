class Solution {
    public int reverse(int x) {
        int ans=0;
        while(x != 0){
            int mod = x % 10;
            if(Integer.MAX_VALUE / 10 < ans || (Integer.MAX_VALUE / 10 == ans && mod >= Integer.MAX_VALUE % 10))
                return 0;
            if(Integer.MIN_VALUE / 10 > ans || (Integer.MIN_VALUE / 10 == ans && mod <= Integer.MIN_VALUE % 10))
                return 0;
            ans = (ans*10) + mod;
            x /= 10;
        }
        return ans;   
    }
}
/*
// illegal way: Disrupting this assumption "Assume the environment does not allow you to store 64-bit integers (signed or unsigned)."
class Solution {
    public int reverse(int x) {
        long s=0,c=0;
        while(x!=0){
            long a = x%10;
            s = a + (s*10);
            x=x/10;
        }
        if(Integer.MIN_VALUE <= s && s <= Integer.MAX_VALUE)
            return (int)s; 
        return 0;   
    }
}
*/