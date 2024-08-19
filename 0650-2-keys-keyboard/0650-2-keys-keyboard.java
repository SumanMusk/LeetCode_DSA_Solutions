class Solution {
    public int minSteps(int n) {
        if(n == 1) 
            return 0;
        int dp[][] = new int[2000][2000];
        return 1 + helper(n, dp, 1, 1);
    }
    public int helper(int n, int[][] dp, int curr_A, int clipBoard_A) {
        if(curr_A == n)
            return 0;
        if(dp[curr_A][clipBoard_A] != 0)
            return dp[curr_A][clipBoard_A];
        if(curr_A > n)
            return 10000;

        int copy_and_paste = 1 + 1 + helper(n, dp, curr_A + curr_A, curr_A);
        int only_paste = 1 + helper(n, dp, curr_A + clipBoard_A, clipBoard_A);

        dp[curr_A][clipBoard_A] = Math.min(copy_and_paste, only_paste);
        return dp[curr_A][clipBoard_A];
    }
}