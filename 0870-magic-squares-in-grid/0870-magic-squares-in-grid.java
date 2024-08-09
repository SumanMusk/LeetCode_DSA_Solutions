class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int c=0;
        for(int i=0;i<grid.length;i++) 
            for(int j=0;j<grid[0].length;j++) 
                if(i+2 < grid.length && j+2 < grid[0].length)
                    if(helper(grid, i, j))
                        c++;
        return c;
    }
    public boolean helper(int[][] grid, int row, int col) {
        Set<Integer> set = new HashSet<>();
        for(int i=row;i<=row+2;i++) {
            for(int j=col;j<=col+2;j++) {
                if(grid[i][j] > 0 && grid[i][j] <= 9 && !set.contains(grid[i][j])) 
                    set.add(grid[i][j]);
                else
                    return false;
            }
        }
        int c=0, sum=Integer.MAX_VALUE;
        // Horizontally(rows)
        for(int i=row;i<=row+2;i++) {
            for(int j=col;j<=col+2;j++) 
                c += grid[i][j];
            if(sum == Integer.MAX_VALUE) 
                sum = c;
            if(sum != c)
                return false;
            c=0;
        }
        // Vertically(columns)
        for(int i=col;i<=col+2;i++) {
            for(int j=row;j<=row+2;j++) 
                c += grid[j][i];
            if(sum != c)
                return false;
            c=0;
        }
        int i=row, j=col;
        while(i <= row+2 && j <= col+2) 
            c += grid[i++][j++];
        if(sum != c)
            return false;
        c=0;
        i=row;
        j=col+2;
        while(i <= row+2 && j >= col) 
            c += grid[i++][j--];
        if(sum != c)
            return false;
        return true;
    }
}