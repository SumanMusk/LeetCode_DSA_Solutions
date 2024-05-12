class Solution {
    public int[][] largestLocal(int[][] grid) {
        int[][] ans = new int[grid.length-2][grid[0].length-2];
        for(int i=1;i<grid.length-1;i++) {
            for(int j=1;j<grid[0].length-1;j++) {
                int val=Integer.MIN_VALUE;
                for(int x=i-1;x<((i-1)+3);x++) 
                    for(int y=j-1;y<((j-1)+3);y++) 
                        val = Math.max(val, grid[x][y]);
                ans[i-1][j-1] = val;
            }
        }
        return ans;
    }
}