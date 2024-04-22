class Solution {
    public int jump(int[] nums) {
        int count=0;
        int l=0, r=0;
        while(r < nums.length-1) {
            int longest=0;
            for(int i=l;i<=r;i++) 
                longest = Math.max(longest, (i+nums[i]));
            l = r+1;
            r = longest;
            count++;
        }
        return count;
    }
}
/*class Solution {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        int temp=Integer.MAX_VALUE;
        if(nums.length == 1) return 0;
        dp[nums.length-1] = 0;
        for(int i=nums.length-2;i>=0;i--) {
            temp = Integer.MAX_VALUE;
            for(int j=i+1;j<=(i+nums[i]) && j<nums.length;j++) 
                temp = Math.min(temp, dp[j]);
            dp[i] = (temp == Integer.MAX_VALUE) ? Integer.MAX_VALUE : (1 + temp);
        }
        return dp[0];
    }
}*/