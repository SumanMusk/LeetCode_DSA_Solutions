class Solution {
    public int maxProduct(int[] nums) {
        if(nums.length == 1)
            return nums[0];
        else{
            int start=1,end=1,ans=nums[0];
            for(int i=0,j=nums.length-1;i<nums.length&&j>=0;i++,j--){
                start = start==0 ? 1:start;
                end = end==0 ? 1:end;
                start *= nums[i];
                end *= nums[j];
                ans = Math.max(ans, Math.max(start, end));
            }
            return ans;
        }
    }
}