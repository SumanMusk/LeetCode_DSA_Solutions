class Solution {
    public int coinChange(int[] coins, int amount) {
        int dp[] = new int[amount+1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for(int i=1;i<dp.length;i++){
            for(int j: coins){
                if(j <= i){
                    int x = dp[i];
                    int y = 1 + dp[i-j];
                    dp[i] = (int)Math.min(x, y);
                }
            }
        }
        if((dp[amount] == amount + 1)) return -1;
        else return dp[amount];
    }
}