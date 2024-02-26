class Solution {
    public int maxProfit(int[] prices) {
        int dp[][] = new int[3][prices.length];
        for(int i=0;i<prices.length;i++){
            if(i == 0) dp[1][0] = prices[0] * -1;
            else{
                dp[0][i] = Math.max(dp[0][i-1], dp[2][i-1]);
                dp[1][i] = Math.max(dp[1][i-1], (dp[0][i-1] - prices[i]));
                dp[2][i] = dp[1][i-1] + prices[i];
            }
        }
        return Math.max(dp[0][prices.length-1], dp[2][prices.length-1]);
    }
}