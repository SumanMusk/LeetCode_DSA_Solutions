class Solution {
    public int minSteps(int n) {
        if(n == 1) 
            return 0;
        return 1 + helper(n, 1, 1);
    }
    public int helper(int n, int curr_A, int clipBoard_A) {
        if(curr_A == n)
            return 0;
        if(curr_A > n)
            return 10000;

        int copy_and_paste = 1 + 1 + helper(n, curr_A + curr_A, curr_A);
        int only_paste = 1 + helper(n, curr_A + clipBoard_A, clipBoard_A);

        return Math.min(copy_and_paste, only_paste);
    }
}