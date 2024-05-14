class Solution {
    int res=0;
    public int getMaximumGold(int[][] grid) {
        for(int i=0;i<grid.length;i++) 
            for(int j=0;j<grid[0].length;j++) 
                if(grid[i][j] != 0) 
                    helperDFS(i, j, grid, 0);

        return res;
    }
    public void helperDFS(int i, int j, int[][] grid, int ans) {
        if(i < 0 || j < 0 || i == grid.length || j == grid[0].length || grid[i][j] == 0)
            return;
        ans += grid[i][j];
        int temp = grid[i][j];
        grid[i][j] = 0;

        helperDFS(i+1, j, grid, ans);
        helperDFS(i, j+1, grid, ans);
        helperDFS(i-1, j, grid, ans);
        helperDFS(i, j-1, grid, ans);

        res = Math.max(res, ans);
        ans -= temp;
        grid[i][j] = temp;
    }
}