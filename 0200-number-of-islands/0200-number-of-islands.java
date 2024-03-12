class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        for(int x=0;x<grid.length;x++) {
            for(int y=0;y<grid[0].length;y++) {                
                if(grid[x][y] == '1') {
                    helper(grid, x, y);
                    count++;
                }
            }
        }
        return count;
    }
    public void helper(char[][] grid, int i, int j) {
        if(grid[i][j] == '0')
            return;
        grid[i][j] = '0';
        // Top
        if(i-1 >= 0 && grid[i-1][j] != '0')
            helper(grid, i-1, j);
        // Right
        if(j+1 < grid[0].length && grid[i][j+1] != '0')
            helper(grid, i, j+1);
        // Bottom
        if(i+1 < grid.length && grid[i+1][j] != '0')
            helper(grid, i+1, j);
        // Left
        if(j-1 >= 0 && grid[i][j-1] != '0')
            helper(grid, i, j-1);
    }
}
// With Extra Space, where when we visit each current indexed element of the given matrix, then we 
// mark the current element as visited with the help of 2D boolean matrix `visited`
/*class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        boolean visited[][] = new boolean[grid.length][grid[0].length];
        for(int x=0;x<grid.length;x++) {
            for(int y=0;y<grid[0].length;y++) {                
                if(!visited[x][y] && grid[x][y] == '1') {
                    helper(grid, visited, x, y);
                    count++;
                }
            }
        }
        return count;
    }
    public void helper(char[][] grid, boolean[][] visited, int i, int j) {
        if(visited[i][j])
            return;
        visited[i][j] = true;
        // Top
        if(i-1 >= 0 && grid[i-1][j] != '0')
            helper(grid, visited, i-1, j);
        // Right
        if(j+1 < grid[0].length && grid[i][j+1] != '0')
            helper(grid, visited, i, j+1);
        // Bottom
        if(i+1 < grid.length && grid[i+1][j] != '0')
            helper(grid, visited, i+1, j);
        // Left
        if(j-1 >= 0 && grid[i][j-1] != '0')
            helper(grid, visited, i, j-1);
    }
}*/