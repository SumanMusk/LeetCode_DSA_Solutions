class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max=Integer.MIN_VALUE;
        for(int i: piles)
            max = Math.max(max, i);
        int l=1,r=max,ans=0;
        while(l<=r){
            int mid = (l+r)/2;
            int midVal = 0;
            for(int i : piles) {
                midVal += Math.ceil((double)i/mid);
            }
            if(midVal <= h){
                ans = mid;
                r = mid-1;
            }
            else if(midVal > h)
                l = mid+1;
        }
        return ans;
    }
}