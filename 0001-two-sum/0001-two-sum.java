class Solution {    
    public int[] twoSum(int[] nums, int target) {
        int c;
        int ans[] = new int[2];
        for(int i=0;i<nums.length-1;i++){
            c = target - nums[i];
            for(int j=i+1;j<nums.length;j++){
                if(nums[j] == c){
                    ans[0] = i;
                    ans[1] = j;
                }
            }
        }
        return ans;
    }
}


