class Solution {
    public int minDifference(int[] nums) {
        if(nums.length <= 4)
            return 0;
        Arrays.sort(nums);
        int ans=Integer.MAX_VALUE, i=0, j=nums.length-4;
        for(int x=0;x<4;x++) {
            if(nums[j]-nums[i] < ans)
                ans = nums[j]-nums[i];
            i++;
            j++;
        }
        return ans;
    }
}