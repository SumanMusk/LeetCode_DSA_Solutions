class Solution {
    public int lengthOfLIS(int[] nums) {
        int dp[] = new int[nums.length];
        Arrays.fill(dp, 1);
        for(int i=nums.length-2;i>=0;i--){
            int max = dp[i];
            for(int j=i+1;j<nums.length;j++){
                if(nums[i] < nums[j])
                    max = Math.max(max, (1+dp[j]));
            }
            dp[i] = max;
        }
        int max = Integer.MIN_VALUE;
        for(int i: dp)
            max = Math.max(max, i);
        return max;
    }
}