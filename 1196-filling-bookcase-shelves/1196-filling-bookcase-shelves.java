class Solution {
    int mainW;
    public int solve(int i, int currW, int maxH, int books[][], int[][] dp) {
        if(i == books.length)
            return maxH;
        if(dp[i][currW] != 0)
            return dp[i][currW];
        int keep = Integer.MAX_VALUE;
        int skip = Integer.MAX_VALUE;
        if(books[i][0] <= currW)
            keep = solve(i+1, currW-books[i][0], Math.max(maxH, books[i][1]), books, dp);
        skip = maxH + solve(i+1, mainW-books[i][0], books[i][1], books, dp);
        dp[i][currW] = Math.min(keep, skip);
        return dp[i][currW];
    }
    public int minHeightShelves(int[][] books, int shelfWidth) {
        int dp[][] = new int[books.length][shelfWidth+1];
        mainW = shelfWidth;
        return solve(0, shelfWidth, 0, books, dp);
    }
}