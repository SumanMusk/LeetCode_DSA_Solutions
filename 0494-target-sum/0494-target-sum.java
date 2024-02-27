class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for(int i: nums)
            sum += i;
        if((sum + target)%2 != 0) return 0;
        int val = (sum + target) / 2;
        if(val < 0) return 0;
        int dp[][] = new int[nums.length+1][val+1];
        dp[0][0] = 1;
        for(int i=1;i<=nums.length;i++){
            for(int j=0;j<=val;j++){
                // if we include the current indexed value
                if((j - nums[i-1]) >= 0) dp[i][j] = dp[i-1][j - nums[i-1]] + dp[i-1][j];
                // or we exclude the current indexed value
                else dp[i][j] = dp[i-1][j];
            }
        }
        return dp[nums.length][val];
    }
}
/*
class Solution {
    int count=0;
    public void targetSum(int[] arr, int idx, int total, int target) {
        if(idx == arr.length){
            if(total == target) count++;
            return;
        }
        else{
            targetSum(arr, idx+1, total+arr[idx], target);
            targetSum(arr, idx+1, total-arr[idx], target);
        }
    }
    public int findTargetSumWays(int[] nums, int target) {
        targetSum(nums, 0, 0, target);
        return count;
    }
}
*/