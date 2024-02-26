class Solution {
    public int change(int amount, int[] coins) {
        int dp[][] = new int[coins.length][amount+1];
        for(int i=0;i<coins.length;i++)
            dp[i][0] = 1;
        for(int i=coins.length-1;i>=0;i--){
            for(int j=1;j<=amount;j++){
                // side
                int x = (j - coins[i] >= 0) ? dp[i][j - coins[i]] : 0;
                // vertically
                int y = (i+1 < coins.length) ? dp[i+1][j] : 0;
                dp[i][j] = x + y;
            }
        }
        return dp[0][amount];
    }
}