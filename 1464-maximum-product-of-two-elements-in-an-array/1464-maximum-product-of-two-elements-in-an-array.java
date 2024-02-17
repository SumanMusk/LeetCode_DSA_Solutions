class Solution {
    public int maxProduct(int[] nums) {
        Arrays.sort(nums);
        int max = Integer.MIN_VALUE;
        for(int i=0;i<nums.length-1;i++)
            max = Math.max(max, ((nums[i]-1)*(nums[i+1]-1)));
        return max;
    }
}