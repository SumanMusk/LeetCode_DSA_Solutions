class Solution {
    public int climbStairs(int n) {
        int last=1,prevLast=1,ans=1;
        for(int i=0;i<n-1;i++){
            ans = last + prevLast;
            last = prevLast;
            prevLast = ans;
        }
        return ans;
    }
}