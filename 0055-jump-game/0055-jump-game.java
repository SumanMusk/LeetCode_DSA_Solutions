class Solution {
    public boolean canJump(int[] nums) {
        int g=nums.length-1;
        for(int i=nums.length-2;i>=0;i--) {
            if((i+nums[i]) >= g)
                g = i;
        }
        return (g == 0) ? true : false;
    }
}
/*class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length == 1) return true;
        else if(nums.length == 2 && nums[0] > 0) return true;
        else {
            boolean dp[] = new boolean[nums.length];
            dp[nums.length-1] = true;
            for(int i=nums.length-2;i>=0;i--) {
                for(int j=i+1;j<=(i + nums[i]) && j<nums.length;j++) {
                    if(dp[j]) {
                        dp[i] = true;
                        break;
                    }
                }
            }
            return dp[0];
        }
    }
}*/