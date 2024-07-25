class Solution {
    public int[] sortArray(int[] nums) {
        for(int i=1;i<nums.length;i++) {
            int curr = nums[i];
            int j = i;
            while(j > 0 && nums[j-1] > curr) {
                nums[j] = nums[j-1];
                j--;
            }
            nums[j] = curr;
        }
        return nums;
    }
}