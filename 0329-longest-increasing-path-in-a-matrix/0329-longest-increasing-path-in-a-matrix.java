class Solution {
    public void gridLIP(int[][] matrix, int[][] dp, int i, int j){
        if(i == dp.length && j == 0) return;
        else{
            if(dp[i][j] != Integer.MIN_VALUE) return;
            else{
                int f=0;
                int val = Integer.MIN_VALUE;
                // left side
                if(j-1 >= 0 && matrix[i][j] < matrix[i][j-1]){
                    if(dp[i][j-1] == Integer.MIN_VALUE)
                        gridLIP(matrix, dp, i, j-1);
                    val = Math.max(val, 1 + dp[i][j-1]);
                    f=1;
                }
                // top side
                if(i-1 >= 0 && matrix[i][j] < matrix[i-1][j]){
                    if(dp[i-1][j] == Integer.MIN_VALUE)
                        gridLIP(matrix, dp, i-1, j);
                    val = Math.max(val, 1 + dp[i-1][j]);
                    f=1;
                }
                // right side
                if(j+1 < matrix[0].length && matrix[i][j] < matrix[i][j+1]){
                    if(dp[i][j+1] == Integer.MIN_VALUE)
                        gridLIP(matrix, dp, i, j+1);
                    val = Math.max(val, 1 + dp[i][j+1]);
                    f=1;
                }
                // bottom side
                if(i+1 < matrix.length && matrix[i][j] < matrix[i+1][j]){
                    if(dp[i+1][j] == Integer.MIN_VALUE)
                        gridLIP(matrix, dp, i+1, j);
                    val = Math.max(val, 1 + dp[i+1][j]);
                    f=1;
                }
                if(f == 0) dp[i][j] = 1;
                else{
                    dp[i][j] = val;
                    f=0;
                }
                if(j == matrix[0].length-1){
                    j=0;
                    i++;
                }
                else j++;
                gridLIP(matrix, dp, i, j);
            }
        }
    }
    public int longestIncreasingPath(int[][] matrix) {
        int dp[][] = new int[matrix.length][matrix[0].length];
        for(int i[]: dp) Arrays.fill(i, Integer.MIN_VALUE);
        gridLIP(matrix, dp, 0, 0);
        int res = Integer.MIN_VALUE;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++)
                res = Math.max(res, dp[i][j]);
        }
        return res;
    }
}