class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1)
            return nums[0];
        else if(nums.length == 2)
            return Math.max(nums[0], nums[1]);
        else{
            for(int i=nums.length-3;i>=0;i--){
                int y = Integer.MIN_VALUE;
                int x = nums[i] + nums[i+2];
                if(i+3 < nums.length)
                    y = nums[i] + nums[i+3];
                nums[i] = Math.max(x,y);
            }
            int y = Integer.MIN_VALUE;
            for(int i: nums)    
                y = Math.max(y, i);
            return y;
        }
    }
}