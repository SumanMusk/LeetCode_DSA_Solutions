class Solution {
    public int maxSubArray(int[] nums) {
        int maxCurr=0,mainMax=Integer.MIN_VALUE;
        for(int i: nums){
            maxCurr += i;
            if(maxCurr < i)
                maxCurr = i;
            if(mainMax < maxCurr)
                mainMax = maxCurr;
        }
        return mainMax;
    }
}