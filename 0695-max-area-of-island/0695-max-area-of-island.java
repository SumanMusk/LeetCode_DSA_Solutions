class Solution {
    int count = 1;
    public int maxAreaOfIsland(int[][] grid) {
        int ans = 0;
        for(int x=0;x<grid.length;x++) {
            for(int y=0;y<grid[0].length;y++) {                
                if(grid[x][y] == 1) {
                    count = 1;
                    helper(grid, x, y);
                    ans = Math.max(ans, count);
                }
            }
        }
        return ans;
    }
    public void helper(int[][] grid, int i, int j) {
        if(grid[i][j] == 0)
            return;
        grid[i][j] = 0;
        // Top
        if(i-1 >= 0 && grid[i-1][j] != 0) {
            count++;
            helper(grid, i-1, j);
        }
        // Right
        if(j+1 < grid[0].length && grid[i][j+1] != 0) {
            count++;
            helper(grid, i, j+1);
        } 
        // Bottom
        if(i+1 < grid.length && grid[i+1][j] != 0) {
            count++;
            helper(grid, i+1, j);
        }
        // Left
        if(j-1 >= 0 && grid[i][j-1] != 0) {
            count++;
            helper(grid, i, j-1);
        }
    }
}